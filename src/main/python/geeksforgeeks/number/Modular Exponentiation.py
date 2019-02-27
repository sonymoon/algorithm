# -*- coding: utf-8 -*-

# (ab) mod p = ( (a mod p) (b mod p) ) mod p

# compute (x^y) % p.  = [(x * x) .... * (x * x) ] % p
# y个x （x ^y）% p  = [(x^y/2 % p ) * (x^y/2 %p)...* [0或1个x]] % p =
# [x^(y//4)%p][x^(y//4)%p]%p ...  2^1 * y//4个 * [0或1个x]
# 最后  [x * x %p] ...2^y//2个
# 共 y//2个。 姑且叫前半部分 * [0-1x]  ]  % p
# 前半部分等于# = [(x * x) % p]   =  (x * x)^(y//4) % p

if __name__ == '__main__':

    x = 2
    y = 6
    p = 13

    ret = 1
    # x = x % p  # y 个
    while y > 0:

        if y & 1:
            ret = (ret * x) % p

        y = y >> 1
        x = x * x % p

    print ret
