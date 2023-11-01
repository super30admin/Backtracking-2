# // Time Complexity :O(n2^n)
# // Space Complexity :O(n)
# // Did this code successfully run on Leetcode :Yes
# // Any problem you faced while coding this :No

# we used for loop based rcursion and go over each element, when we go over each element we add it ot he path and see if its a palindrome.
# if its a plaindrome we recursively cehck for the rest of the string
# if its not palindrome we dont go down that path
#  we did 01 based recursion as well
class Solution(object):
    def partition(self, s):
        """
        :type s: str
        :rtype: List[List[str]]
        """
        # O(n.2^n)
        def palindrome(s):
            start=0
            end=len(s)-1
            while(start<end):
                if(s[start]!=s[end]):
                    return False
                start+=1
                end-=1
            return True
        def helper(s, pivot, path):
            # base
            if(pivot==len(s)):
                res.append(list(path))
                return 
            # logic
            for i in range(pivot, len(s)):
                subs=s[pivot:i+1]
                if(palindrome(subs)):
                    # action
                    path.append(subs)
                    # recurse
                    helper(s,i+1,path)
                    # backtrack
                    path.pop()

        res=[]
        helper(s,0,[])
        return res

         # 01 based recursion
        # def helper(s,pivot,i,path):
        #     # base
        #     if(i==len(s)):
        #         if(pivot==len(s)):
        #             res.append(list(path))
        #         return
        #     # logic
        #     # dont choose
        #     helper(s,pivot,i+1,path)
        #     # choose
        #     subs=s[pivot:i+1]
        #     # action
        #     if(palindrome(subs)):
        #         path.append(subs)
        #         # recurse
        #         helper(s,i+1, i+1, path)
        #         # backtrack
        #         path.pop()
        # res=[]
        # helper(s,0,0,[])
        # return res