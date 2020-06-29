---------------------------------- Palindrome  Partitioning -------------------------------------
# Time Complexity : O(2^N) N is the length of the s
# Space Complexity : O(N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# 
# Here I have used backtracking solution where I choose a number or not choose a number by iterating through it.
#Here I choose the string and check weather the string is palindrome or not and call the recursive call from the next element and explore all possible combinations.
#Once I have done with that recursive call I am making the length of the temp to prev temp (similar to pop).

class Solution:
    def partition(self, s: str) -> List[List[str]]:
        def dfs(s, temp,  index):
            
            if index == len(s) and temp:
                res.append(temp[:])
                
            
            for i in range(index,len(s)):
                curr = s[index:i+1]
                l= len(temp)
                if curr == curr[::-1]:
                    temp.append("".join(curr))
                    dfs(s, temp, i+1)
                    temp = temp[:l]
        
        res = []
        dfs(list(s), [], 0)
        return res