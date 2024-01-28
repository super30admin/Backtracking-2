class Solution:
    def partition(self, s: str) -> List[List[str]]:

        res = []
        subString = []

        #valid or not
        def dfs(i):

            #base case
            if i >= len(s):
                res.append(subString.copy())
            
            #for loop recursion
            for j in range(i, len(s)):
                #starting from index 0 and 0+1, 0 = pivot
                if self.isPalindrome(s,i,j):
                    #Adding valid palindrome subString into the subString and then partiioning the subString for further palindrome strings
                    subString.append(s[i:j+1])
                    #Recursively calling palindrome function on subString of valid sub palindrome string obtained during initial call.
                    dfs(j + 1)

                    #if subString is not valid palindrome, removing the element and moving index + 1 
                    subString.pop()

        dfs(0)
        return res

    #Helper function to check if it is Palindrome
    def isPalindrome(self, s, start, end):

        #checking the character from start and End
        while start < end:
            if s[start] != s[end]:
                return False
            start += 1
            end -= 1
        return True


