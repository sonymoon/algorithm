package com.bailei.study.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bailei on 16/12/22.
 * 方法区和常量池－－》即永久代溢出
 * VM args: -XX:PermSize=10M -XX:MaxPermSize=10M
 */
public class RunTimeConstantPoolOOM {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        int i = 0;
        while (true) {
            list.add(String.valueOf(i++).intern());
        }
    }
}
