#for loop recursion
class Solution:
    def partition(self, s: str) -> List[List[str]]:
        if not s:
            return []
        res=[]
        def isPali(spali):
            l,r=0,len(spali)-1
            while l<r:
                if spali[l]!=spali[r]:
                    return False
                l+=1
                r-=1
            return True
        def recurse(ind,subs):
            #base
            if ind==len(s):
                res.append(subs)
                return
            #logic
            for i in range(ind,len(s)):
                if isPali(s[ind:i+1]):
                    nsubs=subs[:]
                    nsubs.append(s[ind:i+1])
                    recurse(i+1,nsubs)

        recurse(0,[])
        return res
        