
# Time complexity O(N * 2 ^N)
# Space complexity O(N)
class Solution:
    def partition(self, s: str) -> List[List[str]]:
        
        
        def dfs(start,result,curr_list,s):
            if start >= len(s):
                result.append(list(curr_list))
            for x in range(start,len(s)):
                if ispalindrome(s,start,x):
                    curr_list.append(s[start:x+1])
                    dfs(x+1,result,curr_list,s)
                    curr_list.pop(-1)
        
        def ispalindrome(s,low,high):
            while low<high:
                if s[low] !=s[high]:
                    return False
                low+=1
                high-=1
            return True
                
        self.result = []
        dfs(0,self.result,[],s)
        return self.result
       
        
