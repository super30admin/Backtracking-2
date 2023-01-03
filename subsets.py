#Time Complexity :  O(n * 2^n)
#Space Complexity :  O(n)
#Did this code successfully run on Leetcode : Yes

#code along with comments 
class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        result = []                                         #final array to be returned
        subset = []                                         #subsets array
        
        def dfs(i):
            if i == len(nums):                              #base case
                return result.append(subset.copy())
            
            subset.append(nums[i])                          #choose nums[i]
            dfs(i+1)                                        #make recursive call on i+1
            
            subset.pop()                                    #dont choose nums[i], pop and backtrack
            dfs(i+1)                                        #make recursive call on i+1
            
        dfs(0)
        return result