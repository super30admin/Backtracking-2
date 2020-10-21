"""
Name: Srinidhi

Time Complexity: 
Space Complexity:

Did it run on LC: Yes
Logic: We use backtracking - we iterate over the nums array from index to
the length of the array. 
Add nums to the result and hence, explore from index+1
make sure to pop nums to explore other candidates also.
"""
class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        output = []
        
        def subsetsHelper(first=0,curr_path = []):
            if len(curr_path) ==k:
                output.append(curr_path[:])
            
            for i in range(first,n):
                curr_path.append(nums[i])
                subsetsHelper(i+1,curr_path)
                
                curr_path.pop()
                
        n = len(nums)
        for k in range(n+1):
            subsetsHelper()
        return output