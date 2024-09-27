// Time Complexity :O(2^n)
// Space Complexity : O(2^n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach
In this DFs approach we start with empty list and at every node we have an option of either choosing the element or not choosing the element.so at every level you have like 2^(level) computations (i.e at level0 1,level1 2,level2 4 and soon) when summed up we get 2^n as time complexity.In the leaf level we end up with all the subsets.
#DFS
class Solution(object):
    def __init__(self):
        self.out=[]
    
    def helper(self,nums,list1,index):
        if index==len(nums):
            self.out.append(list1)
            return
        # not choosing the element
        self.helper(nums,list(list1),index+1)
        # after choosing
        list1.append(nums[index])
        self.helper(nums,list(list1),index+1)
        
    def subsets(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        if nums==None or len(nums)==0:
            return []
        self.helper(nums,[],0)
        return self.out
        
        
// Time Complexity :O(2^n)
// Space Complexity :O(2^n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach
In this backtracking approach we traverse through each and every node and store the combination and then backtrack to get all the required combinations.
#backtracking
class Solution(object):
    def __init__(self):
        self.list1=[]
        self.out=[]
    def helper(self,nums,list1,index):
        self.out.append(list(list1))
        for i in range(index,len(nums)):
            self.list1.append(nums[i])
            self.helper(nums,self.list1,i+1)
            self.list1.pop()
    def subsets(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        if nums==None or len(nums)==0:
            return []
        self.helper(nums,[],0)
        return self.out
        
        