class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        '''
        Time complexity - O(2^N), N --> length of the input list nums
        Space complexity - O(2^N) because we store all the subsets in the res list
        '''
        result = []  # Initialize the result list

        def helper(i, subarr):
            # Append the current subset to the result list
            result.append(subarr)
            if i == len(nums):
                return  # Base case: reached the end of the input nums list

            for idx in range(i, len(nums)):
                # Recursively generate subsets by including the current number
                helper(idx + 1, subarr + [nums[idx]])

        helper(0, [])  # Start with an empty subset at index 0
        return result  # Return the list of all subsets
