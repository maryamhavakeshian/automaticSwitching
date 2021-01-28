package com.app.communicationchannel;

public class _3gCommunicator extends Communicator {

    //return the 3G; however, in real scenarios real implementation of finding 3G communication method can be put here

    @Override
    public String getNetworkConnection() {
        return "3g";
    }

}
