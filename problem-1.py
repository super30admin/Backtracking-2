# Time Complexity : O(2^n)
# space complexity : O(n)

# Approach :

#   Choose or not choose recursion
#   keep two recursive calls, one which includes the element and another which moves the index to the next position
#   keep a list which adds element to it
#   if index is equal to length of nums array, add the combination to a final result array and return
#   in recursive call, make sure to pass a copy of the array and not the reference as it can lead to appending all the elements in the answer


#   Choose or not choose backtracking
#   keep two recursive calls, one which includes the element and another which moves the index to the next position
#   keep a list which adds element to it
#   if index is equal to length of nums array, add the combination to a final result array and return
#   in backtracking, remove the last element from the array and add a copy of the array to the final list as otherwise the array can become empty


#   for loop based recursion
#   keep one recursive call
#   keep a newlist which keeps getting new elements added
#   iterate from index to length of the candidates array

#   for loop based bactracking
#   keep one recursive call
#   keep adding to the elements to path list array
#   iterate from index to length of the candidates array
#   keep popping the last element from the list
#   keep a copy of the list to be appended to the final array list, else it will be empty.


class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:

        self.path = []
        self.recurse(nums, 0, [])
        return self.path

    def recurse(self, nums, index, path):

        if index == len(nums):
            self.path.append(path)
            return

        self.recurse(nums, index+1, list(path))
        path.append(nums[index])
        self.recurse(nums, index+1, list(path))


class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:

        self.path = []
        self.backtrack(nums, 0, [])
        return self.path

    def backtrack(self, nums, index, path):

        if index == len(nums):
            self.path.append(list(path))
            return

        self.backtrack(nums, index+1, path)
        path.append(nums[index])
        self.backtrack(nums, index+1, path)
        path.pop()


class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:

        self.path = []
        self.recurse(nums, 0, [])
        return self.path

    def recurse(self, nums, index, path):

        self.path.append(path)

        for i in range(index, len(nums)):

            new_path = list(path)
            new_path.append(nums[i])
            self.recurse(nums, i+1, new_path)


class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:

        self.path = []
        self.backtrack(nums, 0, [])
        return self.path

    def backtrack(self, nums, index, path):

        self.path.append(list(path))
        for i in range(index, len(nums)):

            path.append(nums[i])
            self.backtrack(nums, i+1, path)
            path.pop()
