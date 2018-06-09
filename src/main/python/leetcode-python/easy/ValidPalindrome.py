class Solution:
    def isPalindrome(self, s):
        """
        :type s: str
        :rtype: bool
        """
        origin = []
        for char in s:
            if char.isalpha() or char.isalnum():
                origin.append(char.lower())
        return origin[::-1] == origin
