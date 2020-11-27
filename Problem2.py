# Time Complexity : O(N * 2^N) (Because we have 2^N partition and for every partition checking if it is palindrom or not is O(N) complexity.) 
# Space Complexity : O(2^N) 
# Did this code successfully run on Leetcode : Yes
# Three line explanation of solution in plain english:
# - Use backtack solve the probelm
# - Check every substring using backtrack and check if taht substring is palindrome or not.
# - If it is palindrom than continue backtarck for next palindrom substring.

class Solution:
    def partition(self, s: str) -> List[List[str]]:
        answer = []
#       Initializing ans and calling backtarck function with empty list for tempList and 0 as start.
        self.backtrack(s, len(s), answer, [], 0)
        return answer
    
    def backtrack(self, s, lengthS, answer, tempList, start):
#         If start reach end that means we found partition till last element, so append templist in the answer
        if start == lengthS:
            answer.append(tempList)
        else:
#           Else run for loop for start to end of list
            for i in range(start, lengthS):
#               Check if partition is palindrom or not
                if self.isPalindrome(s, start, i):
#                   If partition is palindrom append it to the templist and find next palindrom partition by calling backtrack function.
                    self.backtrack(s, lengthS, answer, tempList + [s[start:i+1]], i+1)
                
#   Function to check if string range is palindrom or not
    def isPalindrome(self, s, start, end):
#       Run while loop until start and end does not cross.
        while(start < end):
#           If start and end character are same shrink both ends and check again
            if s[start] == s[end]:
                start += 1
                end -= 1
#           If start and end character are not equal that means it is not palindrom.
            else:
                return False
#       If nothing returns false till end that means string is palindrom, so return true.
        return True
        
