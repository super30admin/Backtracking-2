#// Time Complexity : o(2^n)
# // Space Complexity : O(n) 
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this : no because i saw the class video and then did the problem.

class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        result= [[]]
        #without recursion
        for i in range(len(nums)):
            for j in range(len(result)):
                temp = result[j][:]
                temp.append(nums[i])
                result.append(temp)
        return result


        # #for loop based backtracking
        # result = []

        # def helper(pivot,path):
        #     nonlocal result
        #     result.append(deepcopy(path))
        #     for i in range(pivot,len(nums)):
        #         path.append(nums[i])
        #         helper(i+1,path)
        #         path.pop()
        # helper(0, [])
        # return result


        # #for loop based recursion
        # result = []

        # def helper(pivot,path):
        #     nonlocal result
        #     result.append(path)
        #     for i in range(pivot,len(nums)):
        #         li = deepcopy(path)
        #         li.append(nums[i])
        #         helper(i+1,li)
        # helper(0, [])
        # return result



        # #backtracking
        # result = []

        # def helper(ind,path):
        #     nonlocal result
        #     if ind == len(nums):
        #         result.append(deepcopy(path))
        #         return 
        #     #take
        #     #action
        #     path.append(nums[ind])
        #     #recurse
        #     helper(ind+1,path)
        #     #backtrack        
        #     path.pop()
        #     #notake
        #     helper(ind+1,path)
        
        # helper(0,[])
        # return result



        #01 recursion
        # result = []
        # def helper(nums,ind,path):
        #     nonlocal result
        #     if ind == len(nums):
        #         result.append(path)
        #         return
            
        #     #notake
        #     helper(nums,ind+1,path)
        #     #take
        #     li = deepcopy(path)
        #     li.append(nums[ind])
        #     helper(nums,ind+1,li)
        
        # helper(nums,0,[])
        # return result
            
        