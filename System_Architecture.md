# Program Organization

Populate each section with information as it applies to your project. If a section does not apply, explain why. Include diagrams (or links to diagrams) in each section, as appropriate. For example, sketches of the user interfaces along with an explanation of how the interface components will work; ERD diagrams of the database; rough class diagrams; context diagrams showing the system boundary; etc.

# Major Classes
[A list of the major classes are located here.](https://github.com/COP4331Group12/F.R.E.D./blob/master/MajorClasses.md)
# Data Design

# Business Rules
Business rules will likely not apply to this particular project because we are not creating a commodity that will be marketed, nor are we creating a business to market such an item.
# User Interface Design

# Resource Management
Our priority for this sprint is obtaining all the hardware required for the project (rc car, arduino, cameras) as well as setting up the classes and the github for shared working purposes. Because we are only working on one project, formal resource management is less important than it ordinarily would be if we had multiple projects.

We will meet every Tuesday and Thursday for two hours between 4 PM to 6 PM in order to ensure people are obtaining the hardware they are assigned to get as well as the classes they are supposed to design.
# Security
Not many security features need to be implemented. However, we will have a username and password for the webcam feed to the computer, and in the event that we do want to produce this program for other RC Cars to run on, we will likely need to implement some measure of security so that the RC car cannot be intercepted and controlled by another signal.

# Performance
Because the RC car has multiple parts that need to run in real time, we will need our systems to be fast enough to compute in real time as well. Specifically, we want the refresh rate for our camera to be at least 30 frames per second, and we want our neural network to be able to recognize signals quickly enough to respond to them before passing them completely.

# Scalability
* Capability for multiple car profiles
* Neural Network expandable through training

# Interoperability
* Arduino to PC - Wifi
* camera to PC - Wifi -> URL

# Internationalization/Localization
* Input
  * camera
  * user inputs through buttons on the UI
# Error Processing
* We will use a combination of exceptions and assertions.
* If an issue exists with inputs for car functions, program will stop the car.
* If issue will cause crash or major problem on the computer side, program stop the car before exiting.
* minor issues will be handled on a case by case basis
# Fault Tolerance

# Architectural Feasibility
* Technical Feasibility - While this project does have many parts, 
* Legal Feasibility -
* Economic Feasibility - 
* Scheduling Feasibility - 

# Overengineering
* build with a margin of safety for the cars capabilites 
  * car will be capable of going faster than we will ever set it to do

# Build-vs-Buy Decisions
* Buy Arduino with wifi capablities ($40)
* Use a R.C. we have access to
* Use a Android phone we have access to

# Reuse

# Change Strategy
* If change is easily implementable then 
  * build unit tests
  * build code
  * unit test
  * regression testing
