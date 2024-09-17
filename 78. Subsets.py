#Time Complexity:O(2^n)
#Space Complexity:O(n)

class Solution(object):
    def subsets(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        result=[]
        def backTrack(nums,index,path):
            result.append(path[:])
            for i in range(index,len(nums)):
                path.append(nums[i])
                backTrack(nums,i+1,path)
                path.pop()


        backTrack(nums,0,[])
        return result