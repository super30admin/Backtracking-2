"""
Name: Srinidhi

Time Complexity: O(2^n) - 
Space Compplexity: O(n)

Logic: Using backtracking find all the combinations possible
for each combination, call isPalindrome and find if the generated
string is a palindrome. 
"""
class Solution:
    def partition(self, s: str) -> List[List[str]]:
        
        def isPalindrome(start_index,end_index):
            while start_index <=end_index:
                if s[start_index]!=s[end_index]:
                    return False
                
                start_index+=1
                end_index-=1
                
            return True
        
        
        def dfs(start_index,path):
            if start_index >=len(s):
                self.res.append(path)
            
            
            for l in range(len(s) - start_index):
                if isPalindrome(start_index,start_index+l):
                    dfs(start_index+l+1,path+[s[start_index:start_index+l+1]])
            
        self.res = []
        dfs(0,[])
        return self.res