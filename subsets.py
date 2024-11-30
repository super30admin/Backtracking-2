# // Time Complexity :O(2^n) for 0-1 recursion with backtracking; O(n*2^n) sfor all
# // Space Complexity :O(n)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this :No

# for loop based recursion: n*2^n
class Solution:
    def subsets(self, nums: list[int]) -> list[list[int]]:
        result = []
        
        def helper(nums,pivot,path):
            #basecase
            result.append(path[:])                              # all children are op

            if pivot == len(nums):                              # recursion doesnt go infinte
                return
                       
            #logic
            for i in range(pivot,len(nums)):                    # handle duplication pivot 
                # action
                path.append(nums[i])
                # recurse
                helper(nums,i+1,path)
                # backtrack
                path.pop()
                

        helper(nums,0,[])
        return result
    #result: [[], [1], [1, 2], [1, 2, 3], [1, 2, 3, 4], [1, 2, 4], [1, 3], [1, 3, 4], [1, 4], [2], [2, 3], [2, 3, 4], [2, 4], [3], [3, 4], [4]]


#0-1 recursion with backtracking : 2^n
class Solution2:
    def subsets(self, nums: list[int]) -> list[list[int]]:
        result = []

        def helper(nums,i,path):
            #basecase
            if i == len(nums):                      
                result.append(path[:])
                return

            #logic
            #nochose
            helper(nums,i+1,path)                   #same cond

            #chose
            path.append(nums[i])
            helper(nums,i+1,path)                   #same cond but with friends
            path.pop()
            
        helper(nums,0,[])
        return result
#OP: [[], [4], [3], [3, 4], [2], [2, 4], [2, 3], [2, 3, 4], [1], [1, 4], [1, 3], [1, 3, 4], [1, 2], [1, 2, 4], [1, 2, 3], [1, 2, 3, 4]]    

# alternative 2 for loops: n*2^n

class Solution3:
    def subsets(self, nums: list[int]) -> list[list[int]]:
        res = [[]]
        
        for num in nums:                        # [1,2,3,4] set pivot
            n = len(res)                        # store to re-use 4
            for i in range(n):                  
                tempRes = res[i][:]           # [[]]* -> [[]]      ->  [[],[1]]
                tempRes.append(num)                # [[]]  -> [[1]]     ->  [[2],[1,2]]
                res.append(tempRes)                # [[]]* -> [[],[1]]  ->  [[],[1],[2],[1,2]]

        return res                          
#OP:[[], [1], [2], [1, 2], [3], [1, 3], [2, 3], [1, 2, 3], [4], [1, 4], [2, 4], [1, 2, 4], [3, 4], [1, 3, 4], [2, 3, 4], [1, 2, 3, 4]]


arr = [1,2,3,4]

x = Solution3().subsets(arr)
print(x)