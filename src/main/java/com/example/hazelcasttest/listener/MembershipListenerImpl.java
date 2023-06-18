package com.example.hazelcasttest.listener;

import com.hazelcast.cluster.MembershipEvent;
import com.hazelcast.cluster.MembershipListener;
import org.springframework.stereotype.Service;

@Service
public class MembershipListenerImpl implements MembershipListener {

    @Override
    public void memberAdded(MembershipEvent membershipEvent) {

    }

    @Override
    public void memberRemoved(MembershipEvent membershipEvent) {
        System.out.println("member down --> " + membershipEvent.getMember().getAddress());
    }
}
