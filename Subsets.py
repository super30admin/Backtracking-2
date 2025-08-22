# Approach 1 (with backtracking)
class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        if nums == None or len(nums) == 0:
            return []
        self.result = []
        self.recurse(nums, [], 0)
        return self.result

    
    def recurse(self, nums: List[int], target: List[int], indx: int):

        #base
        if indx >= len(nums):        
            self.result.append([n for n in target])
            return

        # logic

        #case 0
        self.recurse(nums, target, indx + 1)

        #case 1
        #action
        target.append(nums[indx])

        #recurse
        self.recurse(nums, target, indx + 1)

        #backtracking
        target.pop()


# Approach 2 (for loop recursion)
class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        if nums == None or len(nums) == 0:
            return []
        self.result = []
        self.recurse(nums, [], 0)
        return self.result

    
    def recurse(self, nums: List[int], target: List[int], pivot: int):

        #base
        self.result.append([n for n in target])
        
        # logic
        for i in range(pivot,len(nums)):
            #action
            target.append(nums[i])

            #recurse
            self.recurse(nums, target, i+1)

            #backtracking
            target.pop()