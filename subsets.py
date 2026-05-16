
# for loop based recursion
class Solution:
    def partition(self, s: str) -> List[List[str]]:
        self.result = []

        def helper(s,pivot,path):
            if pivot == len(s):
                self.result.append(list(path))
                return

            for i in range(pivot,len(s)):
                # we keep track of substring between pivot and i
                # whereas 0,1 recursion (without pivot) - for this problem we need 2 indices - so use for loop based recursion
                subStr = s[pivot:i+1]
                if isPalindrome(subStr):
                    # action 
                    path.append(subStr)
                    # recurse
                    helper(s,i+1,path)
                    # backtrack
                    path.pop()

        def isPalindrome(s):
            i = 0
            j = len(s)-1
            while i <= j:
                if s[i] != s[j]:
                    return False 
                i+=1
                j-=1
            return True
        
        helper(s,0,[])
        return self.result