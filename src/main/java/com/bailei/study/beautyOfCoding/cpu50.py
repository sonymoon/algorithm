#!/usr/bin/python3
# -*- coding: UTF-8 -*-

import time

busyTime = 10
idleTime = busyTime

while True:

    start = time.clock()
    while time.clock() - start < busyTime:
        pass
    time.sleep(busyTime / 1000)
