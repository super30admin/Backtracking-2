#Time Complexity : O(2^L) where L is length of string
# Space Complexity : O(2^L) where 2^l times new array 
class Solution(object):
    def combinationSum(self, candidates, target):
        """
        :type candidates: List[int]
        :type target: int
        :rtype: List[List[int]]
        """
        result = []
        sum1 = 0
        def helper(candidates,temp,sum1,index):
            if sum1> target or index == len(candidates):
                return 
            if sum1 == target:
                result.append(temp)
                return
            
            helper(candidates,temp[:],sum1,index+1)
            temp.append(candidates[index])
            helper(candidates,temp[:],sum1 +candidates[index],index)
        temp = []
        helper(candidates,temp,0,0)
        return result
===========================================
#Time Complexity : O(2^L) where L is length of string
# Space Complexity : O(N) where N is number of elements
class Solution(object):
    def combinationSum(self, candidates, target):
        """
        :type candidates: List[int]
        :type target: int
        :rtype: List[List[int]]
        """
        result = []
        sum1 = 0
        def backtrack (candidates,temp,sum1,index):
            if sum1== target:
                result.append(temp[:])
            if sum1 > target:
                return
            for i in range(index,len(candidates)):
                temp.append(candidates[i])
                backtrack(candidates,temp,sum1+candidates[i],i)
                temp.pop()
        temp = []
        backtrack(candidates,temp,0,0)
        return result