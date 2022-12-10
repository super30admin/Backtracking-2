#Time complexity: O(n * 2^n) where n is length of string
#Space complexity: O(n) extra space for maintaining the current path as well as recursive stack space

#Accepted on Leetcode

#Approach:
#Since we cannot miss out on any partition, we use exhaustive search recursive approach
#Use for loop based recursion to maintain strings of length (1, 2 .. n-1) and for each, recursively call the subproblem with index (i + 1)
#At each point, check if curString is palindrome (if not pre-emptively return), else add to current path -> If end of string reached we know all elements in list are palindromes so simply append to result


class Solution:
    def partition(self, s: str) -> List[List[str]]:
        self.result = []

        self.recurse(s, [])

        return self.result

    def recurse(self, s, path):
        #base
        if len(s) == 0:
            self.result.append([x for x in path])
            return

        #logic
        for i in range(0, len(s)):
            curStrLeft = 0
            curStrRight = i
            if self.isSafePalindrome(s, curStrLeft, curStrRight):
                curStr = s[0:i+1]
                #action
                path.append(curStr)
                #recurse
                self.recurse(s[i+1:], path)
                #backtrack
                path.pop()

    def isSafePalindrome(self, s, l, r):
        while l < r:
            if s[l] != s[r]:
                return False
            l += 1
            r -= 1

        return True

