class Solution:
    '''
    Time Complexity: O(2^N)
    Space Complexity: O(n)
    
    '''
    def subsets(self, nums: List[int]) -> List[List[int]]:
        output = []
        
        
        def subset1(nums, index, path):
            output.append(path[:])
            if(index==len(nums)):
                return
            for i in range(index,len(nums)):
                # choose index
                path.append(nums[i])
                subset1(nums, i+1, path)
                # remove index for backtracking
                path.pop()
                
        subset1(nums, 0, [])
        return output    
