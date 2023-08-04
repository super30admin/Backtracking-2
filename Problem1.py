#Time Complexity :O(n*2^n)
#Space Complexity :O(n*2^n)
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : No

class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        result=[]
        result.append([])
        #[[]]
        for i in range(len(nums)):
            for j in range(len(result)):
                li=list(result[j]) 
                #[]
                #[][1]
                #[][1][2][1,2]
                li.append(nums[i])
                #[1]
                #[2][1,2]
                #[3][1,3][2,3][1,2,3]
                result.append(li) 
                #[][1]
                #[][1][2][1,2]
                #[][1][2][1,2][3][1,3][2,3][1,2,3]
        return result
        