"""
Leetcode-https://leetcode.com/problems/subsets/ (submitted)
TC- O(output) where output is number of permutations, SC- O(1)
Challenges - where to add path in result in recursion.
Lecture-https://www.youtube.com/watch?v=ciYRVgANgbM
FAQ-
Two recursion approaches? 01 recursion and for recursion. (both require choose and not choose choices)
Iterative approach? Yes, refer code
All approaches iterative and recursive will have same time complexity.


Given an integer array nums of unique elements, return all possible subsets (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.


Example 1:
Input: nums = [1,2,3]
Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]

Example 2:
Input: nums = [0]
Output: [[],[0]]


Constraints:
1 <= nums.length <= 10
-10 <= nums[i] <= 10
All the numbers of nums are unique.
"""


class Solution:
    """
    *most optimized*
    Ideation- iterative brute force O(output * N (deep copy)), where output is number of permutations, SC- O(1)

    result = [[]]
    start with empty list and add element at index i to each combination inside the result and go to next element in
    for loop and repeat.

    When you at element ith, you make your first combination with result and add it to result, you don't to make your
    later combinations of same element with its previous combination. To solve this, run your second for loop for
    combinations on your parent result list. *check comment in code*
    """

    def subsets(self, nums):
        result = [[]]
        for i in range(len(nums)):
            # using rSize because we are constantly adding to the result and if we run on range(len(range)) it will go
            # forever. Also, we don't want to add to combination with it's siblings.
            rSize = len(result)
            for j in range(rSize):
                # make a fresh copy of new combination
                newComb = result[j][:]
                newComb.append(nums[i])
                result.append(newComb)

        return result

    """
    *Most optimized solution*
    Ideation- 01 Recursion with backtracking O(output * N (deep copy)) where output is number of permutations TC,
    SC- O(1)

    Just as regular recursion, we will choose between choose and not choose for the index 'i', if we choose, we add it to
    path and then backtrack it.

    The leafs of our recursion tree (base case) will be our subsets. *Refer recursion tree in pdf*
    """

    # 01 recursion, choose and no choose for a particular index on the list
    def subsets1(self, nums):
        self.result = []
        if not nums:
            return self.result
        self.helper1(nums, 0, [])
        return self.result

    def helper1(self, nums, i, path):
        if i == len(nums):
            self.result.append(path[:])
            return
        # no choose
        self.helper1(nums, i + 1, path)
        # choose
        # action
        path.append(nums[i])
        self.helper1(nums, i + 1, path)
        # backtrack
        path.pop()

    """
    *most optimized solution*
    Ideation-for loop recursion with backtracking O(output * N (deep copy)) where output is number of permutations TC, 
    SC- O(1)
    
    Idea remains the same - to choose and not choose
    The perspective will be different. Choose will be when we add to path and increment i + 1, not choose will be 
    taking no action in the for loop and the i pointer will be incremented without adding it to the path.
    Remember to bactrack when you add to the path.
    
    each recursion call will have our subset, append it to the result *refer recursion tree in pdf*
    """

    # for loop recursion with backtracking O(output) where output is number of permutations TC, SC- O(1)
    def subsets2(self, nums):
        self.result = []
        if not nums:
            return self.result
        self.helper2(nums, 0, [])
        return self.result

    def helper2(self, nums, index, path):
        # base - no base case required since our i will not go out of bound
        # logic
        self.result.append(path[:])
        for i in range(index, len(nums)):
            # choose
            # action
            path.append(nums[i])
            self.helper2(nums, i + 1, path)
            # backtrack
            path.pop()
            # no choose selected by default on i + 1

    """
    Ideation- brute force recursion O(output * N (deep copy)) where output is number of permutations TC, SC- O(N)
    
    Idea remains the same again, only we don't have to backtrack if we are sending different reference of same copy of
    path.
    
    We are also making deep copy for no choose, which will be extra time space
    """

    def subsets3(self, nums):
        self.result = []
        if not nums:
            return self.result
        self.helper1(nums, 0, [])
        return self.result

    def helper3(self, nums, i, path):
        # base case
        if i == len(nums):
            self.result.append(path)
            return
        # logic
        # no choose
        self.helper3(nums, i + 1, path[:])
        # choose
        path.append(nums[i])
        self.helper3(nums, i + 1, path[:])
