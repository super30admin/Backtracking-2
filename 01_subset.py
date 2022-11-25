#Approach 1: Backtracking
#TC: (2 ^ n) * n #for select and not select we further multiple 2 ^ n by n
#SC: 2 ^ n #for answers
class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        answer = []
        n = len(nums)
        def dfs(index, currentList, count):
            #base
            if count == 0:
                answer.append(currentList)
                return
            #select
            dfs(index+1, currentList + [nums[index]], count - 1)

            #NotSelect
            dfs(index+1, currentList, count - 1)

        dfs(0,[], n)
        return answer

#approach 2: For loop
#TC : 2 ^ n total number of subsets
#SC : 2 ^ n

class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        answer = [[]]
        for num in nums:
            for i in range(len(answer)):
                curr = answer[i]
                answer.append(curr + [num])
        return answer

#approach 3: bit manipulation
#TC: O(2^n * n)
#SC: O(2^n)
class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        n = len(nums)
        num = pow(2,n)
        answer = []
        for i in range(num):
            subset = []
            for j in range(n):
                if (i&(1<<j)):
                    subset.append(nums[j])
            answer.append(subset)
        return answer
