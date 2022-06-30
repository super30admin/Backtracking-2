#Approach - For loop based recursion 
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
        #logic
        #appending the incoming list first i.e first empty list comes it get append or the previous call path gets appended
        self.result.append(list(path))
        #for loop will execute from the current index to the last element in the list
        for i in range(index, len(nums)):
            #action
            #in path appending the current num
            path.append(nums[i])
            #recurse
            #here i+1 is used be we are not repeating same number again in the path
            self.helper(nums, i+1,path)
            #backtrack is done when leaf node is encountered and then goes up
            path.pop()
