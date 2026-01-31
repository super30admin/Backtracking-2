#Problem1 Subsets (https://leetcode.com/problems/subsets/)
# Time Complexity : O(N 2^N)
# Space Complexity : O(N 2^N)



class Solution(object):
    def subsets(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        
        def __helper(pivot,res,path):
            res.append(path[:]) ## append deep copy

            for i in range(pivot,len(nums)):
                ## choose
                path.append(nums[i])
                ## recurse
                __helper(i+1,res,path)
                ## no choose
                path.pop()

        res = []
        path = []
        __helper(0,res,path)
        return res


#Problem2 Palindrome Partitioning(https://leetcode.com/problems/palindrome-partitioning/)
# Time Complexity : O(N 2^N)
# Space Complexity : O(N 2^N)

class Solution(object):
    def partition(self, s):

    
        # Backtracking approach:
        # - Try every possible substring starting from current index (pivot)
        # - If the substring is a palindrome, choose it, recurse for the rest
        # - Backtrack and explore other options
        def isPalindrome(sub):
            """Check if a substring is a palindrome."""
            return sub == sub[::-1]

        def __helper(s, pivot, path, result):
        
            # Base case: reached end of string
            if pivot == len(s):
                result.append(path[:])  # make a copy of path
                return
            
            # Try all possible substrings starting at pivot
            for end in range(pivot, len(s)):
                sub = s[pivot:end+1]  # substring s[pivot:end]
                if isPalindrome(sub):
                    path.append(sub)            # choose
                    __helper(s, end+1, path, result)  # recurse
                    path.pop()                  # backtrack

        result = []
        path = []
        __helper(s, 0, path, result)
        return result
