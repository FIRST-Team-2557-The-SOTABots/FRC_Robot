# SOTABots2016
This is the main java project for the Robot code of 2016. It uses [GradleRIO](https://github.com/Open-RIO/GradleRIO) for efficient build tasks.

## Running with the Command Line
The easiest way to get the code up and running is to use the command line. Gradle allows the WPI code to be deployed to the robot with ease and without Eclipse.

__NOTE:__ If you are a fellow FIRST team deploying this code on your robot, it is _essential_ that you change "gradlerio.team" and "gradlerio.rioIP" to your team number!

It is critical that the **JAVA_HOME** environment variable ***must*** be set to JDK 8!

Make sure that your terminal/command prompt is in the same directory as this README!

### Setting up WPI
You should only need to set up WPI once when first deploying and when WPI updates are released.
```
./gradlew wpi   # MAC/LINUX!
gradlew wpi   # WINDOWS!
```

### Deploying to the RoboRIO
This deploys code to the Robot and restarts the robot code to be used immediately.
```
./gradlew deploy   # MAC/LINUX!
gradlew deploy   # WINDOWS!
```

### Restarting the robot code
This restarts the robot code on the RoboRIO, while not restarting the RoboRIO itself. This is faster than restarting the RoboRIO.
```
./gradlew restart   # MAC/LINUX!
gradlew restart   # WINDOWS!
```

### Rebooting the RoboRIO
This completely restarts the RoboRIO, not just the robot code.
```
./gradlew reboot   # MAC/LINUX!
gradlew reboot   # WINDOWS!
```

### Clean the robot code on the RoboRIO
This cleans the RoboRio, removing the java files that are already on the RoboRIO. This is useful for debugging.
```
./gradlew cleanRIO   # MAC/LINUX!
gradlew cleanRIO   # WINDOWS!
```

## Importing to an IDE
Gradle projects can be easily imported into a wide variety of IDEs that support Gradle, including IntelliJ IDEA, Eclipse, and Netbeans.

### IntelliJ IDEA
This assumes that you already have IntelliJ IDEA set up for Java 8 development.

1. Click "Open..." and browse for the "build.gradle" file in this directory.
2. In the next step, make sure that "Gradle JVM" is pointed to your local copy of JDK 8. The WPI libraries run on Java 8.
3. IntelliJ IDEA should build Gradle and begin updating your local maven repository. Allow it to finish before continuing.
4. Find the drop-down on the upper-right side of IntelliJ IDEA and click "Edit Configurations..."
5. Click the "+" sign, and select "Gradle". Name the task "Deploy to RoboRIO"
6. Click the ellipses next to "Gradle project" and select "SOTABots2016"
7. In tasks, write: "deploy". Make sure to click "Apply" before closing out the configurations window.

Congratulations, IntelliJ is now set up! You can click the green arrow in the upper-right side of IntelliJ IDEA to deploy code on the RoboRIO.

### Eclipse
This assumes that you already have Eclipse set up for Java 8 development.

1. Right-click in the "Project Explorer" pane and select "Import..."
2. Under "Gradle", select "Gradle Project" and click next.
3. Browse for this directory (containing the "build.gradle"), and click next.
4. Under "Java home directory" browse for your local JDK 8 home, if necessary. Click finish.

To deploy code to the robot...

1. If a pane named "Gradle Tasks" does not exist, you can open it via "Window>>Show View>>Other>>Gradle>>Gradle Tasks". Gradle Tasks shows all the tasks that can be executed.
2. Double-click "deploy" to deploy code to the Robot.
