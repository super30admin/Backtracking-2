# without recursion lol
# TC: O(2^n)
# SC: O(1)
class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        ans=[[]]
        for num in nums:
            prev_subs_size=len(ans)
            for i in range(prev_subs_size):
                ans.append(ans[i]+[num])
        return ans


# for loop based recursion/backtracking
# TC: O(2^n)
# SC: O(n)
class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:

        def backtrack(st):
            nonlocal nums,cursubs,ans
            ans.append(copy.deepcopy(cursubs))
            for i in range(st,len(nums)):
                cursubs.append(nums[i])
                backtrack(i+1)
                cursubs.pop()

        ans,cursubs=collections.deque(),collections.deque()
        backtrack(0)
        return ans



# 0-1 based recursion/backtracking
# TC: O(2^n)
# SC: O(n)
class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:

        def backtrack(i):
            nonlocal nums,cursubs,ans
            if i==len(nums):
                ans.append(copy.deepcopy(cursubs))
                return
            #choose - action
            cursubs.append(nums[i])
            backtrack(i+1)
            #not choose - undo action
            cursubs.pop()
            backtrack(i+1)

        ans,cursubs=collections.deque(),collections.deque()
        backtrack(0)
        return ans

