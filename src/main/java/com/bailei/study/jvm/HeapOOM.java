package com.bailei.study.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bailei on 16/12/22.
 * VM args -Xms20m -Xmx20m -XX +HeapDumpOnOutOfMemoryError
 */
public class HeapOOM {
    static class OOMObject {
    }

    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<>();
        while (true) {
            list.add(new OOMObject());
        }
    }
}
