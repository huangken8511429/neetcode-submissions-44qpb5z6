class Solution:
    def minDistance(self, s: str, t: str) -> int:
        f = list(range(len(t) + 1))
        for x in s:
            pre = f[0]
            f[0] += 1  # f[0] = i + 1
            for j, y in enumerate(t):
                tmp = f[j + 1]
                f[j + 1] = pre if x == y else min(f[j + 1], f[j], pre) + 1
                pre = tmp
        return f[-1]
        #  t = 3
        #   0 1 2 3 4
        # 0 | | | | |
        # 1 | | | | |
        # 2 | | | | |
        #   依賴上面，左邊，左上角 
        # n, m = len(s), len(t)
        # f = [[0] * (m + 1) for _ in range(n + 1)]
        # f[0] = list(range(m + 1))
        # for i, x in enumerate(s):
        #     f[i + 1][0] = i + 1
        #     for j, y in enumerate(t):
        #         f[i + 1][j + 1] = f[i][j] if x == y else \
        #                 min(f[i][j + 1], f[i + 1][j], f[i][j]) + 1
        # return f[n][m]