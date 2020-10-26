# O(N * POW(2,N)) SPACE AND TIME WHERE N IS LEN OF NUMS
class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        subsets= []
        self.findSubsets(nums,0,[],subsets)
        return subsets
    
    def findSubsets(self,nums,idx,current_subset,subsets):
        if idx == len(nums):
            subsets.append(current_subset[:])
            return
        subsets.append(current_subset[:])
        for i in range(idx,len(nums)):
            current_subset.append(nums[i])
            self.findSubsets(nums,i+1,current_subset,subsets)
            current_subset.pop()