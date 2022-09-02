import copy
class Solution(object):
    #Time Complexity: O(n*2^n)
    #Space Compleixty: O(2^n)
    
    def __init__(self):
        self.result=[]
    def __is_palindrome__(self, substring):
        if substring==substring[::-1]:
            return True
        else:
            return False
        
    def __helper__(self, s, index, path):
        #Base
        if index==len(s):
            self.result.append(copy.deepcopy(path))
        
        #Logic-- iteration will start from index to length of the string
        for i in range(index, len(s)):
            #create substring
            sub=s[index:i+1]
            if self.__is_palindrome__(sub):
                #if yes add to path
                #action
                path.append(sub)
                
                #recurse
                self.__helper__(s, i+1, path)
                
                #BACKTRACK
                path.pop()
        
    def partition(self, s):
        """
        :type s: str
        :rtype: List[List[str]]
        """
      
        
        #Null case
        if len(s) == 0:
            return[]
        
        self.__helper__(s, 0, [])
        
        return self.result
