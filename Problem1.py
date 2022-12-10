#Time complexity: O(n * 2^n) where n is length of 'nums'
#Space complexity: O(n) extra space for maintaining the current path (as well as recursive stack i.e O(h))

#Accepted on Leetcode

#Approach:
#Since we cannot miss out on any subset, we use exhaustive search recursive approach
#Use for loop based recursion to maintain subsets, recursively call the subproblem with index (i + 1) (while for loop moves index ahead as well)
#Each node is a valid subset, so capture it, use backtracking so we can maintain a single path



class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        self.soln = []
        self.recurse(nums, 0, [])

        return self.soln

    def recurse(self, nums, index, path):
        #logic
        for i in range(index, len(nums)):
            #pick cur number
            #action
            path.append(nums[i])
            #recurse
            self.recurse(nums, i + 1, path)
            #backtrack
            path.pop()

        self.soln.append([x for x in path])


