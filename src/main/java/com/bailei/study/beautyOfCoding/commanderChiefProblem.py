def writeHigh(b, value):
    return (b & 0x0f) | (value << 4)


def readHigh(b):
    return (b & 0xf0) >> 4


def writeLow(b, value):
    return (value) | (b & 0xf0)


def readLow(b):
    return b & 0x0f


b = 0x00
# A的位置1
b = writeLow(b, 1)
while readLow(b) <= 9:

    b = writeHigh(b, 1)
    while readHigh(b) <= 9:
        if(readHigh(b) % 3 != readLow(b) % 3):
            print([readLow(b), readHigh(b)])

        b = writeHigh(b, readHigh(b) + 1)
        # print('highbits', readHigh(b))

    b = writeLow(b, readLow(b) + 1)
    # print('lowbits', readLow(b))
