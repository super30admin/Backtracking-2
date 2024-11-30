# // Time Complexity :O(n * 2^n) palindrome and recursion tree 
# // Space Complexity :O(n) recursion size
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No


class Solution:
    def partition(self, s: str) -> list[list[str]]:
        res = []

        def isPalindrome(sub):                  # efficient palindrome
            l,r = 0, len(sub)-1
            while l < r:
                if sub[l] != sub[r]:
                    return False
                l+=1
                r-=1
            return True
        
        def helper(s,pivot,path):
            #base
            if pivot == len(s):                 # pivot max length? add to result
                res.append(path[:])                     
                return                          # RECURSION safety(works without it)
            
            #logic
            for i in range(pivot,len(s)):
                subStr = s[pivot:i+1]           # new subString starting point after every pivot increment

                if isPalindrome(subStr):        # if substring isPalindrome True? recurse
                    path.append(subStr)         # action
                    helper(s,i+1,path)          # recurse 
                    path.pop()                  # backtrack

        helper(s,0,[])
        return res


s = 'abaa'
x = Solution().partition(s)
print(x)