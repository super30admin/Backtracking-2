#Leetcode 131: Palindrome Partitioning
# Time - exponential
# Space - O(n)
class Solution:
    def partition(self, s: str) -> List[List[str]]:
        
        result = []
        
        def isPalindrome(string):
            
            left = 0
            right = len(string) - 1
            
            while(left < right):
                
                if string[left] != string[right]:
                    return False
                
                left = left + 1
                right = right - 1
            
            return True    
                
        def helper(s, index, path):
            
            if index == len(s):
                
                result.append(path.copy())
                
                return
            
            for i in range(index, len(s)):
                
                currString = s[index: i + 1]
                # print(currString, "-->")
                if(isPalindrome(currString)):
                    path.append(currString)
                    helper(s, i + 1, path)
                    path.pop()