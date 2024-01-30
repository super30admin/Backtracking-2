'''

Time Complexity : O(2^n)
Space Complexity : O(2^n)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No issues faced

Your code here along with comments explaining your approach

Using for loop recursion, we iterate thru the elements and recursively add elements to a temporary list. And keep adding elements to the reuslt
list

'''

class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        res = [[]]

        def helper(nums,i,curlist):
            nonlocal res

            if i >= len(nums):
                return

            for a in range(i,len(nums)):
                curlist.append(nums[a])
                print(curlist)
                res.append(curlist.copy())
                helper(nums,a+1,curlist)
                curlist.pop()


        helper(nums,0,[])
        return list(res)
