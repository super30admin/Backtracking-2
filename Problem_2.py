#131. Palindrome Partitioning

#Code:

class Solution:
    def partition(self, s: str) -> List[List[str]]:
        
        def backtrack(start, end, tmp):
            if start == end:
                ans.append(tmp[:])
            for i in range(start, end):
                cur = s[start:i+1]
                if cur == cur[::-1]:
                    tmp.append(cur)
                    backtrack(i+1, end, tmp)
                    tmp.pop()
        ans = []
        backtrack(0, len(s), [])
        return ans



# Time Complexity: O(N^N)
# Space Complexity: O(N)
# Accepted on Leetcode: Yes