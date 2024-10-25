"""
Approach1: choose and not choose.
Start traversing the array, either I can choose, meaning add the element to the result or I decide not to choose, meaning
result remains the same.
If I follow the choose path, the result array will have an added element; then it moves on to the next level, meaning
the next index where again choose not choose is followed.
 If I follow not choose path the result array will be same; then it moves on to the next level, meaning
the next index where again choose not choose is followed.
The results will be all leaf nodes
number of levels = n, since at each level we make the choice
TC: number of nodes, at each level 2 babies are created, 2^n.
SC: stack size O(n)
TC without backtracking: 2^n for nodes *( 2 * n) to copy the list
SC without backtracking: O(n) + 2 * 2^n to create copy at each node.

Approach2: for loop-based recursion
If at each stage there are more than 2 babies, then for loop-based recursion is more intuitive. In most of the cases
0-1 recursion is possible, but it would be too complex.
(1) For a given level, pivot remains the same.
(2) At each level, for loop will run from pivot onwards
TC: same as 0-1 since the number of nodes created would be same. The difference is in the shape of tree.
"""


class Solution_backtrack:
    def helper(self, nums, i, subset):
        # base case
        if i >= len(nums):
            self.ans.append(subset[:])
            return

        # logic
        # no choose
        self.helper(nums, i + 1, subset)

        # choose
        # action
        subset.append(nums[i])
        # recurse
        self.helper(nums, i + 1, subset)
        # backtrack
        subset.pop()

    def subsets(self, nums: List[int]) -> List[List[int]]:
        self.ans = []
        self.helper(nums, 0, [])
        return self.ans


class Solution_without_backtrack:
    def helper(self, nums, i, subset):
        # base case
        if i >= len(nums):
            self.ans.append(subset)
            print(subset)
            return

        # don't choose
        # creat a new array and copy it
        temp = subset[:]
        self.helper(nums, i + 1, temp)

        # choose
        # creat a new array and copy it and add next item
        temp = subset[:]
        temp.append(nums[i])
        self.helper(nums, i + 1, temp)

    def subsets(self, nums: List[int]) -> List[List[int]]:
        self.ans = []
        self.helper(nums, 0, [])
        return self.ans


class Solution_for_loop_based:
    def helper(self, nums, pivot, path):
        # base case
        # there is no base case, but t
        if pivot >= len(nums):
            # this is needed since the subset are formed at every node
            self.ans.append(path[:])
            return

            # recursion
        # subsets are formed at every node
        self.ans.append(path[:])

        # a node will have len(nums) - pivot babies
        # pivot out of bounds is taken care by for loop
        for i in range(pivot, len(nums)):
            # action
            path.append(nums[i])
            # recurse
            # move pivot to the next number, since the same number cannot be chosen again and again
            self.helper(nums, i + 1, path)
            # backtrack
            path.pop()

    def subsets(self, nums: List[int]) -> List[List[int]]:
        self.ans = []
        self.helper(nums, 0, [])
        return self.ans
