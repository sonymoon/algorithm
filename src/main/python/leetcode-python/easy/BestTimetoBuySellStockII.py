class Solution:
    def maxProfit(self, prices):
        """
        :type prices: List[int]
        :rtype: int
        """
        if not prices:
            return 0
        maxCur = maxSum = prices[0]
        for n in range(1, len(prices)):
            maxCur = max(maxCur + prices[n] - prices[n-1], 0)
            maxSum = max(maxSum, maxCur)
        return maxSum
