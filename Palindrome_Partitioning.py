class Solution:
    
    def partition(self, s: str) -> List[List[str]]:
        
        N = len(s)
        result, path = [], []
        
        def isPalindrome(s_idx, e_idx):
            while s_idx < e_idx:
                if s[s_idx] != s[e_idx]:
                    return False
                s_idx+=1
                e_idx-=1
            return True  
        
        def helper(index=0):                                
            
            ### Base Case
            if index == N:
                 result.append(path.copy())
            
            ### Logic            
            for i in range(index, N):                       
                if isPalindrome(index, i):                  
                    path.append(s[index:i+1])   # Action    
                    helper(i+1)                 # Recurse
                    path.pop()                  # BackTrack
                    
        helper()
        return result
                    

### Complexity Analysis ###

# Time Complexity: O(N x Exponential) --> Since we are doing exhaustive search covering every possiblity x Checking if it is a valid palindrome for every substring
# Space Complexity: O(N+N) --> Recursive stack space + path array