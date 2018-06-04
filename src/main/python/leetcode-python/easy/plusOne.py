class Solution:
    def plusOne(self, digits):
        """
        :type digits: List[int]
        :rtype: List[int]
        """
        if not digits:
            return [1]

        carry = (digits[-1] + 1) // 10
        digits[-1] = (digits[-1] + 1) % 10
        for i in reversed(range(len(digits) - 1)):
            number = digits[i]
            digits[i] = (number + carry) % 10
            carry = (number + carry) // 10

        if carry > 0:
            return [carry] + digits
        else:
            return digits


print(Solution().plusOne([]))
