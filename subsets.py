class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        # Idea: Backtracking
        # 1. Add one element to the current list and append that list to output list
        # 2. Remove that element from the current list and move to the next element
        # 3. Time Complexity: O(2^N)
        # 4. Space Complexity: O(1) excluding output list and stack space
        
        output = []
        self.helper(nums,[],output,0)
        return output
        
    def helper(self,nums,temp,output,start):
        output.append([x for x in temp])
        for i in range(start,len(nums)):
            temp.append(nums[i])
            self.helper(nums,temp,output,i+1)
            temp.pop()
        
