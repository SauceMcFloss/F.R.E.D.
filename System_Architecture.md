# Program Organization

Populate each section with information as it applies to your project. If a section does not apply, explain why. Include diagrams (or links to diagrams) in each section, as appropriate. For example, sketches of the user interfaces along with an explanation of how the interface components will work; ERD diagrams of the database; rough class diagrams; context diagrams showing the system boundary; etc.

# Major Classes
```
Arduino Control Package
{
 Car
 {
 // Holds values for current iteration of the car that other packages use
 }
 
 Control
 {
 // Sends and receives signal to driver package.
 }
}
```
```
UIPackage
{
 MainController
 {
 // Will open and close the application
 }
 ManualController
 {
 // Will show on screen movements inputs done by manual controls
 }
 AutonomousController
 {
 // Will begin and end autonomous control of vehicle.
 }
}
```
```
CameraPackage
{
 Connection
 {
 // Will check connection to the laptop controls 
 }
 Camera
 {
 // Will start and stop camera
 }
 {
 Format
 {
 // Will format images and send them to be interpreted to the laptop
 }
}
```
```
CentraNeuralNetwork
{
 Classifier
 {
 // Will check if images received are indeed known signals.
 }
 NeuralNetwork
 {
 // Will add and train new signals as recognizable images to be interpreted.
 }
}
```
```
DriverPackage
{
 Driver
 {
 // Moves based on inputs from user.
 }
 AutonomousDriver
 {
 // Moves automatically based on signals received from camera inputs.
 }
}
```

 
# Data Design

# Business Rules

# User Interface Design

# Resource Management

# Security

# Performance

# Scalability
* capability for multiple car profiles
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
