class Solution(object):
    def partition(self, s):
        """
        :type s: str
        :rtype: List[List[str]]
        """
        #exponential
        #O(N)
        self.res=[]
        if not s:
            return self.res
        #check palindrome
        def check(w,l,r):
            while l < r:
                if w[l] != w[r]:
                    return False
                l+=1
                r-=1
            return True
        
        def helper(s,index,temp):
            #if found add to result
            if index==len(s):
                self.res.append(temp[:])
                return
            
            else: 
                for i in range(index,len(s)):
                    print(temp,index,i)
                    #if index==i that means only one character >> always a palindrome
                    if index==i or check(s,index,i):
                        temp.append(s[index:i+1])
                        helper(s,i+1,temp)
                        temp.pop()
        helper(s,0,[])
        return self.res