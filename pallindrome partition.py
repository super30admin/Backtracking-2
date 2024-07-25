#// Time Complexity : Exponential
# // Space Complexity : O(n) 
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this : no because i saw the class video and then did the problem.
class Solution:
    def partition(self, s: str) -> List[List[str]]:
        def ispallindrome(arr):
            p1 = 0
            p2 = len(arr)-1
            while p1 < p2:
                if arr[p1] == arr[p2]:
                    p1+= 1
                    p2-= 1
                else:
                    return False
            return True

        result = []
        def helper(s,pivot,path):
            nonlocal result
            if pivot == len(s):
                result.append(deepcopy(path))
                return 

            for i in range(pivot,len(s)):
                sub = s[pivot:i+1]
                if ispallindrome(sub):
                    path.append(sub)
                    helper(s,i+1,path)
                    path.pop()
        helper(s,0,[])
        return result

# Approach:
# 1. We will use a helper function to solve this problem. The helper function will take 3
# parameters: s, pivot, path. The pivot will be the starting index of the string and
# path will be the list of strings that we will be appending to the result list.
# 2. We will iterate through the string and check if the substring starting from the pivot
# index is a palindrome or not. If it is a palindrome, we will append it to the path
# list and call the helper function recursively with the updated pivot index and path.
# 3. After the recursion is done, we will pop the last element from the path list and
# return the result list.
        