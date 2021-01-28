package com.app.application;

import com.app.communicationchannel.Communicator;
import com.app.communicationchannel._4gCommunicator;
import com.app.light.Light;

import java.util.Observable;
import java.util.Observer;

public class Car implements Observer {

    private Communicator communicator = new _4gCommunicator();

    @Override
    public void update(Observable o, Object communicator) {
        this.setCommunicator((Communicator) communicator);
    }

    public Communicator getCommunicator() {
        return communicator;
    }

    public void setCommunicator(Communicator communicator) {
        this.communicator = communicator;
    }


    //car changes the color ,  the car use its own communicator to change the color(notify the light to be changed)
    // in real scenarios, this method can notify the real infrastructure
    public void changeLightColor(String lightColor, Light light) {
        this.communicator.addObserver(light);
        this.communicator.changeLightColor(lightColor);
    }
}
