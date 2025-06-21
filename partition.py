# // Time Complexity :O(L^n)
# // Space Complexity :O(L)
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no


# // Your code here along with comments explaining your approach
# we do for loop b ased recuriosn we have piviot (we will ocnsider this as atrting point ) addn try to break down next subtring into palindromes





class Solution:
    def partition(self, s: str) -> List[List[str]]:
        ans=[]
        n=len(s)
        def helper(s,n,idx,path):
            #base
            if idx==n:
                ans.append([val for val in path])


            #logic
            for i in range(idx,n):
                currStr=s[idx:i+1]
                if currStr==currStr[::-1]:
                    path.append(currStr)
                    helper(s,n,i+1,path)
                    path.pop()
        helper(s,n,0,[])
        return ans
