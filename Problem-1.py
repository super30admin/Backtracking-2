class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        def helper(n):
            if n < 0:
                superset.append(subset.copy())
                return
            
            #Include
            subset.append(nums[n])
            helper(n-1)
            #Exclude
            subset.remove(nums[n])
            helper(n-1)

        subset, superset = [], []
        helper(len(nums)-1)
        return superset