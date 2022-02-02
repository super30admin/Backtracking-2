#Time and Space Complexity O( N * x^ N)
class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        def recursion(f = 0, curr = []):
            if len(curr) == k:  
                output.append(curr[:])
                return
            
            for i in range(f, n):
                curr.append(nums[i])
                recursion(i + 1, curr)
                curr.pop()
        
        output = []
        n = len(nums)
        for k in range(n + 1):
            recursion()
        return output
