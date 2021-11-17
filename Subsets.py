class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        self.final = []
        def recur(temp,remaining):
            if len(remaining) == 0:
                self.final.append(temp)
                return
            else:
                self.final.append(temp)
                for i in range(len(remaining)):
                    recur(temp + [remaining[i]],remaining[i+1:])
                    
        self.final.append([])
        temp = []
        for i in range(len(nums)):
            recur(temp + [nums[i]],nums[i+1:])
        return self.final