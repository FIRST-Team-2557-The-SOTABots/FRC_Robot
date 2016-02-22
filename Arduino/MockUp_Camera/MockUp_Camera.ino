#include <Wire.h>

#include <Adafruit_NeoPixel.h>
#ifdef __AVR__
  #include <avr/power.h>
#endif

#define PIN 6

// DEFINE MODES
#define MODE_YELLOW 0
#define MODE_PULSATINGYELLOW 1;

#define MODE_RED 2;
#define MODE_PULSATINGRED 3;
#define MODE_PULSATINGYELLOWRED 4;

#define MODE_BLUE 5;
#define MODE_PULSATINGBLUE 6;
#define MODE_PULSATINGYELLOWBLUE 7;

#define MODE_GROOVY 8;

int Mode = MODE_YELLOW;
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

  sonar(strip.Color(0, 0, 200), 40, 8);
}

void loop() {
  while(Serial.available()) {
    char inChar = Serial.read();
    String inString = "";
    inString += inChar;

    Mode = inString.toInt();
  }

  if(currentMode != Mode) {
    switch(Mode) {
      case MODE_YELLOW:
        colorWipe(strip.Color(200, 200, 0), 80);
        break;
      case MODE_PULSATINGYELLOW:
        pulse(200, 200, 0, 200);
        break;
        
      case MODE_RED:
        colorWipe(strip.Color(200, 0, 0), 80);
        break;
      case MODE_PULSATINGRED:
        pulse(200, 0, 0, 200);
        break;
      case MODE_PULSATINGYELLOWRED:
      
        break;
        
      case MODE_BLUE:
        colorWipe(strip.Color(0, 0, 200), 80);
        break;
      case MODE_PULSATINGBLUE:
        pulse(0, 0, 200, 200);
        break;
      case MODE_PULSATINGYELLOWBLUE:
      
        break;

      case MODE_GROOVY:
        // GROOVY!
        break;
    }
    currentMode = Mode;
  }
  if(Mode == 0 && currentMode != Mode){
    colorWipe(strip.Color(200, 0, 200), 100); //Purple
    currentMode = Mode;
  }else if(Mode == 

  colorWipeUpdate();
  sonarUpdate();
  pulseUpdate();

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

// A light pattern that goes back and forth
uint32_t sonar_c;
uint8_t sonar_wait;
unsigned long sonar_timer;
int sonar_i;
int sonar_max;
void sonar(uint32_t c, uint8_t wait, int leds) {
  sonar_c = c;
  sonar_wait = wait;
  sonar_timer = 0;
  sonar_i = 0;
  sonar_max = leds;
}
void sonarUpdate() {
  if(millis() - sonar_timer > sonar_wait) {
    strip.setPixelColor(sonar_i, strip.Color(0, 0, 0));
    int realI = sonar_i++;
    while(realI >= sonar_max) {
      realI -= sonar_max;
    }
    strip.setPixelColor(realI, sonar_c);
    strip.show();
    
    sonar_timer = millis();
  }
}

// A pulsating color
uint8_t pulse_r;
uint8_t pulse_g;
uint8_t pulse_b;
unsigned long pulse_duration;
void pulse(uint8_t r, uint8_t g, uint8_t b, uint8_t duration) {
  pulse_r = r;
  pulse_g = g;
  pulse_b = b;
  pulse_duration = duration;
}
void pulseUpdate() {
  for(int i = 0; i < strip.numPixels(); i++) {
    strip.setPixelColor(pulse_i, pulse_r * (sin(millis() / pulse_duration) + 1 / 2) * 200, pulse_g * (sin(millis() / pulse_duration) + 1 / 2) * 200, pulse_b * (sin(millis() / pulse_duration) + 1 / 2) * 200);
  }
  strip.show();
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
