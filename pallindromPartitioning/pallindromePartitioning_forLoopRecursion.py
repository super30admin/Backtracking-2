'''
Time Complexity: 0(2^n) 
Space Complexity: Recursion Stack 0(n)
'''
class Solution:
    
    def __init__(self):
        self.resultList = []
    
    def pallindromeCheck(self,subString):
        
        # start ptr
        sPtr = 0
        
        # endPtr
        ePtr = len(subString)-1
        
        # do comparison
        flag = True
        
        while sPtr <= ePtr:
            
            if subString[sPtr] != subString[ePtr]:
                # not a pallindrome
                flag = False
                break
        
            sPtr = sPtr + 1
            ePtr = ePtr - 1
            continue
            
        return flag
    
    def forLoopBasedRecursion(self,s,idx,pairStr):
        
        # base-case
        if idx == len(s):
            # reached the end
            # create a cpy of pairStr
            cpy = pairStr[:]
            self.resultList.append(cpy)
            return
        
        # logic-case
        for pivot in range(idx,len(s)):
            
            # 1. create a substring
            subString = s[idx:pivot+1]
            
            # 2. pallindrome check
            flag = self.pallindromeCheck(subString)
            
            # 3. check flag
            if flag == False:
                
                continue
            
            # 3.2. perform recursive call
            pairStr.append(subString)
            self.forLoopBasedRecursion(s,pivot+1,pairStr)
            
            # 3.3. perform backtracking
            pairStr.pop()
            
    def partition(self, s: str) -> List[List[str]]:
        
        self.forLoopBasedRecursion(s,0,[])
        
        return self.resultList