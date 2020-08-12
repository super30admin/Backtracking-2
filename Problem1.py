#Time complexity: O(n * 2^n)
#Space complexity: O(1) since we only use results to calculate more results
#Works on leetcode: yes
#Approach: The idea here is to set res variable and iterate through the list. At each iteration i, we add a list to the res 
#formed by adding num[i] to each element of previous res. 
 
class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        res = [[]]
        for n in nums:
            res += [r+[n] for r in res]
            #print(res)
        return res
        