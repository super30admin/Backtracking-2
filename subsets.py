class Solution(object):
    def subsets(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        if nums==[]:
            return [[]]
        result=[]
        # def recc(nums,index,path):
        #     if index==len(nums):
        #         result.append(path)
        #         return
        #     #dont choose
        #     recc(nums,index+1,list(path))
        #     #choose
        #     path.append(nums[index])
        #     recc(nums,index+1,list(path))
        # recc(nums,0,[])
        # return result
        def recc(nums,index,path):
            # if index>=len(nums):
            #     return
            # if index==len(nums):
            #     result.append(list(path))
            #     return
            result.append(list(path))
            # print(index)
            for i in range(index,len(nums)):
                path.append(nums[i])
                recc(nums,i+1,path)
                path.pop()
        recc(nums,0,[])
        return result
    #time,space-O(2**n)