# Time Complexity :
# O(2^n * n)       n  = Length of string  [2^n Exponential for each char under consideration, due to recursion]

# Space Complexity :  
# O(2^n * n)       Exponential, due to recursion stack space

# Approach:
# For-loop based recursion


class Solution(object):
    def __init__(self):
        self.result = []
    def partition(self, s):
        """
        :type s: str
        :rtype: List[List[str]]
        """
        # ==================== Approach 1: For-loop Recursion ============================ #
        if not s or len(s)==0:
            return

        self.recurse(s, 0, [])
        return self.result

    def recurse(self, s, index, path):
        # base
        if index == len(s):
            self.result.append(path)

        # logic
        for i in range(index, len(s)):
            if (self.isPalindrome(s, index, i)):
                newList = list(path)
                currStr = s[index:i+1]
                newList.append(currStr)
                #recurse
                self.recurse(s, i+1, newList)

    
    def isPalindrome(self, s, left, right):
        while(left<right):
            if s[left] != s[right]:
                return False
            else:
                left+=1
                right-=1
        return True