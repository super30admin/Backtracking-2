'''
Solution : FOR loop based DFS with backtracking
    - At each character in the string, we either partition at that character or not
    - If this partitioned string is valid palindrome than we recurse to the next step
      which is partitioning the rest of the string. 
    - If we end up reaching end of string in the recursive call, then we have a valid
      palindrome partitioning.
Time Complexity: O(N*2^N), where N = length of string. 
                 - At each character, we have choose/Not choose to partition.
                 - for partitioned, we do palindrome check. 
Space Complexity: O(N), depth of recursive stack. 
'''

class Solution:
    def partition(self, s: str) -> List[List[str]]:
        validPalindromePartitions  = [] # to store the answers

        self.helper(s,0,[],validPalindromePartitions) # string, pivot, path, answer_list

        return validPalindromePartitions
    
    def helper(self,s,pivot_index,path,validPalindromePartitions):
        # base
        if pivot_index==len(s): # new valid partitioned path found  
            validPalindromePartitions.append(deepcopy(path))
            return 

        # logic
        for i in range(pivot_index,len(s)):
            partitioned_string = s[pivot_index:i+1] # partition string
            if self.isPalindrome(partitioned_string): # check if pallindrome
                path.append(partitioned_string) # action
                self.helper(s,i+1,path,validPalindromePartitions)
                path.pop() # backtrack
    
    def isPalindrome(self,string):
        left = 0
        right = len(string)-1

        while left<right:
            if string[left]!=string[right]: # palindrome breach
                return False
            left+=1
            right-=1
        
        return True