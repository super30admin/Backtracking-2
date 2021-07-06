class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        self.result = []
        if nums == None or len(nums) == 0:
            return self.result
        self.helper(nums, 0, [])
        return self.result
    
    def helper(self, nums: List[int], index: int, path: List[int]) -> None:
        # base
        if index == len(nums):
            # self.result.append(path)
            self.result.append(path.copy())
            return
        
        # don't choose
        # self.helper(nums, index + 1, path.copy())
        self.helper(nums, index + 1, path)
        
        # choose
        path.append(nums[index])
        # self.helper(nums, index + 1, path.copy())
        self.helper(nums, index + 1, path)
        path.pop()


class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        self.result = []
        if nums == None or len(nums) == 0:
            return self.result
        self.helper(nums, 0, [])
        return self.result
    
    def helper(self, nums: List[int], index: int, path: List[int]) -> None:
        
        self.result.append(path.copy())
        for i in range(index, len(nums)):
            path.append(nums[i])
            self.helper(nums, i+1, path)
            path.pop()


class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        self.result = []
        if nums == None or len(nums) == 0:
            return self.result
        self.result.append([])
        for num in nums:
            size = len(self.result)
            for i in range(0,size):
                copy = self.result[i].copy()
                copy.append(num)
                self.result.append(copy)
        return self.result
        

# Time Complexity: Exponential
        
        