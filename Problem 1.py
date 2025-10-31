class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        res = []
        n = len(nums)
        def backtrack(i, sofar):
            if i>n:
                return

            
            #res.append(sofar.copy())
            print(sofar)
            
            for j in range(i, n):
                sofar.append(nums[j])
                backtrack(j+1,sofar)
                sofar.pop()
        
        backtrack(0, [])
        return res
