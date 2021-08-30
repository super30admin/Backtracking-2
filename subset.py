"""
#T.C = O(N×2^N) exponential to generate all subsets and then copy them into output list.


#         #S.C =  O(N). We are using O(N) space to maintain curr, and are modifying curr in-place with backtracking.
"""

class Solution(object):
    def subsets(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        if(len(nums)==0):
            return []
        result = []
        result.append([])
        for n in nums:
            size = len(result)
            for i in range(0,size):
                temp = list(result[i])
                temp.append(n)
                result.append(temp)
        return result
        
#         #T.C = O(N×2^N) exponential to generate all subsets and then copy them into output list.


#         #S.C =  O(N). We are using O(N) space to maintain curr, and are modifying curr in-place with backtracking.
        
#         #backtrack solution
#         self.result = []
#         if (len(nums)==0):
#             return self.result
#         self.recurse(nums,0,[])
#         return self.result
#     def recurse(self,nums,index,path):
#         #base
#         if(index==len(nums)):
#             self.result.append(list(path))
#             return
#         #do not choose
#         self.recurse(nums,index+1,path)
        
#         #choose
#         #action
#         path.append(nums[index])
#         #recurse
#         self.recurse(nums,index+1,path)
#         #backtrack()
#         path.pop()
        
        
        #recursion solution
#         self.result = []
#         if (len(nums)==0):
#             return self.result
#         self.recurse(nums,0,[])
#         return self.result
#     def recurse(self,nums,index,path):
#         #base
#         if(index==len(nums)):
#             self.result.append(path)
#             return
#         #do not choose
#         self.recurse(nums,index+1,list(path))
        
#         #choose
#         path.append(nums[index])
        
#         self.recurse(nums,index+1,list(path))
        
        