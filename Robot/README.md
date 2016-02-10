# Robot
This is the main java project for the Robot code of 2016. It uses [GradleRIO](https://github.com/Open-RIO/GradleRIO) for efficient build tasks.

## Importing to an IDE
Gradle projects can be easily imported into a wide variety of IDEs that support Gradle, including IntelliJ IDEA, Eclipse, and Netbeans. **You must have your JAVA_HOME set to a JDK 8 installation directory!! Instructions for Windows can be found [here](https://confluence.atlassian.com/doc/setting-the-java_home-variable-in-windows-8895.html), Mac (and Ubuntu) [here](http://devble.com/setting-environment-variables-in-mac-mavericks/).**

### IntelliJ IDEA
This assumes that you already have IntelliJ IDEA set up for Java 8 development.

1. Click "Open..." and browse for the "build.gradle" file in this directory.
2. In the next step, make sure that "Gradle JVM" is pointed to your local copy of JDK 8. The WPI libraries run on Java 8.
3. IntelliJ IDEA should build Gradle and begin updating your local maven repository. Allow it to finish before continuing.
4. Find the drop-down on the upper-right side of IntelliJ IDEA and click "Edit Configurations...".
5. Click the "+" sign, and select "Gradle". Name the task "Deploy to RoboRIO".
6. Select "Robot" for "Gradle project".
7. In tasks, write: "deploy". Make sure to click "Apply" before closing out the configurations window.

Congratulations, IntelliJ is now set up! You can click the green arrow in the upper-right side of IntelliJ IDEA to deploy code on the RoboRIO.

### Eclipse
You can either import the project in using Gradle, **OR**:

1. In Windows Explorer, browse to the "tools" folder of the folder containing this README.
2. Browse into the folder of the operating system you are using.
3. Double-click on "eclipse_init" to execute the Eclipse project generator (unix machines will have to run the scripts in the terminal using "sh").
4. After the script has completed, right-click in the "Project Explorer" of Eclipse and select "Import...".
5. Under "General", select "Existing Projects into Workspace", and browse for this directly as an existing project.

**To deploy code to the RoboRIO...**

1. Either from Eclipse or Windows Explorer, open the "tools/windows" folder
2. Execute "deploy" by double-clicking on the batch file. If the deploy fails, and the error is **not** from the computer being disconnected from the RoboRIO, make sure you are connected to the internet so that Gradle can download the WPI libraries. Further deploys can be executed without internet access.

## Command Line
The easiest way to get the code up and running is to use the command line. Gradle allows the WPI code to be deployed to the robot with ease and without Eclipse.

__NOTE:__ If you are a fellow FIRST team deploying this code on your robot, it is _essential_ that you change "gradlerio.team" and "gradlerio.rioIP" to your team number!

It is critical that the **JAVA_HOME** environment variable ***must*** be set to JDK 8!

Make sure that your terminal/command prompt is in the same directory as this README!

### Deploying to the RoboRIO
This deploys code to the Robot and restarts the robot code to be used immediately.
```
./gradlew deploy   # MAC/LINUX!
gradlew deploy     # WINDOWS!
```

### Restarting the robot code
This restarts the robot code on the RoboRIO, while not restarting the RoboRIO itself. This is faster than restarting the RoboRIO.
```
./gradlew restart   # MAC/LINUX!
gradlew restart     # WINDOWS!
```

### Rebooting the RoboRIO
This completely restarts the RoboRIO, not just the robot code.
```
./gradlew reboot   # MAC/LINUX!
gradlew reboot     # WINDOWS!
```

### Clean the robot code on the RoboRIO
This cleans the RoboRIO, removing the java files that are already on the RoboRIO. This is useful for debugging.
```
./gradlew cleanRIO   # MAC/LINUX!
gradlew cleanRIO     # WINDOWS!
```
