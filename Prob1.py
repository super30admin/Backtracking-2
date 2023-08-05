# TC - O(n*2^n), we have 2 options for n elements and then n from the i=pivot to n for loop.
# SC - O(n)

class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        res=[]

        # Method 1 0/1 backtracking
        # def helper(nums,i,path):
        #     #base
        #     if i==len(nums):
        #         res.append(copy.deepcopy(path))
        #         return

        #     #logic
        #     helper(nums,i+1,path) #not choose
        #     #action
        #     path.append(nums[i])
        #     #recurse
        #     helper(nums,i+1,path) #choose
        #     #backtrack
        #     path.pop()
            
        # helper(nums,0,[])
        # return res

        # Method 2 0/1 deepcopying
        # def helper(nums,i,path):
        #     #base
        #     if i==len(nums):
        #         res.append(copy.deepcopy(path))
        #         return
        #     #logic
        #     helper(nums,i+1,copy.deepcopy(path)) #not choose
        #     path.append(nums[i])
        #     helper(nums,i+1,copy.deepcopy(path)) #choose
        # helper(nums,0,[])
        # return res

        # Method 3 for loop backtracking
        # def helper(nums,pivot,path):
        #     #base
        #     if pivot>len(nums):
        #         return

        #     #logic
        #     res.append(copy.deepcopy(path))
        #     for i in range(pivot,len(nums)):
        #          #action
        #         path.append(nums[i])
        #         #recurse
        #         helper(nums,i+1,path)
        #         #backtrack
        #         path.pop()
        # helper(nums,0,[])
        # return res

        # Method 4 for loop deepcopying
        # def helper(nums,pivot,path):
        #     #base
        #     if pivot>len(nums):
        #         return
        #     #logic
        #     res.append(path)
        #     for i in range(pivot,len(nums)):
        #         li=copy.deepcopy(path)
        #         path.append(nums[i])
        #         helper(nums,i+1,li)
        # helper(nums,0,[])
        # return res

        #Method 5 - Iterative with deepcopy
        res=[[]]
        for i in range(len(nums)):
            size=len(res) #do this else, infinite loop since we'll be iterated over an array we constantly append to
            for j in range(size):
                li=copy.deepcopy(res[j]) #this is needed else same reference will be used again and again when adding new elements
                li.append(nums[i])
                res.append(li)
        return res
