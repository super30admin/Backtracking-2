#Time Complexity: O(N*2**N)
#Space Complexity: O(N)
class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        li = []
        def helper(path,index):
            
            li.append(path.copy())
            for i in range(index,len(nums)):
                path.append(nums[i])
                helper(path,i+1)
            
                path.pop()
            
        helper([],0)
        return li