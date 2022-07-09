class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        # No backtracking - Iterative
        # Time complexity = O(N*(2**N))
        # Space complexity (result) = O(2**N)
        result = [[]]
        for i in range(len(nums)):
            size = len(result)
            for j in range(size):
                temp = result[j].copy()
                temp.append(nums[i])
                result.append(temp.copy())
        return result

    '''
        # Best - For loop - Backtracking - Recursion
        def helper(nums,pivot_index,path):
            #base
            # if i == len(nums): # leaf node [] # taken care by for loop
            result.append(path.copy())

            #logic
            for i in range(pivot_index,len(nums)):
                #action
                path.append(nums[i])

                #recurse
                helper(nums,i+1,path)

                #backtrack
                path.pop()

        result = []
        helper(nums,0,[])
        return result
    '''

    '''
        # Bcktracking - Recursion
        result = []

        def helper(nums,i,path):
            #base
            if i == len(nums): # leaf node []
                result.append(path.copy())
                return 
            #logic
            #case1 - no choose
            helper(nums,i+1,path)

            #case2- choose
            #action
            path.append(nums[i])

            #recurse
            helper(nums,i+1,path)

            #backtrack
            path.pop()

        helper(nums,0,[])
        return result
    '''
