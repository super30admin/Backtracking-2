class Solution:
    result = []
    
    def partition(self, s: str) -> List[List[str]]:
        
        if not s:
            return[]
        
        self.helper(s, 0,[])
        
        return Solution.result
    
    
    def helper(self,s,index,path):
        
        #base
        if(index == len(s)):     
            #print(path)
            Solution.result.append(path.copy())
            return
        
        #logic
        #choose
        for i in range(index,len(s)):
            
            if self.ispalindrome(s[index:i+1]):                
                path.append(s[index:i+1])    
                #print(path)
                self.helper(s,i+1,path)
                path.pop()
      
    def ispalindrome(self,path):
        
        return path == path[::-1] 
 

