#  Time Complexity: O(2^n * n)
#  Space Complexity: O(2^n * n)



class Solution:
    result = []

    # choose not Choose / 0/1 recursion:
    def subsets(self, nums):
        self.result = []
        if nums == None or len(nums) == 0:
            return self.result
        self.helper(nums,0,[]) 
        return self.result
    
    def helper(self,nums,i,path):
        if i == len(nums):
            self.result.append(path.copy())
            return
        
        # here we don't need repeating value, so whether I choose or not chose I will move to the next number, 
        # but if I choose then I must add the value to the path
        # Choose (1)
        li = list.copy(path)
        li.append(nums[i]) 
        self.helper(nums,i+1,li)

        # not Choose (0)
        self.helper(nums, i+1, path)
        
    
    
    
    #For loop recursion     
    def subsets2(self, nums):
        self.result = []
        if nums == None or len(nums) == 0:
            return self.result
        self.helper2(nums,0,[])
        return self.result

    def helper2(self,nums,index,path):
        self.result.append(path)

        # in this method, we took for loop over nums list from index to the whole list
        # so index will become pivot
        # for example, nums = [1,2,3]
        # first index = 1, so loop will from 1(pivot) to 3
        # after this recursion index will be 2(pivot), so loop will move from 2 to 3.
        #                       [1, 2, 3]
        #                       /
        #          path=[1] [2,3]  ->  for loop will iterate over this starting from index[2](pivot) to len(nums). 
        #                   /
        #        path=[1,2][3] ->  for loop will iterate over this starting from index[3](pivot) to len(nums). 
        #                  /
        #     path=[1,2,3][] after this point, 3 is finished so backtraking will happens,
        #                    recursion go over [2,3], where index[2] was pivot, so pivot move to 3 and add that, while make [1,3]
        #                     after [2,3] recursion go the [1,2,3], where 1 is completed, so pivot move to the 2, where only 2 is aaded to the path
        #                     same thing happens again. this explaination displayed in below graph
        #                                           [1, 2, 3]
        #                                           /   |   \
        #                                          /    |    \
        #                            path=[1] [2,3]     |    path=[3] 
        #                  path=[1,3][]       /         |
        #                                    /          |
        #                      path=[1,2] [3]  path=[2][3]
        #                                  /            |
        #                                 / path= [2,3][]
        #                  path=[1,2,3] []
        # 
        for i in range(index, len(nums)):
            li = list(path)
            li.append(nums[i])
            self.helper(nums,i+1,li)
       

obj = Solution()
print(obj.subsets([1,2,3]))
print(obj.subsets2([1,2,3]))