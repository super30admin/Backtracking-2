class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        res = []
        cur = []
        def dfs(i):
            if i == len(nums): 
                res.append(cur.copy())
                return
            cur.append(nums[i])
            dfs(i + 1)
            cur.pop()
            dfs(i + 1)
        dfs(0)
        return res
    
    
# T.C => 2 ** n => It grows exponentially, depends on the element
# S.C => O(n) = Recursive stack is being used here.
# Approach => here we pass index to the dfs function and append the copt to 
# the res function. Evertime we pass a current index plus one and always appends it in the current copy. ones we add we always do the cleaning by doing pop in the last