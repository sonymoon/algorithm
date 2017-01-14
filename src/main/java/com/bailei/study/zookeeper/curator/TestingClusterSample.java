package com.bailei.study.zookeeper.curator;

import org.apache.curator.test.TestingCluster;
import org.apache.curator.test.TestingZooKeeperServer;

/**
 * Created by bailei on 17/1/14.
 */
public class TestingClusterSample {
    public static void main(String[] args) throws Exception {
        TestingCluster cluster = new TestingCluster(3);
        cluster.start();

        Thread.sleep(1000);

        final TestingZooKeeperServer[] leader = new TestingZooKeeperServer[1];

        cluster.getServers().forEach(server -> {
            System.out.print(server.getInstanceSpec().getServerId() + "-");
            System.out.print(server.getQuorumPeer().getServerState() + "-");
            System.out.println(server.getInstanceSpec().getDataDirectory().getAbsolutePath());

            if (server.getQuorumPeer().getServerState().equals("leading")) {
                leader[0] = server;
            }
        });
        leader[0].kill();

        System.out.println("-- After leader kill: ");
        cluster.getServers().forEach(server -> {
            System.out.print(server.getInstanceSpec().getServerId() + "-");
            System.out.print(server.getQuorumPeer().getServerState() + "-");
            System.out.println(server.getInstanceSpec().getDataDirectory().getAbsolutePath());
        });
    }
}
