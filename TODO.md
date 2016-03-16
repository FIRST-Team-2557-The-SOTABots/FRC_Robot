 # To Do
This file contains a list of everything that programmers need to complete during the 2016 season. This file is to be modified as needed.

### Arm
[x] Test "potentiometer speed"s on the actuators
[x] Determine the max potentiometer speed
[x] Set the actuators on a PID for potentiometer speed (this will raise/lower both actuators at the same rate)
[ ] Determine actuator potentiometer voltage [on the competition bot] for putting the hook onto the bar
[ ] Determine actuator potentiometer voltage [on the competition bot] for releasing the second arm
[ ] Determine actuator potentiometer volatge [on the competition bot] for allowing the camera to see through the arm (when it's close to the floor)

### Climber
[x] Reassign buttons for the winch and secondary arm release

### Autonomous
[ ] Test robot driving straight
[ ] Test distance drive [scrap & modify autos if distance estimation does not work]
[ ] Test Low Bar auto with distance
[ ] Test Chival de Frise auto with distance
[ ] Test Portcullis auto with distance
[ ] Test Rough Terrain auto with distance
[ ] Test Rock Wall auto
[ ] Test Rampards auto
[ ] Test Moat auto

### Automation
[ ] Modify the Load Ball automation [on the competition bot] to work with the new bucket
[x] Attach Load Ball automation to the manipulator's gamepad

### Vision
[x] Set the Pi's IP to a static 10.25.57.11 [to hopefully have it show up on the SmartDashboard]
[ ] Switch the driver stations to use SmartDashboard SFX [to have the correct widget for viewing the camera]
[x] Modify current vision correction commands to use PIDs
[ ] Test vision tracking and determine offset from center of camera to line up robot with high goal
[ ] Add vision tracking to the end of all autonomous modes
[ ] Attach correction commands to the manipulator's gamepad [and a cancel button]
[ ] Create and attach command to shoot if lined up [for when we are being pushed around, the robot will shoot if they happen to push us in a correct position to shoot]

### Lidar
[ ] Implement algorithms for looking at angles ahead of the robot
[ ] Write a plugin for SFX to view Lidar distances
[ ] ... ... ...
