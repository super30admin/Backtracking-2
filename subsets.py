#Problem 1: Subsets
#Time Complexity: O*(n2^n)
#Space Complexity: O(n), since we don't count result array.

'''
Since we want all the possible combinations , which is 2^n, the time complexity can't be better than that.
Furthermore, since we need to append the combination list to res at each node, we have a O(n2^n) time
solution no matter what. We can imagine a binary tree with left meaning we choose the first number in
the array, right we don't choose. To avoid copying arrays at each node visit, we can keep a global
memory array with what is in the set at that node, and backtrack accordingly
'''
class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        if not nums:
            return[]
        res=[]
        memory=[]
        def helper(index):
            #base
            if index==len(nums):
                res.append(memory[:])
                return
            helper(index+1)
            #action
            memory.append(nums[index])
            #recurse
            helper(index+1)
            #backtrack
            memory.pop()
        helper(0)
        return res
