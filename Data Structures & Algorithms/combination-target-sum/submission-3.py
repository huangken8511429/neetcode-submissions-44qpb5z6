class Solution:
    def combinationSum(self, nums: List[int], target: int) -> List[List[int]]:
        path = []
        ans = []
        n = len(nums)

        def dfs(i, s):
            if s == target:
                ans.append(path.copy())
                return
            if i == n or s > target:
                return

            dfs(i+1, s)

            path.append(nums[i])
            dfs(i, s + nums[i])
            path.pop()        

        dfs(0, 0)

        return ans         