# Time Complexity : It is O(n) since we are iterating with the list.
# Space Complexity : It is O(n) we can insert all elements in the queue if value is 1.
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this :

from typing import List
import copy

class Solution:
    def partition(self, s: str) -> List[List[str]]:
        permutation=[]
        result=[]          
        Solution.calPermutation(s,0,permutation,result)
        return result
    
    def calPermutation(s: str, pivot:int, permutation:[],result:[]): 
        if len(s)==pivot:
            result.append(permutation)
            return     
        #permutation.append(s[pivot]) 
        for i in range(pivot,len(s)):  
            updatedStr = s[pivot:i+1]
            #action
            if(updatedStr != '' and Solution.isPalindrome(updatedStr)):  
                permutation.append(updatedStr)
                #recurse            
                Solution.calPermutation(s,i+1,copy.deepcopy( permutation),result)
                #Solution.calPermutation(s,i+1,permutation,result)
                
                #backtrack
                permutation.pop()
    
    def isPalindrome(palStr: str)-> bool:
        lenStr = len(palStr)//2
        for i in range(lenStr):
            if palStr[i] != palStr[(len(palStr)-1)-i]:
                return False
        return True
    
        
        
obj = Solution()
#print(obj.partition("abcba"))
print(obj.partition("aaba"))