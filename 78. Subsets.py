# Time: 2^n as we have 2 choices for every element in the nums array, either we choose it or we don't choose it. So the total number of subsets will be 2^n where n is the length of the nums array.
# space: O(n) which will be the height of the tree

# In 0-1 recursion we wait for the idx to be equal to the length of the nums array before we add the path to the result because we want to make sure that we have explored all the possibilities of choosing and not choosing each element in the nums array.
# Then we always pass i+1 as we don't want to reuse the same element again in the same path. We want to move forward in the nums array to explore the next elements.
# While choosing we add the current element to the path and then we backtrack by removing the last element from the path after the recursive call. This way we can explore the next possibility of not choosing the current element in the next iteration of the loop.

class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:

        # ZERO ONE RECURSION SOLUTION

        self.result = []
        self.helper(nums, 0, [])
        return self.result
    def helper(self, nums, idx, path):
        # Base
        if idx == len(nums):
            self.result.append(list(path))
            return

        # action

        # not choose
        self.helper(nums, idx + 1, path)
        # choose 
        path.append(nums[idx])
        self.helper(nums, idx + 1, path)
        path.pop()



# FOR LOOP BASED RECURSION

# The complexities remain the same as this is just a braoder tree rather that a long one in 0-1 recursion.
# In for loop based recursion we add the path to the result at every node because the not choose case is implicitly handled by the for loop. The for loop iterates through the nums array starting from the pivot index and explores all the possibilities of choosing each element in the nums array. We don't need to explicitly handle the not choose case because it is already covered by the for loop iterating through the nums array.
# In the loop we do action -> recurse -> backtrack and always pass i+1 as we don't want to repeat the element again.
class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        self.result = []
        self.helper(nums, 0, [])
        return self.result
    def helper(self, nums, pivot, path):
        # No need for base case because we have to append to results at every node
        self.result.append(list(path))
        
        for i in range(pivot , len(nums)):
            # action
            path.append(nums[i])
            # recurse
            self.helper(nums, i + 1, path)
            # backtrack
            path.pop()


# Time: O(2^n)
# Space: O(1)

# To get a exhaustive solution we need to have two loops one that runs on the nums array and another that runs on the result array. 
# The first loop is to iterate through the nums array and the second loop is to iterate through the result array to get all the existing subsets and add the current element from the nums array to those subsets to create new subsets. 
# This way we can get all the possible subsets of the nums array.

class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        res = [[]]

        for i in range(len(nums)):
            for j in range(len(res)):
                li = list(res[j])
                li.append(nums[i])
                res.append(li)
        return res