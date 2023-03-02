"""
Rasika Sasturkar
Time Complexity: O(2^n)
Space Complexity: O(n)
"""


class Solution:
    """
    3 types of solution - 1st without using recursion in which we add nums[i]
    in each iteration to all the lists in result.
    2nd is Brute force i.e. choose or not choose using backtracking.
    3rd is using for-loop recursion in which for loop starts from pivot and uses
    backtracking.
    """
    result = []

    def subsets(self, nums):
        self.result = []

        # null case
        if nums is None:
            return self.result

        # without using recursion
        self.result.append([])
        for i in range(len(nums)):
            res_size = len(self.result)
            for j in range(res_size):
                temp = self.result[j].copy()
                temp.append(nums[i])
                self.result.append(temp)

        # using recursion
        # self.helper(nums, 0, [])
        return self.result

    # brute force
    # def helper(self, nums, idx, path):
    #     # base case
    #     if idx == len(nums):
    #         temp = path.copy()
    #         self.result.append(temp)
    #         return
    #     # logic
    #     # not choose
    #     self.helper(nums, idx+1, path)
    #     # choose
    #     path.append(nums[idx]) # action
    #     self.helper(nums, idx+1, path) # recurse
    #     path.pop() # backtrack

    # using for-loop recursion
    # def helper(self, nums, pivot, path):
    #     # no base case
    #     self.result.append(path.copy())
    #     # logic
    #     for i in range(pivot, len(nums)):
    #         path.append(nums[i]) # action
    #         self.helper(nums, i+1, path) # recurse
    #         path.pop() # backtrack


def main():
    """
    Main function - examples from LeetCode problem to show the working.
    This code ran successfully on LeetCode and passed all test cases.
    """
    s = Solution()
    print(s.subsets(nums=[1, 2, 3]))  # return [[], [1], [2], [1, 2], [3], [1, 3], [2, 3], [1, 2, 3]]
    print(s.subsets(nums=[0]))  # return [[], [0]]


if __name__ == "__main__":
    main()
