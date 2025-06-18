"""
Begin from empty subset and check each element
At each step, add current subset to result
Recurse by including or skipping current element
"""
"""
Time Complexity: O(2^n) – Every element has 2 choices: yes or no
Space Complexity: O(n) – Recursion depth
"""

from typing import List

class subSets:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        result = []

        def backtrack(start, path):
            result.append(list(path))
            for i in range(start, len(nums)):
                path.append(nums[i])
                backtrack(i + 1, path)
                path.pop()  

        backtrack(0, [])
        return result

if __name__ == "__main__":
    obj = subSets()
    print(obj.subsets([1, 2, 3]))

