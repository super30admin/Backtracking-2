# Time Complexity :O(n*2^n) where n is number of candidates
# Space Complexity : O(n) single temp list
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no


class Solution:
    def partition(self, s: str) -> List[List[str]]:

        self.result = []

        if s == None:
            return self.result
        self.backtrack(s, [], 0)
        return self.result

    def backtrack(self, s, temp, index):
        if index == len(s):
            # print('resssssssssssss=')
            self.result.append(list(temp))

        for i in range(index, len(s)):
            # print('index=',index)
            # print('i=',i)

            if self.isPalindrome(s, index, i):
                # print('resssssssssssss=')
                # add from start that is index to i (may i change every for loop)
                temp.append(s[index:i+1])
                # print('temp=',temp)
                self.backtrack(s, temp, i+1)
                # print('------------------------------------------------------')
                # print('tempbbbbbbbbbbb=',temp)
                # after index reaching the end of s, we pop last element
                # print('indexbbbbbbbbbbbbbbbbbbbb=',index)
                # print('i=',i)
                temp.pop()
                # print('done            opop')

    def isPalindrome(self, s, left, right):
        if left == right:
            return True
        while left < right:
            if s[left] != s[right]:
                return False
            left += 1
            right -= 1

        return True
