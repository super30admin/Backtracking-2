class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
    
        ## T.C = O(2^n)
        
		#######################################
        ## iterative solution

        result = [[]]
        x = 0
        n = len(nums)

        while x<n:
            for i in range(len(result)):
                n_l = list(result[i])
                n_l.append(nums[x])
                result.append(n_l)
            x+=1
        
        return result
        
        #######################################
        ## for-loop recursion with back track
        
        result = []
        idx = 0
        n = len(nums)

        def recurse3(nums, idx, path):
            
            result.append(list(path))
            for i in range(idx, n):
                ## action
                path.append(nums[i])

                ## recurse
                recurse3(nums, i+1, path)

                ## backtrack
                path.pop()


        recurse3(nums, 0, [])
        return result

        #######################################
        ## for-loop recursion

        result = []
        idx = 0
        n = len(nums)

        def recurse2(nums, idx, path):
            
            result.append(path)
            for i in range(idx, n):
                npath = list(path)
                npath.append(nums[i])
                recurse2(nums, i+1, npath)

        recurse2(nums, 0, [])
        return result

        #######################################
        ## 0-1 recursion with backtrack

        result = []
        idx = 0
        n = len(nums)

        def recurse1(nums, idx, path):
            
            ### base case
            if idx == n:
                result.append(list(path))
                return

            ### logic
            ## dont choose
            recurse1(nums, idx+1, path)

            ## choose
            ## action
            path.append(nums[idx])

            recurse1(nums, idx+1, path)

            ## backtrack
            path.pop()

        recurse1(nums, 0, [])
        return result