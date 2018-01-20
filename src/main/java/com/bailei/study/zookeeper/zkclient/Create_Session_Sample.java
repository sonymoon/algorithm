package com.bailei.study.zookeeper.zkclient;

import com.bailei.study.zookeeper.ZooConfig;
import org.I0Itec.zkclient.ZkClient;

/**
 * Created by bailei on 17/1/14.
 */
public class Create_Session_Sample {

    public static void main(String[] args) throws Exception {
        ZkClient zkClient = new ZkClient(ZooConfig.SERVER, 5000);
        System.out.println("session established!");

        String path = "/zk-book";

        zkClient.deleteRecursive(path);
        zkClient.delete(path);
        Thread.sleep(500);

        zkClient.subscribeChildChanges(path, (parentPath, currentChilds) -> {
            System.out.println(parentPath + "'s child path changed, currentChilds: " + currentChilds);
        });


        zkClient.createPersistent(path);
        Thread.sleep(1000);
        System.out.println(zkClient.getChildren(path));
        Thread.sleep(1000);
        zkClient.createPersistent(path + "/c1");
        Thread.sleep(1000);
        zkClient.deleteRecursive(path);
        Thread.sleep(Integer.MAX_VALUE);

    }
}
