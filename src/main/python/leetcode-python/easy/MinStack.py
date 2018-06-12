class MinStack:

    def __init__(self):
        """
        initialize your data structure here.
        """
        self.stack = []
        self.minList = []

    def push(self, x):
        """
        :type x: int
        :rtype: void
        """
        if self.minList and self.minList[0] >= x:
            self.minList.insert(0, x)
        else:
            self.minList.append(x)
        self.stack.append(x)

    def pop(self):
        """
        :rtype: void
        """
        x = self.stack.pop()
        if x == self.getMin():
            self.minList.pop(0)

    def top(self):
        """
        :rtype: int
        """
        if self.stack:
            return self.stack[-1]
        else:
            return None

    def getMin(self):
        """
        :rtype: int
        """
        if self.minList:
            return self.minList[0]
        else:
            return None
