package com.example.hazelcasttest;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.flakeidgen.FlakeIdGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.Map;

@SpringBootApplication
@EnableScheduling
public class HazelcasttestApplication {

	public static void main(String[] args) {
		/*HazelcastInstance hazelcastInstance = Hazelcast.newHazelcastInstance();
		Map<Long, String> map = hazelcastInstance.getMap("data");
		FlakeIdGenerator idGenerator = hazelcastInstance.getFlakeIdGenerator("newid");
		for (int i = 0; i < 10; i++) {
			map.put(idGenerator.newId(), "message" + i);
		}*/
		SpringApplication.run(HazelcasttestApplication.class, args);

	}

}
