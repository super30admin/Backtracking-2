#TC: O(l * (2^l))
#SC: O(n)
class Solution:
    def partition(self, s: str) -> List[List[str]]:
        
        def backtrack(st):
            nonlocal s,parts,ans
            if st==len(s):
                ans.append(parts[:])

            for i in range(st,len(s)):
                cur=s[st:i+1]
                if cur != cur[::-1]: continue
                parts.append(cur)
                backtrack(i+1)
                parts.pop()

        ans=[]
        parts=[]
        backtrack(0)
        return ans