
# // Time Complexity :O(2^n)
# // Space Complexity :O(N)
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no


# // Your code here along with comments explaining your approach
# Use DFS+ Backtracking we add element and try to add all possible elemnts and then pop it


class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        ans,n=[],len(nums)
        def helper(nums,n,idx,path):
            ans.append([val for val in path])

            for i in range(idx,n):
                path.append(nums[i])
                helper(nums,n,i+1,path)
                path.pop()
        helper(nums,n,0,[])
        return ans





########
class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        ans = [[]]  # Start with the empty subset

        for num in nums:
            # For each number, add it to all existing subsets
            new_subsets = [subset + [num] for subset in ans]
            ans.extend(new_subsets)

        return ans
