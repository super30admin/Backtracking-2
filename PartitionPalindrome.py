# TC: O( N + 2 ^ N) where N is the complexity for checking whether the string is a palindrome and 2^N is the complexity since we are 2 options for every substring checkingif its a palindrome or not. 
# SC: O(H) where H is the height of the recursive stack.

class Solution:
    def partition(self, s: str) -> List[List[str]]:
        if not s or len(s) == 0:
            return 
        
        self.result = []
        
        def isPalindrome(left, right):
            if left == right:
                return True
            while left < right:
                if s[left] != s[right]:
                    return False
                left += 1
                right -= 1
            return True
        
        def backtrack(index, path):
            
#             base
            if index == len(s):
                self.result.append(path.copy())
                return

#             logic
            for i in range(index, len(s)):
                curr_str = s[index: i + 1]
                if isPalindrome(index, i):
#                     action 
                    path.append(curr_str)
#                     recurse
                    backtrack(i + 1, path)
#                     backtrack
                    path.pop()
            
        backtrack(0, [])
        return self.result
