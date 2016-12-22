package com.bailei.study.jvm;

/**
 * Created by bailei on 16/12/22.
 * VM args -Xss128k
 */
public class JVMStackOF {

    private int stackLength = 1;

    public void leak() {
        if (stackLength++ < 1000)
            leak();
    }

    public static void main(String[] args) {
        JVMStackOF jvmStackOF = new JVMStackOF();
        try {
            jvmStackOF.leak();
        } catch (Exception e) {
            System.out.println("stack length:  " + jvmStackOF.stackLength);
            throw e;
        }
    }
}
