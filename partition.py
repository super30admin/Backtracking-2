# Time: O(n*2^n) - at every index the algorithm makes a binary choice (choose or no choose) - 2^n leaf nodes
# path + [nums[idx]] copies entire list into new list (n)

# Space: O(n^2) because we create list copies at each recursive call, keep track of separate path lists

class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        self.result = []

        def helper(idx,path):
            if idx == len(nums):
                self.result.append(path)
                return

            # no choose
            helper(idx+1,path)

            # choose
            # + creates a brand new path, meaning left and right branches of tree look at diff spots in memory
            helper(idx+1,path+[nums[idx]])

        helper(0,[])
        return self.result 


# Time: O(n*2^n) - at every index the algorithm makes a binary choice (choose or no choose) - 2^n leaf nodes
# path + [nums[idx]] copies entire list into new list (n)
# Space: O(n) with backtrack
class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        self.result = []
        path =[]
        def helper(idx):
            if idx == len(nums):
                self.result.append(path.copy())
                return

            # no choose
            helper(idx+1)
            # choose
            path.append(nums[idx])
            helper(idx+1)
            # backtrack
            path.pop()

        helper(0)
        return self.result 

# basic loop solution
# Time: O(n*2^n)
# space: O(n)
class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        result=[[]]
        for num in nums:
            size = len(result)
            for j in range(size):
                temp = result[j][:]
                temp.append(num)
                result.append(temp)

        return result 