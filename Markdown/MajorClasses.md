# Major Classes
&nbsp;
&nbsp;
#### Main Package
* ##### main
    * Loads and initializes user interface
&nbsp;
#### UI Package
* ##### mainScreenController
    * Binds UI elements to methods that handle actions and events

* ##### manualScreenController
    * Binds all of the UI elements inside the Manual Control Tab to methods for handling actions and events

* ##### autonomousScreenController
    * Binds all of the UI elements inside the Autonom Control Tab to methods for handling actions and events

&nbsp;
#### Arduino Control Package
* ##### Connection
    * Handles establishing and managing communications between the car and the application

* ##### Car
    * Handles interpreting and communicating commands with the adruino micro controller

&nbsp;
#### Camera Package
* ##### Camera
    * Handles camera interface and getting data

* ##### Format
    * Auxilliary methods for formatting data into different formats

* ##### Connection
    * Handles communication between the camera and the application


&nbsp;
#### Driver Package
* ##### Driver
    * Composes arduino car functions into complete driver controls that the UI can call

* ##### Autonomous Driver
    * Composes arduino car/neural network functions to create driving routines


&nbsp;
#### Convolutional Neural Network Package
* ##### Classifier
    * Provides high level interface for the network

* ##### NeuralNetwork
    * Provides a lower level interface for the classifier class
