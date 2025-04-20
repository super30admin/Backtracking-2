'''

Super tricky, I still didn't understand for loop recursion completely yet.

Have to rinse the recorded videos a little more.

Just sort of did this problem, by referring the solution from the class.

TC: O(2^n) *O(n)
SC: O(n)

Also got confused with TC, so referred open PR's and got the TC, dont give me plag:)
'''

import copy
class Solution:

    def __init__(self):
        self.res=[]
    def partition(self, s: str) -> List[List[str]]:

        self.helper(s, 0, [])

        return self.res

    def helper(self, s, pivot, path):

        # base case
        if(pivot==len(s)):
            self.res.append(copy.deepcopy(path))


        for i in range(pivot, len(s)):
            sub_str = s[pivot:i+1]
            if(self.is_palindrome(sub_str)):
                # action
                path.append(sub_str)

                # recursion
                self.helper(s,i+1, path)

                # backtracking
                path.pop()


    def is_palindrome(self,str_check):

        start = 0
        end = len(str_check)-1

        while(start<end):
            if(str_check[start]!=str_check[end]):
                return False
            start+=1
            end-=1

        return True
