# 131. Palindrome Partitioning

'''
Leetcode all test cases passed: Yes
Solution:
     def partition(self, s: str) -> List[List[str]]:
        n is the length of s
        h is height of tree
        Time Complexity: O(2 ^ n) 
        Space Complexity: O(h)
'''
class Solution:
    def helper(self,s,pivot,path):
        if pivot == len(s):
            self.result.append(path[:])
            
        for i in range(pivot,len(s)):
            subset = s[pivot : i + 1]
            if subset == subset[::-1]:
                path.append(subset)
                self.helper(s,i + 1,path)
                path.pop()
                
    def partition(self, s: str) -> List[List[str]]:
        self.result = []
        self.helper(s,0,[])
        return self.result
