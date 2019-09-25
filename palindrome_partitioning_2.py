"""
Palindrome partitioning 2

Find the minimum number of cuts to break a string into palindrome parts

Time complexity : O(c^n)
Space complexity : O(n) without memoization cache . with memoization cache O(c^n)

Run on leet code : yes .
                Made a stupid mistake in the next_palindrome function
                ( forgot to update the pointer for the next iteration :P) in the first submission

"""


class Solution(object):
    
    cache = {}
    
    def is_palindrome(self, s):
        return s == s[::-1]
    
    def next_palindrome(self, previous_palindrome, s):
        next_palindrome = s[:len(previous_palindrome) + 1]
        while (next_palindrome != s) and (not self.is_palindrome(next_palindrome)):
            next_palindrome = s[:len(next_palindrome) + 1]
        return next_palindrome
    
    def minCut(self, s):
        
        if self.cache.get(s):
            return self.cache[s]
        
        if (len(s) == 1) or (self.is_palindrome(s)):
            self.cache[s] = 0
            return 0
        
        first_partition = s[0]
        
        min_cut = len(s)
        
        while first_partition != s:
            r = 1 + self.minCut(s[len(first_partition):])
            min_cut = min(min_cut, r)
            first_partition = self.next_palindrome(first_partition, s)
        
        self.cache[s] = min_cut
        return min_cut
