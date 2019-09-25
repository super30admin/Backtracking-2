"""
The program flow is as follows - 
append - [[]]
append - [[], [1]]
append - [[], [1], [1, 2]]
append - [[], [1], [1, 2], [1, 2, 3]]
pop - 3
pop - 2
append - [[], [1], [1, 2], [1, 2, 3], [1, 3]]
pop - 3
pop - 1
append - [[], [1], [1, 2], [1, 2, 3], [1, 3], [2]]
append - [[], [1], [1, 2], [1, 2, 3], [1, 3], [2], [2, 3]]
pop - 3
pop - 2
append - [[], [1], [1, 2], [1, 2, 3], [1, 3], [2], [2, 3], [3]]
pop - 3
"""

def subsets(self, nums):
        res = []
        self.backtracking(res,0,[],nums)
        return res
        
        
    def backtracking(self,res,start,subset,nums):
        res.append(list(subset))
        print res
        for i in range(start,len(nums)):
            subset.append(nums[i])
            self.backtracking(res,i+1,subset,nums)
            print subset.pop()