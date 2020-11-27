# Accepted on leetcode(131)
# time - O(2^N) , space - O(N)
# As here, we have to subdivide the string such are each of it's partition is a palindrome.
# Here, I am using backtracking to find every possibility by exploring all paths.
# whenever the parts of string are palindrome it is added to the result
class Solution:
    def partition(self, s: str):
        result = []
        # edge case
        if len(s) == 0: return result
        self.backtrack(s, [], 0, result)
        return result

    def backtrack(self, s, temp, start, result):
        # Base case
        if len(temp) > 0 and start >= len(s): # check if temp has string and start index is withon the string.
            # print(temp)
            result.append(temp[:])
        # Logic
        for i in range(start, len(s)):
            print("Before : ", start, i)
            if self.isPalindrome(s, start, i): # Take that string only if it is a palindrome
                print("After : ",start, i)
                if start == i: # if i is same as start just simply append as it is only one character
                    temp.append(s[i])
                else:
                    temp.append(s[start:i + 1]) # else append part of the string
                self.backtrack(s, temp, i + 1, result) # then again backtrack to find rest of the string's palindromes
                temp.pop(-1)

    def isPalindrome(self, s, l, r):
        if l == r: return True
        while l < r:
            if s[l] != s[r]:
                return False
            l += 1
            r -= 1
        return True

sol = Solution()
print(sol.partition("aab"))
