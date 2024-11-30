class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        result = []

        def helper(i, path):
            #base case
            if i==len(nums):
                result.append(path[:])
                return

            #logic
            #choose case
            path.append(nums[i])
            helper(i+1, path)
            path.pop()

             #no choose
            helper(i+1, path)
      
        helper(0,[])
        return result
        