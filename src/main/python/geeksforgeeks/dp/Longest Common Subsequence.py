class Solution:
    def __init__(self):
        pass

    # time o(n*2)
    def longest_sub_sequence(self, str1, str2, len1, len2):
        if len1 == 0 or len2 == 0:
            return 0
        if str1[len1 - 1] == str2[len2 - 1]:
            return 1 + self.longest_sub_sequence(str1, str2, len1 - 1, len2 - 1)
        else:
            return max(self.longest_sub_sequence(str1, str2, len1 - 1, len2),
                       self.longest_sub_sequence(str1, str2, len1, len2 - 1))

    # o(mn)
    def longest_sub_sequence1(self, str1, str2):
        m = len(str1)
        n = len(str2)
        if n == 0 or m == 0:
            return 0
        # declare an two dimension array store calculated dp value
        R = [[None] * (n + 1) for i in xrange(m + 1)]
        for i in range(m + 1):
            for j in range(n + 1):
                if i == 0 or j == 0:
                    R[i][j] = 0
                elif str1[i - 1] == str2[j - 1]:
                    R[i][j] = 1 + R[i - 1][j - 1]
                else:
                    R[i][j] = max(R[i - 1][j], R[i][j - 1])
        return R[m][n]

str1 = 'AGGTAB';
str2 = 'GXTXAYB';

# print(Solution().longest_sub_sequence(str1, str2, len(str1), len(str2)));
print(Solution().longest_sub_sequence1(str1, str2))
