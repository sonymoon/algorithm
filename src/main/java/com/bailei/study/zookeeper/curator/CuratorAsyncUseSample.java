package com.bailei.study.zookeeper.curator;

import com.bailei.study.zookeeper.ZooConfig;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by bailei on 17/1/14.
 */
public class CuratorAsyncUseSample {

    public static final CountDownLatch semaphore = new CountDownLatch(2);

    public static final ExecutorService tp = Executors.newFixedThreadPool(2);

    public static void main(String[] args) throws Exception {
        CuratorFramework client =
                CuratorFrameworkFactory.builder()
                        .connectString(ZooConfig.SERVER)
                        .sessionTimeoutMs(5000).connectionTimeoutMs(3000)
                        .retryPolicy(new ExponentialBackoffRetry(1000, 3))
                        .build();
        client.start();
        System.out.println("New Thread: " + Thread.currentThread().getName());


        String path = "/zk-book";
        client.create().creatingParentsIfNeeded()
                .withMode(CreateMode.EPHEMERAL)
                .inBackground((client1, event) -> {
                    System.out.println("event[code: " + event.getResultCode() + ", type: " +
                            event.getType() + "]");
                    System.out.println("Thread of processResult: " + Thread.currentThread().getName());
                    semaphore.countDown();
                }, tp)
                .forPath(path, "init".getBytes());

        client.create().creatingParentsIfNeeded()
                .withMode(CreateMode.EPHEMERAL)
                .inBackground((client1, event) -> {
                    System.out.println("event[code: " + event.getResultCode() + ", type: " +
                            event.getType() + "]");
                    System.out.println("Thread of processResult: " + Thread.currentThread().getName());

                    semaphore.countDown();
                })
                .forPath(path, "init".getBytes());

        semaphore.await();
        tp.shutdown();
    }
}
