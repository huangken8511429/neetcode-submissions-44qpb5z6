class Solution:
    def combinationSum(self, nums: List[int], target: int) -> List[List[int]]:
        path = []
        ans = []
        n = len(nums)

        def dfs(i, target):
            if i >= n:
                return
            if target == 0:
                ans.append(path.copy())
                return

            if target >= nums[i]:
                path.append(nums[i])
                dfs(i, target - nums[i])
                path.remove(nums[i])

            dfs(i+1, target)
        dfs(0, target)    
        return ans        


            

                
                