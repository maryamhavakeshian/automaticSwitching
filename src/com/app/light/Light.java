package com.app.light;

import com.app.communicationchannel.Communicator;
import com.app.communicationchannel._4gCommunicator;

import java.util.Observable;
import java.util.Observer;

public class Light implements Observer {

    private Communicator communicator = new _4gCommunicator();

    private String lightColor = "RED";

    @Override
    public void update(Observable o, Object lightColor) {
        this.setLightColor((String) lightColor);
    }

//    public Communicator getCommunicator() {
//        return communicator;
//    }
//
//    public void setCommunicator(Communicator communicator) {
//        this.communicator = communicator;
//    }
//
//
//    public String getLightColor() {
//        return lightColor;
//    }
 //we assume that when the light as an observer is notified by color, it changes its color
// the light is notified by each car using its own communication method
    public void setLightColor(String lightColor) {
        System.out.println("Color Of Light Set to : " + lightColor);
        this.lightColor = lightColor;
    }
}
