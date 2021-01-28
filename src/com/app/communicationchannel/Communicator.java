package com.app.communicationchannel;

import java.util.Observable;

public abstract class Communicator extends Observable {

    public abstract String getNetworkConnection();

    //change the lightColor no matter what the communication method is
    // changing color can be happened using each communication method
    public void changeLightColor(String lightColor) {
        setChanged();
        notifyObservers(lightColor);
    }
}
