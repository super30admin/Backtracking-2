# Recursive function:
# append the path to result. Run a loop where i=pivot till length of nums. 
# Append the elelmt in nums to path and call the helper function by incrementing i. Backtrack the call
# Time :O(2^n)
# Space:O(n)

class Solution(object):
    def subsets(self, nums):
        self.result=[]
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        if not nums:
            return []
        self.helper(nums, [], 0)
        return self.result

    def helper(self, nums, path, pivot):

        self.result.append(path[:])
        for i in range(pivot,len(nums)):
            path.append(nums[i])
            self.helper(nums,path,i+1)
            path.pop()





# Recursive function: 
# Check if index is out of bounds, if so, append the path to result., return.
# call the helper function by incrementing the index in case of not choose option.
# Append nums[index] to path and call the helper function by incrementing the index.
# Backtrack the call

# Time complexity: O(n2^n)
# Space O(n)

class Solution(object):
    def subsets(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        self.result=[]
        if not nums:
            return []
        else:
            self.helper(nums, [], 0)
            return self.result
    def helper(self, nums, path, ind):
        if ind==len(nums):
            self.result.append(path[:])
            return
        
        self.helper(nums, path, ind+1)
        path.append(nums[ind])
        self.helper(nums,path,ind+1)
        path.pop()