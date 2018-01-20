package com.bailei.study.jvm;

/**
 * Created by bailei on 16/12/22.
 * 方法区和常量池－－》即永久代溢出
 * VM args: -XX:PermSize=10M -XX:MaxPermSize=10M
 */
public class RunTimeConstantPoolOOM {

    public static void main(String[] args) {
        String str1 = new StringBuilder("test1").append("test2").toString();
        System.out.println(str1.intern() == str1);
        String str2 = new StringBuilder("ja").append("va").toString();
        System.out.println(str2.intern() == str2);
    }
}
