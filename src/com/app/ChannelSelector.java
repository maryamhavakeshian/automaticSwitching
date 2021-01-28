package com.app;

import com.app.communicationchannel.Channel;
import com.app.communicationchannel.NetworkConnector;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TimerTask;
import java.util.stream.Collectors;

public class ChannelSelector extends TimerTask {

    ChannelSelector(NetworkConnector network) {
        this.network = network;
    }

    private final NetworkConnector network;

    @Override
    public void run() {

        // the communication method is selected based on the strength of the communication method
        // we can replace calling real services in real scenarios.

        Map<Double, Channel> allAvailableNetworkWithStrength = getAllAvailableNetworkWithStrength();
        //sort the communication methods based on their strength and choose the strongest one
        Double strengthsNetwork = allAvailableNetworkWithStrength.keySet().stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList()).get(0);
        //the event of happening the strongest network is published by the instance of  NetworkConnector class
        network.setCommunicationChannel(allAvailableNetworkWithStrength.get(strengthsNetwork));
        System.out.println("Channel Set to : " + allAvailableNetworkWithStrength.get(strengthsNetwork) + "\n \n");
    }

    private Map<Double, Channel> getAllAvailableNetworkWithStrength() {
        // scan all available network with strength
        // this is a fake scan and you can use a real service in this method

        //keep a map between strength of communication methods and their name
        //the double value is a randomly generated number and assumed as the strength of the communication method

        System.out.println("Scanning Available Network...");
        Map<Double, Channel> networkList = new HashMap<>();
        networkList.put(Math.random(), Channel._4G);
        networkList.put(Math.random(), Channel._3G);
        networkList.put(Math.random(), Channel.WIFI);
        System.out.println("Scan Complete. List Of Available Network with strength is : ");
        networkList.entrySet().forEach(System.out::println);
        return networkList;
    }
}
