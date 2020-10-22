# Time Complexity: O(N*2^N)
# Space Complexity: O(N*2^N)
# Yes, it ran on Leetcode
# No problems

class Solution:
    def subsets(self, nums):
        
        self.ans = []
        self.sub(nums,[],0)
        return self.ans
    
    def sub(self,array,path,index):
        self.ans.append(path)
        for i in range(index,len(array)):
            self.sub(array[:i]+array[i+1:],path+[array[i]],i)