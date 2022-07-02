"""Approach: Backtracking with for loop recursion
TC O(N x 2^N) where N is len of the string s and this is worst case complexity if all substrings are palindromes.
SC O(N) - this space will be used to stroe the recursion stack. For e.g. s='aaa' then max depth of recursive call stack will be 3.
"""

class Solution:
    def partition(self, s: str) -> List[List[str]]:
        #base case
        if not isinstance(s, str) or len(s) == 0:
            return []
        
        result = []
        
        def isPalindrome(s):
            i, j = 0, len(s)-1
            while i<j:
                if not s[i] == s[j]:
                    return False
                i+=1
                j-=1
            return True
            
        def helper(index, path):            
            # if index become len of string s we add path to result
            if index == len(s):
                result.append(path[:])
            # iterate over index to len(s)
            for i in range(index,len(s)):
                # use index:i+1 slice, as if you use just `i`, it may produce empty strings
                #  s = "aab"; s[:0]=> ''; s[:1]=> 'a'
                ss = s[index:i+1]
                if isPalindrome(ss):# if the substr is palindrome then
                    # action
                    path.append(ss) # append it to path
                    # recurse
                    helper(i+1, path) # increment i by 1 as we don't want repitations
                    #backtrack
                    path.pop() # remove last added substr from path to avoid inaccurate long result
                    # e.g. for s ="aab" it may give us [["a","a","b"],["a","a","b","aa","b"]] if we don't backtrack

        helper(0, [])
        
        return result



"""Approach: Backtracking with for loop recursion with DP
TC O(N x 2^N) where N is len of the string s and this is worst case complexity if all substrings are palindromes. Although
we are eliminating some of the N calls to checkPalindrome function while loop by storing the results in the hashmap. Trade space for time.
SC O(N) - this space will be used to stroe the recursion stack. For e.g. s='aaa' then max depth of recursive call stack will be 3.
Plus space required by Map of all palindrome strings.
"""

class Solution:
    def partition(self, s: str) -> List[List[str]]:
        #base case
        if not isinstance(s, str) or len(s) == 0:
            return []
        
        result = []
        dp = {} # store result of isPalindrome for various substrs, so we don't recalculate those
        def isPalindrome(s):
            if s in dp and dp[s]:
                # print(dp)
                return True
            i, j = 0, len(s)-1
            while i<j:
                if not s[i] == s[j]:
                    return False
                i+=1
                j-=1
            dp[s] = True
            return True
            
        def helper(index, path):            
            # if index become len of string s we add path to result
            if index == len(s):
                result.append(path[:])
            # iterate over index to len(s)
            for i in range(index,len(s)):
                # use index:i+1 slice, as if you use just `i`, it may produce empty strings
                #  s = "aab"; s[:0]=> ''; s[:1]=> 'a'
                ss = s[index:i+1]
                if isPalindrome(ss):# if the substr is palindrome then
                    # action
                    path.append(ss) # append it to path
                    # recurse
                    helper(i+1, path) # increment i by 1 as we don't want repitations
                    #backtrack
                    path.pop() # remove last added substr from path to avoid inaccurate long result
                    # e.g. for s ="aab" it may give us [["a","a","b"],["a","a","b","aa","b"]] if we don't backtrack

        helper(0, [])
        
        return result