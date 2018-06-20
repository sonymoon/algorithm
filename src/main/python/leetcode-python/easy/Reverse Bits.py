# Reverse bits of a given 32 bits unsigned integer.

# Example:

# Input: 43261596
# Output: 964176192
# Explanation: 43261596 represented in binary as 00000010100101000001111010011100,
#              return 964176192 represented in binary as 00111001011110000010100101000000.
# Follow up:
# If this function is called many times, how would you optimize it?


class Solution:
    # @param n, an integer
    # @return an integer
    # using shift & and <<
    def reverseBits1(self, n):
        result = 0
        for i in range(32):
            result += n & 1
            n >>= 1
            if i < 31:
                result <<= 1
        return result

    # using bit operation
    def reverseBits1(self, n):
        n = (n >> 16) | (n << 16)
        n = (n & 0b11111111000000001111111100000000) >> 8 | (n & 0b00000000111111110000000011111111) << 8
        n = (n & 0b11110000111100001111000011110000) >> 4 | (n & 0b00001111000011110000111100001111) << 4
        n = (n & 0b11001100110011001100110011001100) >> 2 | (n & 0b00110011001100110011001100110011) << 2
        n = (n & 0b10101010101010101010101010101010) >> 1 | (n & 0b01010101010101010101010101010101) << 1
        return n

    def reverseBits(self, n):
        return int('{:032b}'.format(n)[::-1], 2)
    


print(Solution().reverseBits(43261596))
