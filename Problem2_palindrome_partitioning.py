class Solution(object):
    def partition(self, s):
        """
        Time Complexity: O(N * 2^N) where N is the length of the string s.
        Space Complexity: O(N) for the recursion stack and path storage.
        :type s: str
        :rtype: List[List[str]]
        """
        res = []

        def isPalindrome(substr):
            return substr==substr[::-1]

        def backtrack(start, path):
            #base case
            if start==len(s):
                res.append(path[:])
                return

            #logic
            for i in range(start+1, len(s)+1):
                substr = s[start:i]
                if isPalindrome(substr):
                    path.append(substr)
                    backtrack(i, path)
                    path.pop()
        
        backtrack(0, [])
        return res