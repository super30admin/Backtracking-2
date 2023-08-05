# TC - O(n*2^n), we have 2 options for n elements and then n from the i=pivot to n for loop.
# SC - O(n)

#Here, 1st create a substirng from pivot to i. Check if this is palindrome, if it is, then move pivot and i to element after substring and recurse again. 

class Solution:
    def partition(self, s: str) -> List[List[str]]:
        res=[]

        def ispalindrome(st):
            l = 0; r = len(st) - 1
            while l < r:
                if st[l] != st[r]:
                    return False
                l+=1
                r-=1
            return True

        def helper(s,pivot,path):
            #base
            if pivot==len(s):
                res.append(copy.deepcopy(path))
                return 
            
            #logic
            for i in range(pivot,len(s)):
                sub=s[pivot:i+1]
                if ispalindrome(sub):
                    #action
                    path.append(sub)
                    #recurse
                    helper(s,i+1,path)
                    #backtrack
                    path.pop()
        helper(s,0,[])
        return res
            

