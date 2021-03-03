"""
131. Palindrome Partitioning
Time Complexity - O(3**n) as in backtracking we are performing 2**n operations and for those 2**n operation performing pallingdrome each time
Space Complexity - O(n) n is max values in path
Passing string,emplty output list ,and initial index = 0 to backtracking
In backtracking 
base case is if index >= len(string) append to output and return
for loop that varies from index to len(string)
in curr store value from index to i
check from pallingdrome function if valid if Yes,
then append curr to path and again call backtracking with index+1 and new path
pop last element from path and continue for loop"""
class Solution:
    
    def partition(self, s: str) -> List[List[str]]:
        output = []
        self.backtracking(s,0,"",[],output)
        return output
    
    def backtracking(self,s,index,current,path,output):
        if index >= len(s):
            output.append(path[:])
            return
        for i in range(index,len(s)):
            current = s[index:i+1]
            if self.pallingdrome(current):
                path.append(current)
                self.backtracking(s,i+1,current,path,output)
                path.pop()
                
    def pallingdrome(self,current):
        left = 0
        right = len(current)-1
        while(left < right):
            if (current[left] != current[right]):
                return False
            left += 1
            right -= 1
        return True
                