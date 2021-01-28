package com.app.communicationchannel;

public class _4gCommunicator extends Communicator  {

    //return the 4G; however, in real scenarios real implementation of finding 4G communication method can be put here
    @Override
    public String getNetworkConnection() {
        return "4g";
    }
}
