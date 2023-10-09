package com.colutti.hazelcastserver.services.impl;

import com.colutti.hazelcastserver.services.HazelcastServerService;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.topic.ITopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HazelcastServerServiceImpl implements HazelcastServerService {

    @Autowired
    private HazelcastInstance hazelcastInstance;

    private static final String SERVER_TOPIC_NAME="server-topic";

    @Override
    public void publishMessageOnTopic(String message) {
        ITopic<String> topicMessage = hazelcastInstance.getTopic(SERVER_TOPIC_NAME);
        topicMessage.publish(message);
    }
}
