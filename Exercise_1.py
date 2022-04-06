

# Recursion
# Time Complexity = O(2^N)
# Space Complexity = O(H)
class Solution(object):
    result = []
    def subsets(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        self.result = []
        def helper(nums, i, path): 
            
            # base case
            if i == len(nums):
                self.result.append(path)
                return
            
            
            # logic
            helper(nums, i+1, path)
            new_li = list(path)
            new_li.append(nums[i])
            helper(nums, i+1, new_li)
        
        helper(nums, 0, [])
        return self.result


# Backtracking
# Time Complexity = O(2^N)
# Space Complexity = O(H)
class Solution(object):
    result = []
    def subsets(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        self.result = []
        def helper(nums, i, path): 
            
            # base case
            if i == len(nums):
                self.result.append(path)
                return
            
            
            # logic
            path.append(nums[i])
            new_li = path
            helper(nums, i+1, new_li)
            path.pop()
            helper(nums, i+1, path)
        
        helper(nums, 0, [])
        return self.result


# Recursion using for loop
# Time Complexity = O(2^N)
# Space Complexity = O(H)
class Solution(object):
    result = []
    def subsets(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        self.result = []
        def helper(nums, i, path): 
            self.result.append(list(path))

            for i in range(i, len(nums)):
                
                new_list = list(path)
                new_list.append(nums[i])
                helper(nums, i+1, new_list)
        
        helper(nums, 0, [])
        return self.result


# Backtracking using for loop
# Time Complexity = O(2^N)
# Space Complexity = O(H)
class Solution(object):
    result = []
    def subsets(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        self.result = []
        def helper(nums, i, path): 
            self.result.append(list(path))
            
            for i in range(i, len(nums)):
                path.append(nums[i])
                helper(nums, i+1, path)
                path.pop()
        
        helper(nums, 0, [])
        return self.result


# Smart Brute Force
# Time Complexity = O(2^N)
# Space Complexity = O(H)

class Solution(object):
    def subsets(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        result = [[]]
        for i in range(len(nums)):
            result_size = len(result)
            for j in range(result_size):
                new_list = list(result[j])
                new_list.append(nums[i])
                result.append(new_list)
        return result
                
