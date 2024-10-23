# T.C = O(n2^n) S.C = O(n2^n)
class Solution(object):
    def partition(self, s):
        """
        :type s: str
        :rtype: List[List[str]]
        """
        self.result = []
        self.helper(s,0,[])
        return self.result

    def helper(self,s,pivot,path):

        if(pivot == len(s)):
            self.result.append(copy.deepcopy(path))

        for i in range(pivot,len(s)):
            sub = s[pivot:i+1]
            if(self.isPalindrome(sub)):
                path.append(sub)
                self.helper(s,i+1,path)
                path.pop(len(path)-1)

    def isPalindrome(self,s):
        l = 0 
        r = len(s) - 1

        while(l<r):
            if(s[l] != s[r]):
                return False
            l+=1
            r-=1

        return True

        