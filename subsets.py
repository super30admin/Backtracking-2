# // Time Complexity : O(2^n)
# // Space Complexity : O(2^n)
# // Did this code successfully run on Leetcode : Yes
# // Three line explanation of solution in plain english 

# // Your code here along with comments explaining your approach
class solution:

    '''
    we use backtracking to solve this problem to create subsets. so at each number we have a choice of choosing a number and not choosing a number

    we keep a track of index , which is the index of the num on nums. if it reaches the end, add the path to the result
    so in the case we choose, we add the num to our path , recurse with moving idx+1 and then pop the lement. 

    in case we dont choose, we just recurse by moving idx+1
    '''
    def subsets(self, nums):
        self.result = []
        self.helper(0, nums, [])
        return self.result
    def helper(self, idx, nums, path):

        # base

        if idx >= len(nums):
            self.result.append(copy.deepcopy(path))
            return 
        # logic
        path.append(nums[idx])
        ## choose
        self.helper(idx+1, nums, path)

        path.pop()
        ##no choose
        self.helper(idx+1, nums, path)
    
    '''
    in forloop based recursion. we will keep adding the path to the result as we have a pivot that we use to make decision.

    we use a for loop from idx, end and we add the num to path recurse with i+1 and then pop the element.
    '''
    def forloop_helper(self, idx, nums, path):

        # base

        
        self.result.append(copy.deepcopy(path))

        # logic

        for i in range(idx, len(nums)):

            path.append(nums[i])
            self.helper(i+1, nums, path)
            path.pop()


