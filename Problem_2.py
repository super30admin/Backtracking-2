"""
Time Complexity : O(N*2^N) where N fis length of the string and there can be 2^n substrings 
when all possible substrings are palindrome 
Space Complexity : O(N) 
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No


Your code here along with comments explaining your approach
Here, at every pivot we are traversing a loop from index to i. If we findstring[index:i] is  a palindrome, we 
put it inside the temp list and iterate further to find further cases. If that is not a palindrome,
we do not iterate further and come out of recursion to arry forward where we left from.
"""


class Solution:
    def partition(self, s: str) -> List[List[str]]:
        self.result = []
        if not s:
            return self.result
        self.helper(s, [], 0, len(s))
        return self.result

    def helper(self, s, temp, index, l):

        if index == l:
            newtemp = copy.deepcopy(temp)
            self.result.append(newtemp)
            return

        for i in range(index, l):
            if self.isPalindrome(s, index, i):
                temp.append(s[index:i+1])
                self.helper(s, temp, i+1, l)
                temp.pop()

    def isPalindrome(self, word, left, right):
        if left == right:
            return True
        while left < right:
            if word[left] != word[right]:
                return False
            left += 1
            right -= 1
        return True
