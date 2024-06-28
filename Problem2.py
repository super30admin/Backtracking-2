'''
1. We start backtracking from the index 0, we maintain an end pointer one step away and check if the string between start and end is a palindrome
2. If it is, then we append that to path and backtrack with remaining piece of the string
3. We proceed until the end pointer reaches the end of string, in that case we have the splits in our path and we append that to result

TC: O(2^N) 
SC: O(N)
'''
class Solution:
    def partition(self, s: str) -> List[List[str]]:
        result = []
        def isPalindrome(s):
            return s == s[::-1]

        def backtrack(start,path):
            if start == len(s):
                result.append(path)
                return
        
            for end in range(start + 1, len(s) + 1):
                if isPalindrome(s[start:end]):
                    backtrack(end, path+[s[start:end]])
            
        backtrack(0, [])
        return result