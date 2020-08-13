class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        def helper(first=0,curr=[]):
            if len(curr)==k:
                output.append(curr[:])
            for i in range(first,n):
                curr.append(nums[i])
                helper(i+1,curr)
                curr.pop()
        output=[]
        n=len(nums)
        for k in range(n+1):
            helper()
        return output

#Time-Complexity: O(N*2^N)
#Space-Complexity: O(N*2^N)