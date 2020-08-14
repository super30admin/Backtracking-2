# APPROACH  1: BACTRACKING
# Time Complexity : O(n * 2^n), n: len(s)
# Space Complexity : O(n * 2^n), in worst case, its a palindrome at every node, we keep appending the string to the current list
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : None
#
#
# Your code here along with comments explaining your approach
# 1. Consider partitioning at every ind, from there try partitioning at every ind till end of string is reached
# 2. proceed further only if the current substing is a palindrome, else add the current list to the result

class Solution:
    def __init__(self):
        self.result = []
        
    def partition(self, s: str) -> List[List[str]]:
        if s is None:
            return None
        self.backtrack(s, [], 0)
        return self.result
        
    def backtrack(self, s, curr_list, partition_ind):
        
        # base
        if partition_ind >= len(s):
            self.result.append(copy.deepcopy(curr_list))
            return
        
        # logic
        for ind in range(partition_ind, len(s)):
            if self.isPalindrome(s, partition_ind, ind):
                # action
                curr_list.append(s[partition_ind : ind + 1])
                
                # recurse
                self.backtrack(s, curr_list, ind + 1)
                
                # backtrack
                curr_list.pop()
                
        
    def isPalindrome(self, s, start, end):
        if start == end:
            return True
        
        while start < end:
            if s[start] != s[end]:
                return False
            start += 1
            end -= 1
            
        return True
       
        

# APPROACH 2: RECURSION
# Time Complexity : O(n * 2^n), n: len(s)
# Space Complexity : O(n * 2^n), in worst case, its a palindrome at every node, we keep appending the string to the current list
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : None
#
#
# Your code here along with comments explaining your approach
# 1. Same as APPROACH 1, but at every node we are creating a new list


class Solution:
    def __init__(self):
        self.result = []
        
    def partition(self, s: str) -> List[List[str]]:
        if s is None:
            return None
        
        self.helper(s, [], 0)
        return self.result
    
    
    def helper(self, s, curr_list, index):
        if index >= len(s):
            print(curr_list)
            self.result.append(curr_list)
            
        for ind in range(index, len(s)):
            if self.isPalindrome(s, index, ind):
                copy_list = copy.deepcopy(curr_list)
                copy_list.append(s[index : ind + 1])
                self.helper(s, copy_list, ind + 1)
    
    
    def isPalindrome(self, s, start, end):
        if start == end:
            return True
        
        while start < end:
            if s[start] != s[end]:
                return False
            start += 1
            end -= 1
            
        return True
