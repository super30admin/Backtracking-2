class Solution:
           
    """
    Description: Create subsets from a list of numbers

    +---------------------------------------------------------+
    |Method           |Time Complexicity |Space Complexicity  |
    +---------------------------------------------------------+
    |for loop         |O(n^2)            |O(n)                |
    |recursion        |O(n*2^n)          |O(n)                |
    |backtracking     |O(n*2^n)          |O(n)                |
    +---------------------------------------------------------+

    Worked in leetcode: Yes (all 3 methods)
    
    Approach:
    1. For loop by creating empty list of list
       - append by subarray for adding each number and their combinations
       - append the combination to the list and repeat with next set of numbers
    2. Using recursion:
       - call recursive stacks by making a choice (choose or not choose a number)
       - add the path by creating deep copy at every recursive call
       - final result add to base case (i.e. when the last index is reached) 2*n times
    3. Using backtracking
       - Same as #2, but instead of creating deep copy in every call, backtrack the current path by removing the last element

    """
        
    # Using for loop    
    def subsets(self, nums: List[int]) -> List[List[int]]:    

        output = [[]]
        for num in nums:
            subarray = []
            for curr_out in output:
                temp = [i for i in curr_out] # Space required
                temp.append(num)
                subarray.append(temp)        # Additional space required
            for item in subarray:
                output.append(item)
                
        return output
    
    # Using recursion
    def subsets(self, nums: List[int]) -> List[List[int]]:
        
        self.output = []
        if nums == None or len(nums) == 0: return self.output
        self.helper(nums, 0, [])
        return self.output        
        
    def helper(self, nums, index, path):
        
        # base
        if index == len(nums): 
            self.output.append(path)
            return
        
        # logic
        # choose and not choose
        self.helper(nums, index + 1, copy.copy(path))
        path.append(nums[index])
        self.helper(nums, index + 1, copy.copy(path))
 
    # Using backtracking
    def helper(self, nums, index, path):
        
        # base
        if index == len(nums): 
            self.output.append(copy.copy(path))
            return
        
        # logic
        # choose and not choose
        self.helper(nums, index + 1, path)
        path.append(nums[index])
        self.helper(nums, index + 1, path)
        
        # backtrack
        path.pop() 
