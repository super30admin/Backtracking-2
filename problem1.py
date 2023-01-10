#time complexity: O(N*(2^N))
#space complexity: O(N)
#ran on leetcode: Yes
#Do a DFS backtracking. Loop through all elements in nums. Add each element to a intermediate list that is passed thorughn recursion parameters and perform a recusrsion. Now remove this element from the list and perform a recusrion. In base condition, no more elements can be picked from nums and append the intermediate result to output array.
class Solution:
    def rec(self,nums,index,res):
        self.ans.append(res[:])
        for i in range(index,len(nums)):
            res.append(nums[i])
            self.rec(nums,i+1,res)
            del(res[-1])
            

    def subsets(self, nums: List[int]) -> List[List[int]]:
        self.ans=[]
        self.rec(nums,0,[])
        return self.ans
