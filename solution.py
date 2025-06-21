## Problem1 0/1 recursion

class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        self.res = []

        def dfs(i,path):

            if i == len(nums):
                self.res.append(path)
                return

            dfs(i+1,path+[nums[i]])
            dfs(i+1,path)
        dfs(0,[])
        return self.res

##problem 1  for loop based recursion 

class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        self.res = []

        def dfs(i,path):
            
            self.res.append(path)

            if i == len(nums):
                return 
            
                

            for j in range(i,len(nums)):

                dfs(j+1,path+[nums[j]])
           
        dfs(0,[])
        return self.res

#problem 2 palindrome partitioning 

class Solution:
    def partition(self, s: str) -> List[List[str]]:

        self.res = []

        def is_palindrome(sub):
            return sub == sub[::-1]

        def dfs(start,path):
            if start == len(s):
                self.res.append(path)

            for end in range(start, len(s)):
          
                if is_palindrome(s[start:(end+1)]):
                    dfs(end+1, path + [s[start:(end+1)]])

        dfs(0, [])
        return self.res



        