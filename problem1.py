class Solution:
        
    def powerset(self, nums, value, result):
        if nums:
            for idx, i in enumerate(nums):
                value.append(i)
                result.append(value[:])
                self.powerset(nums[idx+1:], value, result)
                value.pop()
        
    def subsets(self, nums: List[int]) -> List[List[int]]:
        result = [[]]
        
        self.powerset(nums,[], result)
        return result
		
