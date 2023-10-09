package com.colutti.hazelcastclient.listeners;

import com.hazelcast.topic.Message;
import com.hazelcast.topic.MessageListener;

public class HazelcastClientTopicListener implements MessageListener<String> {

    @Override
    public void onMessage(Message<String> message) {
        System.out.println("Received message on topic: " + message.getMessageObject());
    }

}
