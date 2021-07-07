# Time Complexity : Exponential
# Space Complexity : Recursive Stack O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : -

class Solution(object):
    def partition(self, s):
        """
        :type s: str
        :rtype: List[List[str]]
        """
        self.result = []
        self.helper(s, 0, [])
        return self.result
    
    def helper(self, s, index, tempList):
        # Base Case
        if index == len(s):
            self.result.append(tempList[:])
            return
        
        # Logic
        for i in range(index, len(s)):
            if self.isPalindrome(s[index:i+1]):
                # print(index, i)
                # print(s[index:i])
                tempList.append(s[index:i+1])
                self.helper(s, i+1, tempList)
                tempList.pop()
                
    def isPalindrome(self, string):
        # if start == end: return True
        # else:
        #     while start<end:
        #         if string[start] != string[end]:
        #             return False
        #         else:
        #             start += 1
        #             end -= 1
        # return True
        # print(string[start:end])
        # print(string[start:end][::-1])
        return string == string[::-1]
                