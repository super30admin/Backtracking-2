#Time: O(n * 2^n)
#Space: O(n)
#issues faced: when candidate is appended as a list to the result, it is getting modified with the modification in the candidate
#did the code run successfully on LC: yes
#Approach:
#using recursion form subsets
#at every element u either chooose or not choose it.
#when you choose the element and recurse, u backtrack again for the not choose case.

class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        result = []
        def backtrack(idx, candidate):
            if idx == len(nums):
                result.append(tuple(candidate))
                return
            candidate.append(nums[idx]) #place
            backtrack(idx+1, candidate) #recurse
            candidate.pop() #backtrack
            backtrack(idx+1, candidate) #case0
            
        backtrack(0, [])
        return result
