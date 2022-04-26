class Solution(object):
    def partition(self, s):
        """
        :type s: str
        :rtype: List[List[str]]
        """
        self.output = []
        self.helper(s,0,[])
        return self.output
        
    def helper(self, s,index,path):
        
        if(index == len(s)):
            newPath = path[:]
            self.output.append(newPath)
        
        for i in range(index,len(s)):
            subString = s[index:i+1]
            if(self.palindrome(subString)):
                path.append(subString)
                self.helper(s,i+1,path)
                path.pop()
            
            
    def palindrome(self,string):
        low = 0
        high = len(string)-1
        
        while(low < high):
            if(string[low] != string[high]):
                return False
            low += 1
            high -= 1
        return True
