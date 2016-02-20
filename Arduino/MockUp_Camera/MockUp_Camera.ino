#include <Wire.h>

#include <Adafruit_NeoPixel.h>
#ifdef __AVR__
  #include <avr/power.h>
#endif

#define PIN 6

int Mode = 3;
int currentMode = -1;

// Parameter 1 = number of pixels in strip
// Parameter 2 = Arduino pin number (most are valid)
// Parameter 3 = pixel type flags, add together as needed:
//   NEO_KHZ800  800 KHz bitstream (most NeoPixel products w/WS2812 LEDs)
//   NEO_KHZ400  400 KHz (classic 'v1' (not v2) FLORA pixels, WS2811 drivers)
//   NEO_GRB     Pixels are wired for GRB bitstream (most NeoPixel products)
//   NEO_RGB     Pixels are wired for RGB bitstream (v1 FLORA pixels, not v2)
//   NEO_RGBW    Pixels are wired for RGBW bitstream (NeoPixel RGBW products)
Adafruit_NeoPixel strip = Adafruit_NeoPixel(60, PIN, NEO_GRB + NEO_KHZ800);

// IMPORTANT: To reduce NeoPixel burnout risk, add 1000 uF capacitor across
// pixel power leads, add 300 - 500 Ohm resistor on first pixel's data input
// and minimize distance between Arduino and first pixel.  Avoid connecting
// on a live circuit...if you must, connect GND first.

void setup() { 
  Serial.begin(9600);
  
  Wire.begin(8);
  Wire.onReceive(receiveEvent);

  strip.begin();
  strip.show(); // Initialize all pixels to 'off'
}

void loop() {
  while(Serial.available()) {
    char inChar = Serial.read();
    if(inChar == '0') {
      Mode = 0;
    }else if(inChar == '1') {
      Mode = 1;
    }else if(inChar == '2') {
      Mode = 2;
    }else if(inChar == '3') {
      Mode = 3;
    }else if(inChar == '4') {
      Mode = 4;
    }
  }
  
  // Some example procedures showing how to display to the pixels:
//colorWipe(strip.Color(0, 0, 0, 255), 50); // White RGBW
//Mode = 0: Not aimed at Goal
//Mode = 1: Aimed at Goal
  if(Mode == 0 && currentMode != Mode){
    colorWipe(strip.Color(200, 0, 200), 150); //Purple
    currentMode = Mode;
  }
  if(Mode == 1 && currentMode != Mode){
    colorWipe(strip.Color(0, 200, 0), 150); //Green
    currentMode = Mode;
  }
  if(Mode == 2 && currentMode != Mode){
    colorWipe(strip.Color(255, 50, 0), 150); //Orange
    currentMode = Mode;
  }
  if(Mode == 3 && currentMode != Mode){
    colorWipe(strip.Color(200, 200, 0), 45); //Safety Yellow
    currentMode = Mode;
  }
  if(Mode == 4 && currentMode != Mode){
    colorWipe(strip.Color(0, 0, 0), 45); //Nothing
    currentMode = Mode;
  }

  colorWipeUpdate();

  delay(50);
}

void receiveEvent(int howMany) {
  while(Wire.available() > 0) {
    byte inByte = Wire.read();
    Mode = inByte;
  }
}

// Fill the dots one after the other with a color
uint32_t colorWipe_c;
uint8_t colorWipe_wait;
unsigned long colorWipe_timer;
int colorWipe_i;
void colorWipe(uint32_t c, uint8_t wait) {
  colorWipe_c = c;
  colorWipe_wait = wait;
  colorWipe_i = 0;
  colorWipe_timer = 0;
}
void colorWipeUpdate() {
  if(millis() - colorWipe_timer > colorWipe_wait && colorWipe_i < strip.numPixels()) {
    strip.setPixelColor(colorWipe_i++, colorWipe_c);
    strip.show();
    colorWipe_timer = millis();
  }
}

void rainbow(uint8_t wait) {
  uint16_t i, j;

  for(j=0; j<256; j++) {
    for(i=0; i<strip.numPixels(); i++) {
      strip.setPixelColor(i, Wheel((i+j) & 255));
    }
    strip.show();
    delay(wait);
  }
}

// Slightly different, this makes the rainbow equally distributed throughout
void rainbowCycle(uint8_t wait) {
  uint16_t i, j;

  for(j=0; j<256*5; j++) { // 5 cycles of all colors on wheel
    for(i=0; i< strip.numPixels(); i++) {
      strip.setPixelColor(i, Wheel(((i * 256 / strip.numPixels()) + j) & 255));
    }
    strip.show();
    delay(wait);
  }
}

//Theatre-style crawling lights.
void theaterChase(uint32_t c, uint8_t wait) {
  for (int j=0; j<10; j++) {  //do 10 cycles of chasing
    for (int q=0; q < 3; q++) {
      for (int i=0; i < strip.numPixels(); i=i+3) {
        strip.setPixelColor(i+q, c);    //turn every third pixel on
      }
      strip.show();

      delay(wait);

      for (int i=0; i < strip.numPixels(); i=i+3) {
        strip.setPixelColor(i+q, 0);        //turn every third pixel off
      }
    }
  }
}

//Theatre-style crawling lights with rainbow effect
void theaterChaseRainbow(uint8_t wait) {
  for (int j=0; j < 256; j++) {     // cycle all 256 colors in the wheel
    for (int q=0; q < 3; q++) {
      for (int i=0; i < strip.numPixels(); i=i+3) {
        strip.setPixelColor(i+q, Wheel( (i+j) % 255));    //turn every third pixel on
      }
      strip.show();

      delay(wait);

      for (int i=0; i < strip.numPixels(); i=i+3) {
        strip.setPixelColor(i+q, 0);        //turn every third pixel off
      }
    }
  }
}

// Input a value 0 to 255 to get a color value.
// The colours are a transition r - g - b - back to r.
uint32_t Wheel(byte WheelPos) {
  WheelPos = 255 - WheelPos;
  if(WheelPos < 85) {
    return strip.Color(255 - WheelPos * 3, 0, WheelPos * 3);
  }
  if(WheelPos < 170) {
    WheelPos -= 85;
    return strip.Color(0, WheelPos * 3, 255 - WheelPos * 3);
  }
  WheelPos -= 170;
  return strip.Color(WheelPos * 3, 255 - WheelPos * 3, 0);
}
