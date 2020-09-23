class Solution(object):
    def partition(self, s):
        """
        :type s: str
        :rtype: List[List[str]]
        """
        output = []
        path = []
        
        self.backtracking(output, s, 0, path)
        return output
        
    
    def backtracking(self, output, s, index, path):
        # base case
        if index >= len(s):
            output.append(deepcopy(path))
            return
        
        # recursive case
        for i in range(index, len(s)):
            temp = s[index:i+1]
            if self.isPalindrome(temp):
                path.append(temp)
                self.backtracking(output, s, i + 1, path)
                path.pop()
        
        
    def isPalindrome(self, string):
        left = 0
        right = len(string) - 1
        
        while(left < right):
            if string[left] is not string[right]:
                return False
            left += 1
            right -= 1
        return True
