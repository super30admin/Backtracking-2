#TC-O(n*2**n)-n for checking palindrome and 2**n for recursion
#SC-O(n)
#logic-loop through the string s, by keeping two pointers idx fixed and i from idx to end
#check if substring from idx to i is palindrome and add to path, recurse by taking idx as i+1
class Solution:
    def partition(self, s: str) -> List[List[str]]:
        result=[]
        def ispalin(sc):
            l=0
            r=len(sc)-1
            while l<=r:
                if sc[l]!=sc[r]:
                    return False
                l+=1
                r-=1
            return True
        def helper(s,idx,path):
            if idx==len(s):
                p=path.copy()
                result.append(p)
                return
            for i in range(idx,len(s)):
                sc = s[idx:i+1]
                if ispalin(sc):
                    path.append(sc)
                    helper(s,i+1,path)
                    path.pop(-1)
        helper(s,0,[])
        return result
        