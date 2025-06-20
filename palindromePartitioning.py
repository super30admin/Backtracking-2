class Solution:
    def partition(self,s):
        result=[]
        
        def isPalindrome(sub):
            return sub == sub[::-1]
        
        def backtrack(start,path):
            if start == len(s):
                result.append(path[:])
                return
            for end in range(start+1,len(s)+1):
                prefix=s[start:end]
                if isPalindrome(prefix):
                    path.append(prefix)
                    backtrack(end,path)
                    path.pop()
        
        backtrack(0,[])
        return result
    
if __name__=="__main__":
    sol=Solution()
    print(sol.partition("aab"))
    print(sol.partition("a"))