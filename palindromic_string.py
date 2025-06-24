###
# Approach:
# Use backtracking to explore all possible partitions of the input string.
# At each step, we check if the substring `s[idx:i]` is a palindrome.
# If it is, we include it in the current path and recursively explore the remaining substring.
# If we reach the end of the string, we add the current path to the result list.
#
# Time Complexity: O(2^n * n)
# - 2^n for all possible partitions (at most exponential)
# - n for slicing and palindrome check per partition
#
# Space Complexity: O(n) for recursion stack + O(n) for path list (at max depth)
###

class Solution:
    def partition(self, s):
        res = []
        def isPalindrome(strs):
            return strs == strs[::-1]
        
        def helper(idx, path):
            if idx == len(s):
                res.append(path[:])
                return
            for i in range(idx+1, len(s)+1):
                if isPalindrome(s[idx: i]):
                    path.append(s[idx:i])
                    helper(i, path)
                    path.pop()
        helper(0, [])
        return res
    
    def main(self):
        print("Partitions for 'aab':", self.partition("aab"))  # [["a","a","b"],["aa","b"]]
        print("Partitions for 'a':", self.partition("a"))       # [["a"]]
        print("Partitions for 'abba':", self.partition("abba")) # [["a","b","b","a"],["a","bb","a"],["abba"]]

# Run
sol = Solution()
sol.main()










