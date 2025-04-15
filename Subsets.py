#Time Complexity: O(N*2^N)
#Space Complexity: O(N*2^N)
class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        result = []
        def dfs(i,subset):
            if(i>=len(nums)):
                result.append(subset.copy())
                return
            #Choose Case
            subset.append(nums[i])
            dfs(i+1,subset)
            #No Choose
            subset.pop()
            dfs(i+1,subset)
        dfs(0,[])
        return result



















        