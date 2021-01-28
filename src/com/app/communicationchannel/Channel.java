package com.app.communicationchannel;

public enum Channel {
    _4G(1),_3G(2), WIFI(3);

    private final int order;

    Channel(int order) {
        this.order = order;
    }

    static public Communicator getCommunicator(Channel channel) {
        switch (channel) {
            case _3G:
                return new _3gCommunicator();
            case WIFI:
                return new WifiCommunicator();
            case _4G:
            default:
                return new _4gCommunicator();
        }
    }

    static public Channel getByOrder(int order) {
        for (Channel value : Channel.values()) {
            if (value.order == order) {
                return value;
            }
        }
        return Channel._4G;
    }
}
