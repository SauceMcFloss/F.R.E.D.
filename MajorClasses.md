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
