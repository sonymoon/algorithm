class Solution:

    def isValid(self, s):
        """
        :type s: str
        :rtype: bool
        """
        if not s:
            return True
        if len(s) % 2 == 1:
            return False

        dict = {'(': ')', '[': ']', '{': '}'}
        stack = []
        for char in s:
            if not stack:
                stack.append(char)
                continue

            last = stack[-1]
            if last not in dict or dict[last] != char:
                stack.append(char)
            else:
                stack.pop()

        return len(stack) == 0
