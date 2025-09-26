'''
Solution 1: Choose/No choose based recursion with backtracking
Time Complexity: O(2^N), N =len(nums)
Space Complexity: O(N), recursive stack, height of tree. 
'''
class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        subsets_list = []
        self.helper(nums,0,[],subsets_list) #nums, current_index, current path, answer list

        return subsets_list

    def helper(self, nums, current_index, current_path, subsets_list):
        # base
        if current_index==len(nums): # captured the new subset
            subsets_list.append(deepcopy(current_path))
            return
        
        # logic
        # no choose
        self.helper(nums, current_index+1, current_path, subsets_list)

        # choose
        current_path.append(nums[current_index]) # action
        self.helper(nums, current_index+1, current_path, subsets_list)
        current_path.pop() # backtrack

'''
Solution 2: For loop based recursion with backtracking
Time Complexity: O(2^N), N =len(nums)
Space Complexity: O(N), recursive stack, height of tree. 
'''
class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        subsets_list = []
        self.helper(nums,0,[],subsets_list) #nums, pivot index, current path, answer list

        return subsets_list

    def helper(self, nums, pivot_index, current_path, subsets_list):
        # base - not needed
        
        
        
        # logic
        subsets_list.append(deepcopy(current_path))
        for i in range(pivot_index,len(nums)):
            current_path.append(nums[i]) # action
            self.helper(nums, i+1, current_path, subsets_list)
            current_path.pop() # backtrack
