# TC: O(n*2^n)
# SC: O(n)
class Solution:
    def partition(self, s: str) -> List[List[str]]:
        res=[]
        def isPalindrome(s: str) -> bool:
            l=0
            r=len(s)-1
            while l<=r:
                if s[l]!=s[r]:
                    return False
                l+=1
                r-=1
            return True

        def helper(s, pivot, path, res):
            #base
            if pivot==len(s):
                res.append(path.copy())
                return
            #logic
            for i in range(pivot,len(s)):
                #action
                curr_str=s[pivot:i+1]
                if isPalindrome(curr_str):
                    path.append(curr_str)
                    #recurse
                    helper(s,i+1,path,res)
                    #backtrack
                    path.pop()
            
        helper(s,0,[],res)
        return res