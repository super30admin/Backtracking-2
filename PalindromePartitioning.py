#TC:O(n*2^n)
class Solution(object):
    def partition(self, s):
        """
        :type s: str
        :rtype: List[List[str]]
        """
        result=[]
        if s==None or len(s)==0: return result
        
        def helper(s,idx,path):
            #base
            if len(s)==idx:
                result.append(path[:])
                return 
            #logic
            for i in range(idx,len(s)):
                str1=s[idx:i+1]
                if isPalindrome(str1):
                    #action
                    path.append(str1)
                    #recursion
                    helper(s,i+1,path)
                    #backtracking
                    path.pop()
                    
        def isPalindrome(s):
            st=0
            e=len(s)-1
            while(st<e):
                if s[st]!=s[e]: return False
                st+=1
                e-=1
            return True
        
        helper(s,0,[])
        return result

'''
class Solution(object):
    def partition(self, s):
        """
        :type s: str
        :rtype: List[List[str]]
        """
        result=[]
        if s==None or len(s)==0: return result
        
        def helper(s,path):
            #base
            if len(s)==0:
                result.append(path[:])
                return 
            #logic
            for i in range(0,len(s)):
                str1=s[:i+1]
                if isPalindrome(str1):
                    #action
                    path.append(str1)
                    #recursion
                    helper(s[i+1:],path)
                    #backtracking
                    path.pop()
                    
        def isPalindrome(s):
            st=0
            e=len(s)-1
            while(st<e):
                if s[st]!=s[e]: return False
                st+=1
                e-=1
            return True
        
        helper(s,[])
        return result
'''