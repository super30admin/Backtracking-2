# Time O(2^(n-1))
# Space O(1)
class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        result = [[]]

        for num in nums:
            for i in range(len(result)):
                new_subset = result[i].copy()
                new_subset.append(num)
                result.append(new_subset)
        
        return result

# Time O(2^n)
# Space O(n)
class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        result = [[]]

        self.getsubsets(nums, 0, [], result)
        return result

    def getsubsets(self, nums: List[int], i: int, path: List[int], result: List[List[int]]) -> None:
        # Base
        if i >= len(nums): return
        #choose
        path.append(nums[i])
        result.append(path.copy())
        self.getsubsets(nums, i+1, path, result)
        path.pop()

        #not choose
        self.getsubsets(nums, i+1, path, result)

# Time O(2^n)
# Space O(n)        
class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        result = [[]]

        self.getsubsets(nums, 0, [], result)
        return result

    def getsubsets(self, nums: List[int], pivot: int, path: List[int], result: List[List[int]]) -> None:
        # Base
        if pivot >= len(nums): return
        
        for i in range(pivot, len(nums)):
            path.append(nums[i])
            result.append(path.copy())
            self.getsubsets(nums, i+1, path, result)
            path.pop()

        
