# Time Complexity:- 2 choices:- Choose and choose:- 2^n
# Space Complexity:- n+n
# Approach:- At every point we have an option choose or not choose we use backtracking to enumerate all the possible subsets
class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        res=[]
        def backtrack(temp,pivot):
            res.append(list(temp))
            for i in range(pivot,len(nums)):
                temp.append(nums[i])
                backtrack(temp,i+1)
                temp.pop()
        backtrack([],0)
        return res