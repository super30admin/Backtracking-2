# Time Complexity: O(2^n) where n is the length of the str
# Space Complexity:  O(n)
#  Did this code successfully run on Leetcode : Yes
#  Any problem you faced while coding this : No


class Solution:
    def partition(self, s: str) -> List[List[str]]:

        def isPalindrome(s):
            low = 0
            high = len(s) - 1
            while (low < high):
                if s[low] != s[high]:
                    return False
                low += 1
                high -=1
            return True
        
        self.result = []
        def helper(s, index, path):
            if index == len(s):
                self.result.append(list(path))
                return 
            for i in range(index, len(s)):
                temp = s[index:i+1]
                if isPalindrome(temp) == True:
                    path.append(temp)
                    helper(s, i+1, path)
                    path.pop() 
        helper(s, 0, [])
        return self.result
    