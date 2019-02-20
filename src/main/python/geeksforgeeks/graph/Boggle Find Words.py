M = 3
N = 3
dictionary = ["GEEKS", "FOR", "QUIZ", "GO"]


def find_words(boggle):
    visited = [[False] * M for j in range(N)]
    for i in range(M):
        for j in range(N):
            find_words_util(boggle, visited, i, j, '')


def is_inwords(str):
    for word in dictionary:
        if str == word:
            return True;
    return False


def find_words_util(boggle, visited, i, j, s):
    s += boggle[i][j]
    visited[i][j] = True
    if is_inwords(s):
        print s

    for row in range(i - 1, i + 2):
        for column in range(j - 1, j + 2):
            if 0 <= row < M and 0 <= column < N and not visited[row][column]:
                find_words_util(boggle, visited, row, column, s)

    visited[i][j] = False


boggle = [['G', 'I', 'Z'],
          ['U', 'E', 'K'],
          ['Q', 'S', 'E']];

find_words(boggle)
