# Time Complexity :
# Space Complexity :
# Did this code successfully run on Leetcode :
# Any problem you faced while coding this :

# Your code here along with comments explaining your approach
# Using Backtracking. Iterate over the string and check if the string form index to i is a palindrome or not
# If it is then 1. Action append deep copy of path to res as we found the substring that is a palindrome from index to i+1
# 2. Recurse calling the helper function by incrementing i by 1 to include the next character in string s
# 3. Backtrack to remove the element from path to explore all other paths that satisfy the palindrome condition


class Solution:
    def partition(self, s: str) -> List[List[str]]:
        self.res = []
        if not s:
            return self.res
        self.helper(s, 0, [])
        return self.res

    def helper(self, s, index, path):
        #base
        if index == len(s):
            self.res.append(copy.deepcopy(path))
            return
        #logic
        for i in range(index, len(s)):
            if self.isPalindrome(s, index, i):
                #action
                path.append(s[index:i + 1])
                #recurse
                self.helper(s, i + 1, path)
                #backtrack
                path.pop()

    def isPalindrome(self, s, left, right):
        if left == right:
            return True
        while left < right:
            if s[left] != s[right]:
                return False
            left += 1
            right -= 1
        return True