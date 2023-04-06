#TC-O(n*2**n)-n for copying and 2**n for 2 choices at each element
#SC-O(n)
#logic- at each element, consider choose and dont choose cases and repeat recursively till
#you reach end of nums 
class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        result=[]
        def helper(nums,idx,path):
            #base
            if idx==len(nums):
                result.append(path.copy())
                return
            #dont take
            helper(nums,idx+1,path)
            #take
            path.append(nums[idx])
            helper(nums,idx+1,path)
            path.pop(-1)
            
        helper(nums,0,[])
        return result