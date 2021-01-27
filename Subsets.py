class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        output = [[]]
        for num in nums:
            arr = []
            for curr in output:
                temp = [i for i in curr]
                temp.append(num)
                arr.append(temp)
            for i in arr:
                output.append(i)
        return output
        
