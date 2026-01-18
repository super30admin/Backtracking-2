''' 
Time Complexity: O(n * 2^n)
Space Complexity: O(n)

Approach: We use backtracking to explore all possible partitions of the string. At each step, we check if the current substring is a palindrome. 
If it is, we include it in the current partition and continue exploring further.
 If we reach the end of the string, we add the current partition to the result.

'''

class Solution:
    def partition(self, s: str) -> List[List[str]]:
        
        path = []
        res = [] 

        def solve(start):
            if start>=len(s):
                res.append(path.copy())
                return 
            
            for i in range(start, len(s)):
                if s[start:i+1]==s[start:i+1][::-1]:
                    path.append(s[start:i+1])
                    solve(i+1)
                    path.pop()
        solve(0)
        return res
            