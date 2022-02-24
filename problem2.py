# Time complexity: Exponential = n2^n
# Space complexity: O(n)

class Solution:
    def partition(self, s: str) -> List[List[str]]:
        self.result = []

        if s is None or len(s) == 0:
            return self.result
        path = []

        self.helper(s,0,path)
        return self.result

    def helper(self, s,index,path):
        # base case
        if index == len(s):
            self.result.append(path.copy())

        # logic
        for i in range(index, len(s)):
            subStr = s[index:i+1]
            boolean = self.palindrome(subStr)
            if boolean:
                path.append(subStr)
                self.helper(s, i + 1 ,path)
                path.pop()


    def palindrome(self,s):
        i = 0
        j = len(s)-1

        while  i <= j and s[i] == s[j]:
            i += 1
            j -= 1

        return i >= j
