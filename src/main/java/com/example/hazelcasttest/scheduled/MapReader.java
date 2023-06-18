package com.example.hazelcasttest.scheduled;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.map.IMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class MapReader {


    @Autowired
    private HazelcastInstance hazelcastInstance;

    @Scheduled(fixedDelay = 60000)
    public void run() {

        IMap<String, Object> sharedMap = hazelcastInstance.getMap("sharedMap");
        for (Map.Entry<String, Object> objectObjectEntry : sharedMap.entrySet()) {
            System.out.println(objectObjectEntry.getKey() + " " + objectObjectEntry.getValue());
        }

    }
}
