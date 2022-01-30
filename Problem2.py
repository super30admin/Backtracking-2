# // Time Complexity : O(n * 2^n)
# // Space Complexity : O(n)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : Class Solution.
class Solution:
    def partition(self, s: str) -> List[List[str]]:
        def isPalindrome(s):
            i = 0
            j = len(s)-1
            while(i < j):
                if s[i] != s[j]:
                    return False
                i += 1
                j -= 1
            return True
        self.result = []
        
        
        
        def helper(s,index,path):
            # base
            if index == len(s):
                self.result.append(path)
                return
            
            # logic
            for i in range(index,len(s)):
                temp = s[index: i + 1]
                if isPalindrome(temp):
                    path_copy = path.copy()
                    path_copy.append(temp)
                    helper(s,i+1,path_copy)
        helper(s,0,[])
        return self.result
