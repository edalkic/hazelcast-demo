package com.example.hazelcasttest.configuration;

import com.example.hazelcasttest.listener.MembershipListenerImpl;
import com.hazelcast.config.Config;
import com.hazelcast.config.EvictionPolicy;
import com.hazelcast.config.MapConfig;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.map.IMap;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Configuration
public class HazelcastConfiguration {

    @Value("${hazelcast.group.name}")
    private String groupName;

    @Value("${hazelcast.node.address}")
    private String nodeAddress;

    @Bean
    public HazelcastInstance hazelcastInstance() {
        Config config = new Config();
        config.setClusterName(groupName);
        config.addMapConfig(new MapConfig().setName("sharedMap"));
        config.getNetworkConfig().getJoin().getMulticastConfig().setEnabled(false);
        config.getNetworkConfig().getJoin().getTcpIpConfig().setEnabled(true);

        config.getNetworkConfig().getJoin().getTcpIpConfig().addMember(nodeAddress);
        HazelcastInstance hazelcastInstance = Hazelcast.newHazelcastInstance(config);
        hazelcastInstance.getCluster().addMembershipListener(new MembershipListenerImpl());
        return hazelcastInstance;
    }

    @Bean
    public IMap<String, Object> hazelcastMap(HazelcastInstance hazelcastInstance) {
        IMap<String, Object> map = hazelcastInstance.getMap("sharedMap");
        boolean containsKey = map.containsKey("key");
        if (!containsKey)
            map.put("key", "value");
        return map;
    }

}
