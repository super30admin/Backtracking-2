#Subsets
# // Time Complexity : O(n*2^N) because we will have 2^n subsets and each subsets could be up to n length
# // Space Complexity : O(n)
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no



def subsets( nums) :
    res=[]
    path=[]
    
    def helper(nums, lvl):
        if(len(nums)==lvl):                             #if it reaches the end, add the path to results
            res.append(path.copy())
            return
        
        
        helper(nums, lvl+1)                         #if you choose to not add curent value, then recurse to the next one
        
        path.append(nums[lvl])                      #if you choose the current value, then append it to path and recurse to the next one
        helper(nums, lvl+1)
        path.pop()                                  #backtrack
            
            
    
    helper(nums, 0)
    return res