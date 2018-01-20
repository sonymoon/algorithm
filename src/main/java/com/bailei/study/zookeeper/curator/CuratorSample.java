package com.bailei.study.zookeeper.curator;

import com.bailei.study.zookeeper.ZooConfig;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.data.Stat;

/**
 * Created by bailei on 17/1/14.
 */
public class CuratorSample {

    public static void main(String[] args) throws Exception {
        CuratorFramework client =
                CuratorFrameworkFactory.builder()
                        .connectString(ZooConfig.SERVER)
                        .sessionTimeoutMs(5000).connectionTimeoutMs(3000)
                        .retryPolicy(new ExponentialBackoffRetry(1000, 3))
                        .build();
        client.start();

        String path = "/zk-book/c1";
        client.create().creatingParentsIfNeeded()
                .withMode(CreateMode.EPHEMERAL).forPath(path, "init".getBytes());

        Stat stat = new Stat();
        client.getData().storingStatIn(stat).forPath(path);
        Thread.sleep(3000);
        client.delete().deletingChildrenIfNeeded().withVersion(stat.getVersion())
                .forPath(path);
        Thread.sleep(Integer.MAX_VALUE);
    }
}
