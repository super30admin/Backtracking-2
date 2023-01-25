# Time Complexity :
# O(2^(N))

# Space Complexity :
# O(N) - max Stack depth

# Did this code successfully run on Leetcode :
#Yes

#At every step, we either select an element or we do not - based on that we update our path. Now, whenever we have reached the end, we add a copy of the path to the power set
#At the end, after processing both options, we will remove the current element from the path as all subpaths have been processed

class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        self.power_set = []
        self.dfs(nums,0,[])
        return self.power_set

    def dfs(self,nums,index,path):
        if index == len(nums):
            self.power_set.append(path[:])
            return
        
        self.dfs(nums,index+1,path)
        path.append(nums[index])
        self.dfs(nums,index+1,path)
        #Backtracking
        path.pop(-1)
