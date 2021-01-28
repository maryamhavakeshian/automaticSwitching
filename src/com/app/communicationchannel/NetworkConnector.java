package com.app.communicationchannel;

import java.util.Observable;

public class NetworkConnector extends Observable {

    private Communicator communicator;

    public void setCommunicationChannel(Channel communicationChannel) {
        this.communicator = Channel.getCommunicator(communicationChannel);
        setChanged();
        notifyObservers(communicator);
    }

}
