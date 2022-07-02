#Approach - Iterative approach
#Time complexity : O(2^n)) here n is number of elements
#Space complexity : O(n) where n is the depth of tree
#Did this code successfully run on Leetcode : Yes
#youtube : https://www.youtube.com/watch?v=ciYRVgANgbM&ab_channel=%7BS30%7D
class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        result =[]
        #appending the null subset in thre result 
        result.append([])
        #for loop will work for all the elements in nums list
        for i in range(len(nums)):
            #second for loop will work for all the number of elements there in the result after each iteration
            size = len(result)
            for j in range(size):
                #temp = list(result[j])
                #we are creating the copy of new list with the help of the slicing operator of all the subsets present in the list to append the coming numbers from the list
                temp = result[j][:]
                #appending the current num one by one to the already existing list for creating the subsets
                temp.append(nums[i])
                #appending the recent generate subset in the result
                result.append(temp)
            
        return result
