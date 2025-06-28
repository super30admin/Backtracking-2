# Time complexity - o(2**n)
# Space complexity - o(n)

class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        result = [[]]
          
        def helper(pivot,nums, path, result):

            #base
            if pivot == len(nums):
                return


            for i in range(pivot,len(nums)):
                #actions
                path.append(nums[i])
                result.append(path[:])

                #recurse
                helper(i+1, nums, path, result)

                #backtrack
                path.pop()
            

        helper(0,nums, [], result)

        return result

        