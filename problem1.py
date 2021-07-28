class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
#         #Recursion backtrack-choose don't choose
#         self.final=[]
#         if len(nums)==0:
#             return []
#         def helper(index,nums,path):
#             if len(nums)==index:
#                 self.final.append([v for v in path])
#                 return
#             #don't choose
#             helper(index+1,nums,path)
            
#             #choose
#             path.append(nums[index])
#             helper(index+1,nums,path)
#             path.pop()
            
#         helper(0,nums,[])
#         return self.final
#         #Time O(2^n)
#         #Space O(n)
    
        #Recursion backtrack-for loop
        self.final=[]
        if len(nums)==0:
            return []
        def helper(index,nums,path):
            if len(nums)==index:
                return
            for i in range(index,len(nums)):
                path.append(nums[i])
                self.final.append([v for v in path])
                helper(i+1,nums,path)
                path.pop()
            
        helper(0,nums,[])
        self.final.append([])
        return self.final
    
        #For loop approach
        # final=[[]]
        # for i in range(len(nums)):
        #     cur=[]
        #     for val in final:
        #         cur.append(val+[nums[i]])
        #     final.extend(cur)
        # return final
