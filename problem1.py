
// Time Complexity : O(2^n)
// Space Complexity : O(n) //length of num
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        if not nums or len(nums)==0:
            return []
        self.output=[]
        path=[]
        self.backtracking(nums,0,path)    //call a recursive backtracking function with initial value of index=0
        return self.output
        
        
    def backtracking(self,nums,index,path): //we need to find all the subsets so whenever we will call this method we will simply append the path list in output list and then look for the further subsets

        
        self.output.append(list(path))    //appent the path list in output list
        for i in range(index,len(nums)):    // traverse whoel list of numbers from index =index till last number in a list 
            path.append(nums[i])            //append the current number in the path list
            self.backtracking(nums,i+1,path)  //again call recursive function
            path.pop()                      //after coming back from recursive function pop the last number from path list to go to previous level or to add the new one at same level
