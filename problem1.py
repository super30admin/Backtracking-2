class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:

        self.result = []

        self.helper(nums,[],0)

        return self.result

    def helper(self,nums,path,index):

        self.result.append(path)

        for i in range(index,len(nums),1):

            temp = list(path)

            temp.append(nums[i])

            self.helper(nums,temp,i+1)


        
