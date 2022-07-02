#Approach - Brute force recursion with backtrack
#Time complexity : O(2^n)) here n is number of elements
#Space complexity : O(n) where n is the depth of tree
#Did this code successfully run on Leetcode : Yes
#youtube : https://www.youtube.com/watch?v=ciYRVgANgbM&ab_channel=%7BS30%7D
class Solution:
    def __init__(self):
        self.result = []
    def subsets(self, nums: List[int]) -> List[List[int]]:
        #checking null condition
        if nums == None or len(nums) ==0:
            return self.result
        self.helper(nums, 0, [])
        return self.result
    def helper(self, nums: List[int], index :int, path : List[int]):
        #base
        #when the leaf node is encountered i.e. index is similar as the length of the given set of numbers then we will append the result to the path
        if  index == len(nums):
            #appending the result by creating a new list as we are using path as a pointer so that each time due to backtrack there will be change in path and it will not be reflected in the result
            self.result.append(list(path))
            return
        #no choose
        self.helper(nums, index+1, path)
        #choose 
        #action
        path.append(nums[index])
        self.helper(nums,index+1, path)
        #backtrack
        path.pop()
        
