# Time Complexity: O(n*2^n)
# Space Complexity: O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    # for loop based Recursive Backtrack
    def __init__(self):
        self.result = list()

    def subsets(self, nums: List[int]) -> List[List[int]]:
        self.backtrack(nums,0,[])
        return self.result

    def backtrack(self,nums,index,path):
        # if index==len(nums):
        #     self.result.append(path[:])
        #     return
        # we dont have a base case here since the for loop will take care of the bound
        self.result.append(path[:])
        for i in range(index,len(nums)):
            # action
            path.append(nums[i])
            #recurse
            self.backtrack(nums,i+1,path)
            #backtrack
            path.pop()

    # for loop based Recursive Solution
    # def __init__(self):
    #     self.result = list()

    # def subsets(self, nums: List[int]) -> List[List[int]]:
    #     self.recurse(nums,0,[])
    #     return self.result

    # def recurse(self,nums,index,path):
    #     # if index==len(nums):
    #     #     # self.result.append(path)
    #     #     return
    #     self.result.append(path)
    #     for i in range(index,len(nums)):
    #         newlist = path[:]
    #         newlist.append(nums[i])
    #         self.recurse(nums,i+1,newlist)

    # 0-1 Recursive Backtrack
    # def __init__(self):
    #     self.result = list()

    # def subsets(self, nums: List[int]) -> List[List[int]]:
    #     self.backtrack(nums,0,[])
    #     return self.result

    # def backtrack(self,nums,index,path):
    #     if index==len(nums):
    #         self.result.append(path[:])
    #         return

    #     # Case to not select the element
    #     self.backtrack(nums,index+1,path)
    #     # Case to select the element
    #     path.append(nums[index])
    #     self.backtrack(nums,index+1,path)
    #     path.pop()

    # 0-1 Recursive Solution
    # def __init__(self):
    #     self.result = list()

    # def subsets(self, nums: List[int]) -> List[List[int]]:
    #     self.recurse(nums,0,[])
    #     return self.result

    # def recurse(self,nums,index,path):
    #     if index==len(nums):
    #         self.result.append(path)
    #         return
    # # # Case to not select the element
    #     self.recurse(nums,index+1,path[:])
    # # # Case to select the element
    #     path.append(nums[index])
    #     self.recurse(nums,index+1,path[:])