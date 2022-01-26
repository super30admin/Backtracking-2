# Time Complexity : N * 2 ^ (N)
        # Since, we have two choices partition or do not partition and we make this choice N times
        # Our recursion tree will have 2 ^ (N) nodes. Additionally, each call has O(N) time
        # Hence, N * 2^(N)
# Space Complexity : O(N) for the recursive stack in the case of evaluating each char as a palindrome
# Did this code successfully run on Leetcode :
# Any problem you faced while coding this :


# Your code here along with comments explaining your approach

class Solution:
    def partition(self, s: str) -> List[List[str]]:
        result = []
        
        def isPali(string):
            left = 0
            right = len(string) - 1
            while left < right:
                if string[left] != string[right]:
                    return False
                left += 1
                right -= 1
            return True
        
        def recur(start, combi):
            nonlocal result
            if start == len(s):
                result.append(combi[:])
                return
            
            for i in range(start, len(s)):
                left_part = s[start:i + 1] # O(N)
                if isPali(left_part): #if left part is palindrome then we are at a valid partioning, O(N)
                    combi.append(left_part) 
                    recur(i + 1, combi)
                    combi.pop()


'''Using DP to avoid revaluating known palindromes'''
class Solution:
    def partition(self, s: str) -> List[List[str]]:
        result = []
        dp = [[False] * len(s) for _ in range(len(s))]
        def recur(start, combi):
            nonlocal result
            # base case
            if start == len(s):
                result.append(combi[:])
            
            # logic
            for i in range(start, len(s)):
                left_part = s[start:i + 1]
                if (s[start] == s[i]) and (i - start <= 2 or dp[start + 1][i - 1] == True):
                    dp[start][i] = True
                    combi.append(left_part)
                    recur(i + 1, combi)
                    combi.pop()
                    
        recur(0, [])
        return result
