#space:o(h)
#time: O(n)
class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        if nums is None:
            return []
        self.final= list(list())
        self.recurse(nums,list(),0)
        return self.final

    def recurse(self, nums, path,index):
        self.final.append(path.copy())
        if index== len(nums):
            return

        for i in range(index, len(nums)):
            path.append(nums[i])
            self.recurse(nums,path, i+1)
            path.pop()
