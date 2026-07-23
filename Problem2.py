# Problem2: Palindrome Partitioning(https://leetcode.com/problems/palindrome-partitioning/)
#Time Complexity: O(2^n * n), For a string of length n, there are roughly 2^n ways to cut it into pieces, since each position can either be a cut point or not. For every one of those partitions, we spend O(n) work doing substring slicing and palindrome checking.
#Space Complexity: O(n^2), The recursion goes n levels deep in the worst case, one level per character.At each level we create new substrings using slicing and slicing costs O(n) each time.Across all n levels this substring creation adds up to O(n^2). This does not count the space used by self.result since that is the output itself.

#Approach:
#We break the string from the front and check each prefix to see if it is a palindrome.
#If it is, we add it to our current path and keep exploring the rest of the string.
#Once the whole string is used up, we save that valid split and backtrack to try other options.


class Solution:
    def partition(self, s: str) -> List[List[str]]:
        self.result = []            # this will hold every valid palindrome partition we find
        self.helper(s, [])          # start recursion with full string and an empty path
        return self.result          # return all collected partitions
    
    def helper(self, s, path):
        if len(s) == 0:                      # if nothing is left to process
            self.result.append(path.copy())   # save a copy of path, not the same list, so future changes do not affect it
            return                      
        
        for i in range(len(s)):                 # try every possible length for the next piece
            sub_string = s[:i+1]                # take characters from start up to index i, i+1 because slicing excludes the last index
            if self.isPalindrome(sub_string):   # only continue if this piece is a valid palindrome
                path.append(sub_string)         # action, commit to using this piece

                self.helper(s[i+1:], path)      # recurse, pass in everything after this piece as the new remaining string

                path.pop()                      # backtrack, undo our choice so the next loop iteration starts clean
    
    def isPalindrome(self, s):
        left, right = 0, len(s)-1       # two pointers, one at start, one at end
        while left < right:             # move inward until pointers meet or cross
            if s[left] != s[right]:     # compare actual characters, not indices
                return False            # mismatch found, not a palindrome
            left += 1                    
            right -= 1               
        return True                  