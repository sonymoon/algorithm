class Solution:
    def __init__(self):
        pass

    # o(mn)
    def print_lcs(self, str1, str2):
        m = len(str1)
        n = len(str2)
        if n == 0 or m == 0:
            return 0
        # declare an two dimension array store calculated dp value of lcs(str1[i]
        R = [[None] * (n + 1) for i in xrange(m + 1)]
        for i in range(m + 1):
            for j in range(n + 1):
                if i == 0 or j == 0:
                    R[i][j] = 0
                elif str1[i - 1] == str2[j - 1]:
                    R[i][j] = 1 + R[i - 1][j - 1]
                else:
                    R[i][j] = max(R[i - 1][j], R[i][j - 1])
        lcs = []
        i = m
        j = n
        while i > 0 and j > 0:
            if str1[i - 1] == str2[j - 1]:
                lcs.insert(0, str1[i - 1])
                i -= 1
                j -= 1
            elif R[i - 1][j] > R[i][j - 1]:
                i -= 1
            else:
                j -= 1

        return lcs


str1 = 'AGGTAB';
str2 = 'GXTXAYB';

# print(Solution().longest_sub_sequence(str1, str2, len(str1), len(str2)));
print(Solution().print_lcs(str1, str2))
