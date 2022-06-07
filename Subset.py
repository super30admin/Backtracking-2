'''
time complexity: O(exponential)
space complexity: O(len(num))
'''

Class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        global results
        results = []
        
        self.helper(nums,0,[])
        return results
    def helper(self,nums,idx,ls):
        
        global results
        
        if(idx==len(nums)):
            results.append(list(ls))
            return
        ls.append(nums[idx])
        self.helper(nums,idx+1,ls)
        ls.pop()
        self.helper(nums,idx+1,ls)