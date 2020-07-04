class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        result, temp, index = [],[],0
        if not nums:
            return result
        def helper(nums, result, temp, index):
            #base
            if index==len(nums):
                result.append(temp)
                return
            #not choose
            helper(nums, result, temp[:], index+1)
            #choose
            temp.append(nums[index])
            helper(nums, result, temp[:], index+1)
        helper(nums, result, temp, index)
        return result

#time complexity - O(n*2^n), where n is the length of given list

#space complexity - O(n*2^n), as a new list is created for every decision

#all test cases passed