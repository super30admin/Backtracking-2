class Solution(object):
    # T.C is O(2 pow(n))
    # S.C is O(length of string)
    # All cases passed in leetcode
    def partition(self, s):
        """
        :type s: str
        :rtype: List[List[str]]
        """
        self.result = []
        self.helper(s, 0, [])
        return self.result

    def helper(self, s, index, path):
        if index == len(s):
            temp_list = list(path)
            self.result.append(temp_list)

        for i in range(index, len(s)):
            # print(index, i)
            curr_par = s[index: i + 1]
            if self.ispalindrome(curr_par):
                path.append(curr_par)
                self.helper(s, i + 1, path)
                path.pop()

    def ispalindrome(self, curr_path):
        start = 0
        end = len(curr_path) - 1

        while start < end:
            if curr_path[start] != curr_path[end]:
                return False
            start += 1
            end -= 1
        return True


class Solution(object):
    def partition(self, s):
        """
        :type s: str
        :rtype: List[List[str]]
        """
        self.result = []
        rows, cols = (len(s), len(s))
        self.dp = [[0 for i in range(cols)] for j in range(rows)]
        for i in range(len(s)):
            for start in range(len(s)):
                if start + i < len(s):
                    end = start + i
                    self.dp[start][end] = (s[start] == s[end]) and self.ispalindrome(s, start + 1, end - 1)

        self.helper(s, 0, [])
        return self.result

    def helper(self, s, index, path):
        if index == len(s):
            temp_list = list(path)
            self.result.append(temp_list)

        for i in range(index, len(s)):
            # print(index, i)
            curr_par = s[index: i + 1]
            if self.ispalindrome(s, index, i):
                path.append(curr_par)
                self.helper(s, i + 1, path)
                path.pop()

    def ispalindrome(self, curr_path):
        start = 0
        end = len(curr_path) - 1

        while start < end:
            if curr_path[start] != curr_path[end]:
                return False
            start += 1
            end -= 1
        return True

    def ispalindrome(self, s, start, end):
        if start > end:
            return True
        return self.dp[start][end]

