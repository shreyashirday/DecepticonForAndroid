DecepticonForAndroid
====================

An Android-Bluetooth SDK for controlling a [DFROBOT Pirate 4WD Robot](http://www.dfrobot.com/index.php?route=product/product&product_id=97)

Inspiration
===========

This project was inspired by the [Decepticon-SDK](https://github.com/RutgersRoboticsResearch/Decepticon-SDK) developed by Timothy Yong and Jonathon Risinger from Rutgers University -- an SDK for
controlling the Pirate Robot through a Raspberry Pi using Serial

Required Hardware
==================
1. The DFROBOT Pirate 4WD Robot
2. An [Arduino Uno](http://arduino.cc/en/Main/arduinoBoardUno) with an [Arduino USB cable](http://www.amazon.com/gp/product/B001TH7GUA/ref=oh_aui_detailpage_o04_s01?ie=UTF8&psc=1)
3. Any Bluetooth Module for the Arduino( I used [this](http://www.ebay.com/itm/1PCS-HC-06-Arduino-Wireless-Bluetooth-Transeiver-RF-Module-Serial-4Pin-Port-line-/271305987900)
4. A breadboard, jumper wires, a 9V battery with a battery cap, and a portable cell phone battery like [this](http://www.amazon.com/PNY-BD2600-2600mAh-Amp-PowerPack/dp/B00A5C4QDK)
5. A [Dual H-Bridge Motor Driver for DC or Steppers - 600mA - L293D](http://www.adafruit.com/blog/2012/05/01/new-product-dual-h-bridge-motor-driver-for-dc-or-steppers-600ma-l293d/)
6. An [HC-SR04 UltraSonic Module](http://www.amazon.com/SainSmart-HC-SR04-Ranging-Detector-Distance/dp/B004U8TOE6)
7. And obviously, an Android phone with a micro-usb cable

Required Software
=================
1. Android 
2. Android Studio
3. Arduino IDE

Steps
=====

1. Assemble the Pirate Robot - use the manual and this (video)[https://opensourcehardwaregroup.com/assemble-dfrobot-pirate-4wd-mobile-platform/)
   but do NOT mount the Arduino yet and do NOT put the very top platform on. Also, you don't NEED to solder the wires, you can just use elctrical
   tape, but soldering reduces the most noise
2. After you're done assembling the robot pull all the wires (except for the battery pack wires) through the openings of the top
   of the robot
3. Now grab your breadboard and place the H-Bridge chip on it. Using this [diagram](https://itp.nyu.edu/physcomp/wp-content/uploads/hbridge_labpinout.jpg), connect Vcc2 to the positive wire of the 9V battery (after placing the batterycap on the 9V battery) 
    and connect the rest of the three corners to POWER (red) strip of the breadboard. Connect the "Heat Sink and Ground" to GROUND (blue). Now, on your robot, tape or solder the negative wire of the top left motor to the positive wire of the bottm left
    motor. Do the same for the right motors. Now assume that each side is one big motor and put the top free wire on the left side in 1Y and the bottom into 2Y.
    Do the same for the right side, but into 3Y and 4Y instead. Now connect pins 9 and 10 of the Arduino to 2A and 1A, respectively. Connect pins 5 and 6 to 3A and 4A, respectively.
    Finally, connect the Arduino 5V pin to the POWER strip of the breadboard and one of the GND pins to the GROUND strip. Connect the BLACK wire of the 9V pattery to the GROUND strip as well.
4. Now, place the Bluetooth Module on the breadboard and connect VCC to the breadboard's POWER strip and GND to the breadboard's GROUND strip. Connect RX to the Arduino's TX pin and TX to the Arduino's RX pin.
5. Now, place the UltraSonic module on the breadboard and again, connect VCC to POWER and GND to GROUND. Connect Trig to the Arduino's pin 12 and Echo to pin 11
6. Go to the Amarino downloads [website](http://www.amarino-toolkit.net/index.php/download.html) and a) Download the Amarino app (here is a good [link](http://www.talkandroid.com/guides/beginner/install-apk-files-on-android/) on how to download APK's)
    and b) download the MeetAndroid Arduino library and on your Arduino IDE go to Sketch>Import Library>Add Library> and add the MeetAndroid library
7. Download the source code from this repository, open 'RobotControl.ino' from the 'arduino' folder, connect your Arduino to your computer, and upload the program onto the Arduino
8. Open Android Studio, go to File>Import Project> and choose the folder containing the source code from this repository
9. Make sure that your Arduino is connected to your computer or another power source and that the light on the Bluetooth module is blinking
10. Open up the bluetooth settings on your Android phone and pair it with your bluetooth module, it will most likely say HC-06 if you're using the one I did and the password is usually 0000 or 1234
11. Open up the Amarino app and note the address (which will look something like XX:XX:XX:XX:XX:XX). The, use it for 'DEVICE_ADDRESS' in 'MainActivity.java' and 'ManualOverride.java' in Android Studio
12. If you want to make your robot move autonomously, simply use the Decepticon object's methods and fill in the code of the 'automate' method in 'MainActivity.java'
13. Install the RobotControl app on your Android phone by connecting your phone to your computer with the micro-usb cable and clicking "Run" on Android Studio
14. Go back to the Amarino app and click "Connect" next to your bluetooth modules name. The light on your bluetooth module should now have stopped blinking and should just be constant.
15. Go back to the RobotControl app and click "Start" if you filled the 'automate' method out or click "Manual Override" to use your phone like a remote control.
16. Enjoy!!!

Contact
=======

If you have any questions or issues, email me at shreyashirday@gmail.com or message me on Facebook!

TODO
====
1. Add Camera support
2. Add Claw support
3. Upload a video demonstration?
    
