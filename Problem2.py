# Time complexity : O(2 ^ n)
# Space complexity : O(n * 2^n)
# Leetcode : Solved and submitted

class Solution:
    def partition(self, s: str) -> List[List[str]]:
        self.res = []
        # if string is not null, then return empty list 
        if not s:
            return self.res
        
        # call the helper function with pivot as 0 and empty path
        self.helper(s, 0, [])
        return self.res
    
    def helper(self, s, pivot, path):
        # if we have reached to the end of the string, only then add the path to the result
        if pivot == len(s):
            self.res.append(path[:])
            return
        
        # logic
        # starting for loop from pivot till the end of the string s
        for i in range(pivot, len(s)):
            # making a substring from pivot till i + 1
            sub = s[pivot:i+1]
            # check if substring is palindrome, if no then we do not proeed with recursion on that
            if self.isPal(sub):
                # action
                # add the subtring to the path
                path.append(sub)
                
                # recurse
                # resursively call the helper function by incrementing the i by 1
                self.helper(s, i + 1, path)
                
                # backtrack
                # remove the last appened value to path
                path.pop()
        
    # function to check if string is palindrome or not
    # start and end are the extreme indexes of string, check if first and last element are same, if so move inwwards until they meet, or else return False
    def isPal(self, st):
        start = 0
        end = len(st) - 1 
        while(start < end):
            if st[start] == st[end]:
                start += 1
                end -= 1
            else:
                return False
        return True
