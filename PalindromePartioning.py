class Solution:
    def partition(self, s: str) -> List[List[str]]:


         #for loop recurrsion
        #Time complexity - O((N+N)*2^N) where N-length of s. We use N to create substring and to check if its palindrome
        #Space complexity - O(N) - max stack size is length of s
        if not s:
            return []

        res = []

        def helper(s, path, pivot):
            if pivot==len(s):
                res.append(path.copy())
                return

            for i in range(pivot, len(s)):
                sub = s[pivot:i+1]
                if self.isPalindrome(sub):
                    path.append(sub)
                    print(path, [pivot], [i])
                    helper(s, path, i+1)
                    path.pop()

        helper(s, [], 0)
        return res
        

#-----------------------------OR-------------------------------


    def isPalindrome(self, sub):
        i=0
        j=len(sub)-1
        while i<=j:
            if sub[i]!=sub[j]:
                return False
            i+=1
            j-=1
        
        return True

        #for loop recurrsion without pivot 
        if not s:
            return []

        res = []

        def helper(s, path):
            if len(s)==0:
                res.append(path.copy())
                return

            for i in range(len(s)):
                sub = s[:i+1]
                if self.isPalindrome(sub):
                    path.append(sub)
                    helper(s[i+1:], path)
                    path.pop()

        helper(s, [])
        return res


       