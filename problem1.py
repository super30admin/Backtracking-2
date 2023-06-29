# Approach - 1

class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        """
        Using 0-1 recursion
        Time Complexity :O(2^N) N: len of nums array
        Space Complexity :O(N)
        """
        result = []
        
        def helper(nums, idx, path):
            # Base Condition
            if idx == len(nums):
                result.append(path)
                return
            
            # Logic
            # Dont choose
            helper(nums, idx + 1, list(path))
            
            # Choose
            # Adding the path
            path.append(nums[idx])
            helper(nums, idx + 1, list(path))
        
        helper(nums, 0, [])
        return result

# Approach - 2
class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        """
        Changing the order of choose and not choose
        Time Complexity :O(2^N) N: len of nums array
        Space Complexity :O(N)
        """
        result = []
        
        def helper(nums, idx, path):
            # Base Condition
            if idx == len(nums):
                result.append(list(path))
                return
            
            # Logic
            # Choose
            # Adding the path
            # need to create a new temp list as our prev list was getting ppended twice.
            temp = list(path)
            temp.append(nums[idx])
            helper(nums, idx + 1, list(path))
            # Dont choose
            helper(nums, idx + 1, temp)
            
           
        
        helper(nums, 0, [])
        return result
