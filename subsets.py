class Solution:
    result = ""
    def subsets(self, nums: List[int]) -> List[List[int]]:

        self.result = []

        self.helper(nums , 0 , [])

        return self.result


    def helper(self,nums , index, path):

        #base case
        if index == len(nums):
            self.result.append(list(path))

            return

        #logic
        
        #do not choose
        self.helper(nums , index + 1 , path)

        #choose
        path.append(nums[index])
        self.helper(nums , index + 1 , path)

        #backtracking step

        path.pop(len(path) - 1)
        
