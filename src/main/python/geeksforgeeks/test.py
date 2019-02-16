# -*- coding: utf-8 -*-

class Node:
    def __init__(self,val):
        self.val = val
        self.next = None

def change(node):
    node = Node(2)


head = Node(1)
print head.val

change(head)
print head.val

## 直接将引用改成另一个对象，不会起作用，原因是：python对于引用传递，也是值传递，会传递一个引用本身的copy
# 将copy引用到另一个对象，原引用还是不会发生变化
