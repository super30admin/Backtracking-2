class Solution(object):
    def subsets(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        time: O(n*2^n)
        space: O(n)
        """
        res = []
        def helper_for(offset, so_far=[]):
            res.append(so_far[:])
            
            for i in range(offset, len(nums)):
                so_far.append(nums[i])
                helper(i+1, so_far)
                so_far.pop()
        
        def helper(idx, so_far=[]):
            if idx == len(nums):
                res.append(so_far[:])
                return            
            
            helper(idx+1, so_far)
            so_far.append(nums[idx])
            helper(idx+1, so_far)
            so_far.pop()

        helper(0, [])
        return res

    def partition(self, s):
        """
        :type s: str
        :rtype: List[List[str]]
        aaba
        time: O(n*2^n)
        space: O(n)
        """
        def is_palindrome(s):
            i, j = 0, len(s)-1
            while i < j:
                if s[i] != s[j]:
                    return False
                i, j = i+1, j-1
            return True
        res = []
        def helper_for(idx=0, res_so_far=[]):
            if idx == len(s):
                res.append(res_so_far[:])
                return
            for i in range(idx, len(s)):
                prefix = s[idx:i+1]
                if is_palindrome(prefix):
                    res_so_far.append(prefix)
                    helper_for(i+1, res_so_far)
                    res_so_far.pop()
        
        def helper(start=0, i=0, cnt=0, res_so_far=[]):
            if i == len(s):
                if cnt == len(s):
                    res.append(res_so_far[:])
                return
            helper(start, i+1, cnt, res_so_far)
            if is_palindrome(s[start: i+1]):
                res_so_far.append(s[start: i+1])               
                helper(i+1, i+1, cnt+i-start+1, res_so_far)
                res_so_far.pop()

        helper()
        return res