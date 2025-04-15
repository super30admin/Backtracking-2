#Time Complexity : Each character can either start a new partition or be included in the current one. So in the worst case, the number of ways to partition the string is exponential → O(2ⁿ). O(2ⁿ * n)
#Space Complexity : O(2ⁿ * n)
class Solution:
    def partition(self, s: str) -> List[List[str]]:
        result = []
        def dfs(i,part):
            if(i>=len(s)):
               result.append(part.copy())
               return
            for j in range(i,len(s)):
                if(self.ispalindrome(s,i,j)):
                    part.append(s[i:j+1])
                    dfs(j+1,part)
                    part.pop()
        dfs(0,[])
        return result
    def ispalindrome(self, s, l, r):
        while(l<r):
            if(s[l]!=s[r]):
                return False
            else:
                l = l+1
                r = r-1
        return True 

        