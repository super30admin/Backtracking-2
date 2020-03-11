'''
Time Complexity: O(3^n)
Space Complexity: O(n)
Did this code successfully run on Leetcode : Yes
Explanation: Create a complete space of all possible combinations and backtrack whenever you overshoot the target.
'''
import copy


class Solution:
    def palindorme(self, s: str, start: int, end: int):
        while start <= end:
            if s[start] != s[end]:
                return False
            start += 1
            end -= 1
        return True

    def backTrack(self, solution: list, s: str, state: list, start: int):
        if start == len(s):
            solution.append(copy.deepcopy(state))
            return

        for end in range(start, len(s)):
            if self.palindorme(s, start, end):
                # insert state from start to end+1
                state.append(s[start:end + 1])
                self.backTrack(solution, s, state, end + 1)
                state.pop()

    def partition(self, s: str) -> List[List[str]]:
        solution = []
        self.backTrack(solution, s, [], 0)
        return solution