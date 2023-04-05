# Time Complexity: O(n * 2**n) n is for the palindrome check and 2**n is the time taken for the recursion (n is the len(s))
# Space Complexity: O(n)
class Solution:
    def partition(self, s: str) -> List[List[str]]:
        global result
        result = []

        # # For Loop Recursion
        # def recursion(pivot, path):
        #     global result
        #     # Base Case
        #     if pivot == len(s):
        #         result.append(path.copy())
        #         return
        #     # Logic
        #     for i in range(pivot, len(s)):

        #         # Action
        #         temp = s[pivot:i+1]
        #         if temp == temp[::-1]: # Palindrome Check
        #             path.append(temp)
        #             # Recurse
        #             recursion(i+1, path)
        #             # Backtrack
        #             path.pop()

        # recursion(0, [])
        # return result

        # 0-1 Recursion
        def recursion(idx, i, path, count):
            # Base Case
            if i == len(s):
                if count == len(s):
                    result.append(path.copy())
                return

            # Logic
            # Don't Choose
            recursion(idx, i + 1, path, count)
            # Choose
            temp = s[idx:i + 1]
            if temp == temp[::-1]:  # Palindrome Check
                # action
                path.append(temp)
                # recurse
                recursion(i + 1, i + 1, path, count + len(temp))
                # Backtrack
                path.pop()

        recursion(0, 0, [], 0)
        return result






