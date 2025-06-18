"""
I implemented the approach discussed in the session, where I used two loops one iterating over the input array and another over the existing subsets in the result. In each iteration, I created new subsets by adding the current number to each existing subset and added them to the result.
Time Complexity: O(2^n)
Space Compelxity: O(2^n)
"""
class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        result = [[]]

        for n in nums:
            size = len(result)
            for i in range(size):
                subset = result[i] + [n]
                result.append(subset)

        return result