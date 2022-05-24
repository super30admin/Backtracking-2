# Time Complexity - O(N * 2^N)
# Space Complexity - O(N)
class Solution(object):
    def partition(self, s):
        """
        :type s: str
        :rtype: List[List[str]]
        """
        size = len(s)
        result = []

        def isPalindrome(string):
            r = len(string) - 1
            l = 0
            while(l <= r):
                if string[l] != string[r]:
                    return False
                l += 1
                r -= 1
            return True

        def getAllPalindromes(s, index, path):
            if index == size:
                result.append(path[:])
                return

            for i in range(index, size):
                string = s[index:i+1]
                if(isPalindrome(string)):
                    path.append(string)
                    getAllPalindromes(s, i + 1, path)
                    path.pop()

        getAllPalindromes(s, 0, [])
        return result
