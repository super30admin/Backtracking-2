'''
Solution
1.  Using Backtracking, we check whether the substring considered is palindrome or not.
2.  If palindrome, we check the remaining possible substrings
3.  If not palindrome, we backtrack to the previous state and check for other possible substrings from that state.

Time Complexity:    O(n * 2^n)
Space Complexity:   O(n)

--- Passed all testcases on Leetcode successfully

'''


class PalindromePartitioning(object):

    def __init__(self):
        self.finalList = []
        self.tempList = []

    def __isPalindrome(self, s, fromId, toId):

        #   check for palindrome using 2 pointers
        if (toId >= len(s)):
            return False

        while (fromId <= toId):
            if (s[fromId] != s[toId]):
                return False
            fromId += 1; toId -= 1

        return True

    def __backtracking(self, s, fromIndex):

        #   base case
        if (fromIndex == len(s)):
            self.finalList.append(list(self.tempList))
            return

        #   from current index to total length
        for toIndex in range(fromIndex, len(s)):

            #   only if palindrome, do the following
            if self.__isPalindrome(s, fromIndex, toIndex):

                #   action -- appending the current substring to the list
                self.tempList.append(s[fromIndex: toIndex + 1])

                #   recursion -- just to check whether the partition can be valid or not
                self.__backtracking(s, toIndex + 1)

                #   backtrack -- removing the current substring from the list
                self.tempList.pop()

    def partition(self, s):
        """
        :type s: str
        :rtype: List[List[str]]
        """
        #   edge case check
        if (s == None or len(s) == 0):
            return self.finalList

        #   main call to the helper function
        self.__backtracking(s, 0)

        #   return the final list
        return self.finalList