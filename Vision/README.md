# Vision

In 2016, vision will be processed on a Raspberry Pi 2. [GRIP](https://github.com/WPIRoboticsProjects/GRIP/wiki/Running-GRIP-on-a-Raspberry-Pi-2) is a visual vision processing helper that is fast and easy to use. Some members of the GRIP community have built GRIP for the Raspberry Pi 2 (Raspberry Pi 1 has a hardware restriction, and Raspberry Pi 3 is 64-bit while the binaries for the Raspberry Pi 2 are 64-bit.

## Overview
After setting up the Pi to work on the FRC field (setting the Pi and RoboRIO's static IPs), [mjpg-streamer](https://github.com/jacksonliam/mjpg-streamer) will be used to turn a USB camera/Pi cam into a network camera. This allows the driver station to view the camera stream from a web browser (or the SmartDashboard SFX). Next, GRIP will be installed using the community built binaries (Java . Finally, startup scripts will be created to start mjpg-streamer and GRIP when the Pi is turned on.

## Prerequisites
This README assumes that you already have a clean installation [Rasbian Jessie Lite](https://www.raspberrypi.org/downloads/raspbian/) on a Micro SD card and that you have a basic understanding of [GNU nano](http://www.howtogeek.com/howto/42980/the-beginners-guide-to-nano-the-linux-command-line-text-editor). While the lite version of Jessie is not required, it does give more space on the SD card (all the pre-installed software, like Python, Scratch, and the desktop, take up space and are not necessary for this application). Instructions may differ in later versions of Rasbian.

## Setting up the Pi
1. Attach a monitor, internet connection, and keyboard to the Pi. Boot the Pi, and login (default username/password is pi/raspberry).
2. Run the configuration (```sudo raspi-config```). Expand the file system to fill the entire SD card. Enable the Pi camera. Set the Pi to login on boot. Reboot the Pi.
3. Change the hostname
  * ```sudo nano /etc/hostname```
  * Replace *raspberrypi* with *raspberrypi-2557*
  * Write the file and exit nano
  * ```sudo nano /etc/hosts```
  * Leave all of the entries alone except for the very last entry labeled *127.0.1.1* with the hostname *raspberrypi*. This is the only line you want to edit. Replace *raspberrypi* with *raspberrypi-2557*
  * Write the file and exit nano
  * Reboot the Pi
  * __You may now SSH into the Pi using the hostname *raspberrypi-2557.local*__
4. Perform updates
  * ```sudo apt-get update```
  * ```sudo apt-get upgrade```
5. Install GNU screen
  * ```sudo apt-get install screen```
5. Setting a static IPv4
  * ```sudo nano /etc/dhcpcd.conf```
  * At the bottom of the file, enter the following:
    ```
    interface eth0
    static ip_address=10.25.57.11/8
    static routers=10.25.57.1
    ```
  * Write the file and exit nano
  * Reboot the Pi
  * Execute ```ifconfig``` to ensure that the ethernet (eth0) IP address is set to "10.25.57.11". If not, go on the internet and search for 4 days trying to figure out how to set static IP addresses on Rasbian Jessie. ;)
6. Make a directory for vision
  * ```cd /home/pi```
  * ```mkdir vision```

### Installing mjpg-streamer
1. Install git: ```sudo apt-get install git```
2. Install cmake: ```sudo apt-get install cmake```
3. Install libjpeg8-dev: ```sudo apt-get install libjpeg8-dev```
4. Navigate to the ```vision``` directory: ```cd /home/pi/vision```
5. Clone mjpg-streamer: ```git clone https://github.com/jacksonliam/mjpg-streamer.git```
6. ```cd mjpg-streamer/mjpg-streamer-experimental
7. Build mjpg-streamer ```make clean all```
8. Install mjpg-streamer ```sudo make install```
9. Navigate to the ```vision``` directory: ```cd /home/pi/vision```
10. ```nano start_stream.sh```
11. Enter the following into the file (for USB camera): ```screeen -dS mjpg_streamer mjpg_streamer -o "output_http.so -w ./www -p 443" -i "input_uvc.so -d /dev/video0 -f 15 -r 640x480 -y -n"```
  * To use the Pi cam, enter the following into the file instead: ```screen -dS mjpg-streamer nv LD_LIBRARY_PATH=/usr/local/lib:$LD_LIBRARY_PATH mjpg_streamer -o "output_http.so -w ./www -p 443" -i "input_raspicam.so -fps 15 -r 640x480"```
13. Write the file and exit nano

**AT THIS POINT THE DRIVER STATION CAN BE USED TO PROCESS VISION!** If this is the stopping point, do the following. If not, move on.
1. ```sudo nano /home/pi/.profile```
2. At the bottom of the file, add the following: ```sh /home/pi/vision/start_stream.sh```

### Installing GRIP
TODO!

### Startup scripts
TODO!
