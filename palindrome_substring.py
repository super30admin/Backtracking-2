#Time Complexity: O(2**N * N).
#Auxiliary Space: O(N)
#Did this code successfully run on Leetcode :Yes

class Solution(object):
    def partition(self, s):
        """
        :type s: str
        :rtype: List[List[str]]
        """
        if len(s)==0:
            return []
        
        result = []
        n =len(s)
        def ispalindrome(string):
            i =0
            j = len(string)-1
            res = True
            while(i<=j):
                if string[i]!=string[j]:
                    res = False
                    break
                i+=1
                j-=1

            return res
        def helper(index,path):
            if index == n:
                result.append(list(path))
                return
            
            for i in range(index,n):
                ch = s[index:i+1]
                if ispalindrome(ch):
                    path.append(ch)
                    helper(i+1, path)
                    path.pop()
                
                
        helper(0,[])
        return result