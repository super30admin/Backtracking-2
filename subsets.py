class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        output = []
        def helper(curr, index):
            output.append(curr[:])
            
            for i in range(index, len(nums)):
                curr.append(nums[i])
                helper(curr, i+1)
                curr.pop()
            return output
        return helper([], 0)


#Time :  (2^N)*N
#Space : (2^N)*N