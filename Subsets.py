class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        if nums == None or len(nums) ==0:
            return [[]]
        self.result = []
        self.recursion(nums , [], 0)
        # print(self.result)
        return self.result



    def recursion(self, nums : List[int] , subsets: list[list[int]] ,pivot : int) -> None:
        
        # 1 case

        self.result.append(subsets)
        for i in range(pivot, len(nums)):
            newList = [num for num in subsets]
            newList.append(nums[i])
            #if( nums[pivot])
            self.recursion(nums, newList, i + 1)


    # def recursion(self, nums : List[int] , subsets: list[list[int]] , index : int) -> None:
    #     if index == len(nums):
    #         self.result.append([num for num in subsets])
    #         return
    #     # else:
    #     #     self.result.append(subsets)       

    #     # 0 case 
    #     self.recursion(nums, subsets, index+1)

    #     # 1 case
    #     subsets.append(nums[index])
    #     self.recursion(nums, subsets,index + 1)
    #     subsets.pop()
        # for i in range(len(nums)):
        #     subsets.append([])
        #     subsets[i].append(nums[index])
        #     if nums[i] == nums[index]:
        #         i += 1
        #     else:
        #         subsets[i].append(nums[i])
        #     print(subsets)
        #     self.recursion(nums, subsets, index + 1 )
        
        