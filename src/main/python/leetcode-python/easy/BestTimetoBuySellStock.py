class Solution:
    def maxProfit(self, prices):
        """
        :type prices: List[int]
        :rtype: int
        """
        if not prices:
            return 0
        total = 0
        for n in range(1, len(prices)):
            if prices[n] > prices[n-1]:
                total += prices[n] - prices[n-1]
        return total
