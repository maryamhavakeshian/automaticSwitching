#########################Introduction##################################################
This program is written in java language and aims to simulate automatic switching between at least three methods of communication (wifi,4G, and 3G) for the application of changing the color of traffic light.
##########################Running instruction###########################################
AutomaticSwitching project generate its own inputs (signaling), and prints the output of the project in the console. To run the program, it is simply required to execute the Main class.

######################## Compile Instruction###########################################
The project files are available for standalone execution
The project can be complied through either IntelliJ IDEA or Eclipse IDE.

#########################Problem Statement############################################
The project consists of two independent part: automatic switching, which is implemented by poling mechanism and Changing the color of traffic light, which is implemented by pushing mechanism.
*****Automatic switching:
To do automatic switching between communication methods, we use pooling mechanism, in which we check the available communication methods and their strength
in specific time intervals and choose the strongest communication methods. (we check the changes in specific time intervals in polling mechanism)
In the real scenarios, we can use client server approach for the notifying available signals of communication methods. However, we simulated the notification
by the observable pattern.
As real signaling of the available communication methods is not available, we use observer pattern (publish-subscribe design pattern) to simulate and control
the expected notifications of available communication methods. By doing so, we can notify observers (controller parts in autonomous cars) about changes in
their subjects (the available communication methods). In other words, the car can check the available communication methods via a pooling mechanism.
To do so, the channelSelector class is used, in which through multithreading approach, we check the available communication methods and their strength
in specific time intervals.
To be more specific, the car entity (here we mean controller part) requires to be aware of the changes in the availability of communication methods.
So, we consider the Car class as an observer. Likewise, and NetworkConnector class and communicator abstract class provides the car with available 
communication methods; so, we make them observables. By doing so, when available communication methods are changed, the car entity (observer, or subscriber) 
is notified by the networkConnector class (observable, or publisher) to change its communication method.
*****Changing the color of the traffic light
To change the color for traffic light, we use pushing mechanism, in which the car sees the light and notify the change of color.
when something happens, we are informed)
For changing color, each car(Car here is observable) can check and if required, notify the light entity (observer) every 1 second, 
no matter what the connection method is. As the observable check the changes (pushing), it is the pushing mechanism.
 In the real scenarios, we notify the infrastructure. However, we notify the light entity instead of the infrastructure. 

########################main class################################################
The program start within the main class, in which various instances of cars (observers) are introduced to network (observable).
Although we add only one car, it is possible to add multiple car to the network. The channel selector class (the input of the thread,
which is supposed to monitor the changes in the network) accept the network.  Next the channelSelector thread is executer.
The initial delay is 0 and the thread is executed every 1000 MS. in each interval, the thread investigates the changes in the communication method
and apply them in the networkConnector class. Likewise, the networkConnctor( the observable) notifies the Car (Observer) to change the new communication method.
Each car can change the color light by checking and changing the light every 1 second, using its own communication method. Changing color can happen using
any type of communication method ( it is not dependent on communication method).


########################Car class#################################################
Car class uses an instance of communicator abstract class to utilize the channel (communication method), to be notified about available communication methods.
The car entity
#######################Light class#################################################
Light class is the simulation of the infrastructure. So, we define it as an observer. The changes in color is notified by the car, as an observable.
Changing the color happens no matter what the communication method is. 

########Communicator abstract class and its implementations (_3gCommunicator, _4gCommunicator, ####### and  WifiCommunicator)) ##################################################### 
The communicator abstract class provides an abstract method, called getNetworkConnection(). Each communication class provides related communication method 
through implementing the getNetworkConnection (). Although we simply the name of the communication methods (4G,3G, or Wifi) in the implementation of
getNetworkConnection (), a real application can utilize such a modular application to provide the system with appropriate implementation.
In another words, these communicator classes (_3gCommunicator, _4gCommunicator, and WifiCommunicator) are reusable for a real application,
and any other hardware API implementation or web service can be implemented in these communicator classes.
########Channel Interface######
Channel interface includes the name of communication methods. Here we define an Enum; 
however, our modular design enables us to get the name of
communication methods from files, databases, or any other external services.
#########################NetworkConncetor##########################################
NetwrokConnector class Is an observable(publisher), which enables observer classes, 
such as Car class to be aware of any changes in the communication methods and be adopted to the new changes. 
In another words, if each communication method is changed, the observer classes can be aware of the changes through observing the network. 
(it is implemented in the main class;  network.addObserver(car1); In this case, when a communication method is changed, the car should use 
the new communication method.
#########################Channel Selector#############################################
Channelselector uses the TimerTask class—A java API, which is used in multithreading application and can be used to schedule 
a thread to be executed at certain interval of time in future—to check the available communication methods and their strength in the specific time intervals.
In the run method, to get the available communication methods and their related strength, getAllAvailableNetworkWithStrength() is used to return the available
networks and their strength. To do so,  in the getAllAvailableNetworkWithStrength() method, we create a map between the strength of each communication method
( a randomly generated number) and its name. In other words, we have a map of double and channel: the double datatype is the key of our map the strength of the
network, and the channel defines the specific communication method. 
It is clear that, in the real application, we can change the implementation getAllAvailableNetworkWithStrength() method such that it can use real services
 to search the available communication methods and their strength. 
Then, we sort the communication methods based on their strength and choose the strongest one. Next, the event of the strongest available network is
 published by an instance of NetworkConnector class. To do so, the strongest network is returned to the setCommunicatorChannel(the event is published).




