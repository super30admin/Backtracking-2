class Solution:
    result = ""
    def partition(self, s: str) -> List[List[str]]:

        self.result = []

        self.helper(s,0,[])

        return self.result


    def helper(self,s, i, path):

        #Base Case

        if i == len(s):
            self.result.append(list(path))
            return
        
        for index in range(i,len(s)):
            if self.isPalindrome(s[i:index+1]):
                path.append(s[i:index+1])
                print(path)
                self.helper(s , index + 1 , path  )

                #backtrack

                path.pop(len(path) - 1)


    def isPalindrome(self,s):
        reversed_str = ''.join(reversed(s))
        if s == reversed_str:
            return True
        else:
            return False
