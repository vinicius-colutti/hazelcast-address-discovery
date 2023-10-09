package com.colutti.hazelcastclient.configurations;

import com.colutti.hazelcastclient.listeners.HazelcastClientTopicListener;
import com.hazelcast.client.config.XmlClientConfigBuilder;
import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.topic.ITopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.client.HazelcastClient;
import java.io.IOException;

@Configuration
public class HazelcastClientConfiguration {

    private static final String SERVER_TOPIC_NAME="server-topic";

    @Bean
    public HazelcastInstance hazelcastInstance() throws IOException {
        ClientConfig clientConfig = new XmlClientConfigBuilder("configs/hazelcast-client-config.xml").build();
        HazelcastInstance hazelcastInstance = HazelcastClient.newHazelcastClient(clientConfig);
        ITopic<String> topic = hazelcastInstance.getTopic(SERVER_TOPIC_NAME);
        topic.addMessageListener(new HazelcastClientTopicListener());
        return hazelcastInstance;
    }

}
