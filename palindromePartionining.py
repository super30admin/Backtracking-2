#Time Complexity : O(2^n)
#Space Complexity : O(n)
#Did this code successfully run on Leetcode : Yes
#Three line explanation of solution in plain english: Using backtracking, keeping a temp array and an index (which is the beginning index of each substring we want to consider), we append the curr substring (which is from the index to the ith index in the original string) in the temp array if it is a palindrome and at the beginning of every recursive call we append a copy of temp array to the resulting array if the index is equal to the len of the original string. Each time on calling the backtracking we make the index equal to i+1 (where i is the index in the for loop).

class Solution:
    def isPalindrome(self, subStr, l, h):
        while l < h:
            if subStr[l] != subStr[h]:
                return False
            l += 1
            h -= 1
        return True

    def helper(self, s, curr, index):
        if index == len(s):
            self.result.append(copy.deepcopy(curr))

        for i in range(index, len(s)):
            if self.isPalindrome(s, index, i):
                curr.append(s[index:i+1])
                self.helper(s, curr, i+1)
                curr.pop()


    def partition(self, s: str) -> List[List[str]]:
        self.result = []
        self.helper(s, [], 0)
        return self.result

    #RECURSION
    # def isPalindrome(self, subStr, l, h):
    #     while l < h:
    #         if subStr[l] != subStr[h]:
    #             return False
    #         l += 1
    #         h -= 1
    #     return True
    #
    # def helper(self, s, curr, index):
    #     if index == len(s):
    #         self.result.append(copy.deepcopy(curr))
    #
    #     for i in range(index, len(s)):
    #         if self.isPalindrome(s, index, i):
    #             self.helper(s, curr+[s[index:i+1]], i+1)
    #
    #
    # def partition(self, s: str) -> List[List[str]]:
    #     self.result = []
    #     self.helper(s, [], 0)
    #     return self.result
