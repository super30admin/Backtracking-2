#Time Complexity :O(2^n)
#Space Complexity :O(N) n islenght of string
#Did this code successfully run on Leetcode :yes
#Any problem you faced while coding this : No
class Solution(object):
    ans=None
    def partition(self, s):
        """
        :type s: str
        :rtype: List[List[str]]
        """
        if(s==None or len(s)==None):
            return []
        
        self.ans=[]
        self.helper(s,0,[])
        return self.ans
    
    def isPalindrome(self,s,low,high):
        while(low<=high):
            if(s[low]!=s[high]):
                return False
            low+=1
            high-=1
        return True
        
    def helper(self,s,index,path):
        #base
        if(index==len(s)):
            self.ans.append(copy.deepcopy(path))
        #Logic
        for i in range(index,len(s)):
            if(self.isPalindrome(s,index,i)):
                path.append(s[index:i+1])
                self.helper(s,i+1,path)
                path.pop()
        