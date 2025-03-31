'''
    Time Complexity: O(n*2^n)
    Space Complexity: O(n)
'''
class Solution:
    def __init__(self):
        self.result = []

    def partition(self, s: str) -> List[List[str]]:
        self.helper(s, 0, [])
        return self.result
        
    def helper(self, s, pivot, substrings):
        # base case
        if pivot == len(s):
            self.result.append(substrings[:])
            return

        # logic
        for i in range(pivot, len(s)):
            
            curString = s[pivot:i+1]
            print(curString, i)

            if self.isPalindrome(curString):
                substrings.append(curString)
                self.helper(s, i+1, substrings)
                substrings.pop()
            else:
                continue

    def isPalindrome(self, string):
        left = 0
        right = len(string) - 1

        while(left <= right):
            if string[left] != string[right]:
                return False

            left += 1
            right -= 1

        return True
        