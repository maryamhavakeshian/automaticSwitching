package com.app;

import com.app.application.Car;
import com.app.communicationchannel.NetworkConnector;
import com.app.light.Light;

import java.util.Timer;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        //an instance of observable is created
        NetworkConnector network = new NetworkConnector();

        // an instance of observer is created/
        //multiple cars can be created to be added as an observer to the network
        Car car1 = new Car();

        //observers are added to the observable
        network.addObserver(car1);

        //observable is added to the channel selector to observe the changes in the communication methods and notify the car
        ChannelSelector channelSelector = new ChannelSelector(network);

        // another observers is added to use the  available communication method to notify the
        Light light = new Light();

        //schedule the channelselector to invstigate the available network
        Timer timer = new Timer();
         //the channel selector investigates investigates the changes
        // in the communication method and apply them in the networkConnector class
        timer.schedule(channelSelector, 0, 1000);

        while (true) {
            System.out.println("------------- Light Of Color is RED. Change to GREEN... ---------------");
            System.out.println("Car1 => the network of Car1 is : " + car1.getCommunicator().getNetworkConnection());
            //each car change the color no matter what the connection method is/ it check it every one second
            //it detects the light (which light(light instance) should be changed to which color(lightcolor)
            //the car notify the light to change its color
            car1.changeLightColor("GREEN", light);
            System.out.println("------------- After Cross the light Changing to RED... ---------------");
            car1.changeLightColor("RED", light);
            Thread.sleep(1001);
        }

    }
}
