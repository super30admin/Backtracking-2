/Time Complexity: O(2^n)
//Space Complexity: O(n) where n is max depth of tree
// Passed all test cases on Leetcode: Yes
// Approach: Make use of backtrackking recursion to keep track of all subsets and utitlize the same path array by appending and removing last element.
// finally append path to final output array

class Solution(object):
    def subsets(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        
        
        if(nums==[]):
            return([])
        self.op=[]
        self.backtrack(nums,0,[])
        return(self.op)
    def backtrack(self, nums,index,path):
        
        if(index>len(nums)):
            return
        
        self.op.append(copy.deepcopy(path))
        
        for i in range(index,len(nums)):
            print(i)
            path.append(nums[i])
            print(path)
            self.backtrack(nums,i+1,path)
            del path[len(path)-1]
            