package com.app.communicationchannel;

public class WifiCommunicator extends Communicator  {


    //return the WIFI; however, in real scenarios real implementation of finding WIF communication method can be put here

    @Override
    public String getNetworkConnection() {
        return "WIFI";
    }

}
