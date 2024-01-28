"""
Time Complexity = O(2^n)
Space Complexity = O(n) (Using Backtracking and without creating a new list everytime traversing till the leaf and adding into the result)
"""

class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        res = []

        #subset created at the end / leaf of the decision either by choosing or not choosing the element
        leafNodeList = []

        #recursive function to iterate every element till it reaches to the leafNode 
        def dfs(i):
            if i == len(nums):
                res.append(leafNodeList.copy())
                return
            
            #choose the element
            leafNodeList.append(nums[i])
            dfs(i + 1)

            #Not choose the element
            leafNodeList.pop()
            dfs(i + 1)


        dfs(0)
        return res
        