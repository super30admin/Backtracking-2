class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        result = []
        self.backtrack(nums, result, 0, [])
        return result
    
    def backtrack(self, nums, result, index, temp):
        result.append(temp[:])
        for i in range(index, len(nums)):
            temp.append(nums[i])
            self.backtrack(nums, result, i+1, temp)
            temp.pop()


#time complexity - O(n*2^n)

#space complexity - O(n*2^n)

#all test cases passed