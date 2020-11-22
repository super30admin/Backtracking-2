class Solution:
    def partition(self, s: str) -> List[List[str]]:


        def isPalindrome(s,i,j):
            sub = s[i:j+1]
            return sub == sub[::-1]

        def backtrack(s,index,temp):

            #base
            if index==len(s):
                res.append(copy.deepcopy(temp))
                return
            for i in range(index,len(s)):
                if isPalindrome(s,index,i):
                    temp.append(s[index:i+1])
                    backtrack(s,i+1,copy.deepcopy(temp))
                    temp.pop()



        if s is None or len(s)==0:
            return []
        res =[]
        backtrack(s,0,[])
        return res
