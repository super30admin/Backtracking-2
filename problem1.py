# Space Complexity: O(h) 
# Time Complexity: O(2 ^ n)

class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        ans = []

        def rec(i,res):
            if i >= len(nums):
                ans.append(res[:])
                return 


            rec(i+1,res)

            res.append(nums[i])
            rec(i+1,res)
            res.pop()


        rec(0,[])

        return ans


