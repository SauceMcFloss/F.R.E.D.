# Program Organization

[System Archtecture Diagram](https://github.com/COP4331Group12/F.R.E.D./blob/master/Group%20Twelve%20Project%20System%20Architectural%20Diagram.JPG)

| Component | Description| User Stories Satisfied|
|---------|--------------------------| ----------|
| RC Car | A remotely controlled car that contains batteries, an engine, wheels, and a frame with which to run. | 000 - 007  |
| Arduino Board | A board placed upon the RC Car that changes the RC Car's movements based on values input from the User Application| | 
| Server | Set up on wifi, the server allows communication between the user application on a coputer and the arduino board | 006, 007, 008 |
| Camera | Also set up on wifi, the camera records live feed and sends it to the user application in real time. | 001, 002, 005 |
| User Application | This application is broken into several components: a classifier, a set of functions which sends values to the Arduino Board, and a user interface that accepts user inputs and changes the values of the functions sent to the Arduino board | 003, 004, 005, 006 |

Our project has five main components: the user interface that the user sees, a controller paired with the user interface that the accepts the user's inputs, an Arduino board that remotely reads those user inputs and outputs movement for the RC car, a camera which sends live feed back to the computer, and then an additional classifier which parses the camera's live feed and can send instructions autonomously to the Arduino board itself.

# Major Classes
[Major Classes Document](https://github.com/COP4331Group12/F.R.E.D./blob/master/Markdown/MajorClasses.md)
# Data Design

* Since each driving 'session' does not require any prior information, data persistance is not really applicable. The only type of data persistance we plan on doing is recording the debug console as a text or json file written to the disc before application close.

# Business Rules
Business rules will likely not apply to this particular project because we are not creating a commodity that will be marketed, nor are we creating a business to market such an item.
# User Interface Design
[Manual Control](https://github.com/COP4331Group12/F.R.E.D./blob/master/Images/User_Interface_Car_Control.png) is shown here.
[Autonomous Control](https://github.com/COP4331Group12/F.R.E.D./blob/master/Images/User_Interface_Start_Button.png) is shown here.

Our user will open an application that has the aforementioned interface and will be able to choose between autonomous and manual controls. If autonomous control is selected, after toggling Start, the car will automatically begin driving forward and will respond to signs its camera reads. If manual control is selected, the user will be presented with a list of options to drive forward, backward, or turn.

# Resource Management
Our priority for this sprint is obtaining all the hardware required for the project (rc car, arduino, cameras) as well as setting up the classes and the github for shared working purposes. Because we are only working on one project, formal resource management is less important than it ordinarily would be if we had multiple projects.

We will meet every Tuesday and Thursday for two hours between 4 PM to 6 PM in order to ensure people are obtaining the hardware they are assigned to get as well as the classes they are supposed to design.
# Security
Not many security features need to be implemented. However, we will have a username and password for the webcam feed to the computer, and in the event that we do want to produce this program for other RC Cars to run on, we will likely need to implement some measure of security so that the RC car cannot be intercepted and controlled by another signal.

# Performance
Because the RC car has multiple parts that need to run in real time, we will need our systems to be fast enough to compute in real time as well. Specifically, we want the refresh rate for our camera to be at least 30 frames per second, and we want our neural network to be able to recognize signals quickly enough to respond to them before passing them completely.

# Scalability
* Capability for multiple car profiles
* Ability to add more signs to train the neural network on

# Interoperability
* Arduino to PC - Wifi
* camera to PC - Wifi -> URL

# Internationalization/Localization
We will not be supporting translating our project into languages other than English.

# Error Processing
* We will use a combination of exceptions and assertions.
* If an issue exists with inputs for car functions, program will stop the car.
* If issue will cause crash or major problem on the computer side, program stop the car before exiting.
* minor issues will be handled on a case by case basis
# Fault Tolerance
* We adopted a very strict error resolution policy for this project, completely stopping the  car in order to recalibrate any errors. Our specific fault tolerances are listed below.

* User Interface
    * Any user interface errors that are caught will not close the user interface application. Instead we will log any errors into the debug console.

* Camera
    * If we recieve corrupted or invalid camera data we will adopt the "Last valid" resolution policy. That is taking the last valid frame until we recieve a valid frame to show in the feed.

* Arduino
    * Any faults detected that directly affect the operation of the car will result in a 'stop' method to be called to halt the car from performing any further action. We will log any errors to the debug console and attempt to recalibrate, then start again on user command.

# Architectural Feasibility
While certainly not an easy task, the development of a autonomous, neural network-driven RC car is not a new endeavor. Because we have been able to procure our hardware quickly, and because we have access to an RC car already as well as examples of other people successfully building neural networks we have deemed this particular project feasible.
 
# Overengineering
* build with a margin of safety for the cars capabilites 
  * car will be capable of going faster than we will ever set it to do

# Build-vs-Buy Decisions
* Buy Arduino with wifi capablities ($40)
* Use a R.C. we have access to
* Use a Android phone we have access to

# Reuse
While this project is our first Agile project and we therefore don't have user stories or previous requirements to use from other projects, we will be creating utility classes that can be shared between different packages with similarities, (such as the driving between autonomous and manual driving).

# Change Strategy
* If change is easily implementable then 
  * build unit tests
  * build code
  * unit test
  * regression testing
