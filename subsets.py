class Solution(object):
    # T.C is O(2 pow(n))
    # S.C is O(n)
    # All cases passed in leetcode
    def subsets(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        self.result = []
        if nums is None:
            return []

        print("triggered the recursion call")
        self.helper(nums, 0, [])
        return self.result

    def helper(self, nums, index, path):

        # base
        if index == len(nums):
            print("in if condition", index, path)
            self.result.append(path)
            return

        # 0 case dont pick
        print("before helper call 0", index, path)
        self.helper(nums, index + 1, path)
        # 1 case pick

        print("after helper call 0", index, path)
        self.helper(nums, index + 1, path + [nums[index]])

        print("after helper call 1", index, path)


class Solution(object):
    def subsets(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        self.result = []
        if nums is None:
            return []

        print("triggered the recursion call")
        self.helper(nums, 0, [])
        return self.result

    def helper(self, nums, index, path):

        # base
        if index == len(nums):
            print("in if condition", index, path)
            temp = [i for i in path]
            self.result.append(temp)
            print(self.result)
            return

        # 0 case dont pick
        print("before helper call 0", index, path)
        self.helper(nums, index + 1, path)
        # 1 case pick

        print("after helper call 0 before 1 operation", index, path)
        path += [nums[index]]
        self.helper(nums, index + 1, path)
        print("path before remove", index, path)
        path.pop()
        print("after helper call 1", index, path)


class Solution(object):

    def subsets(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        self.result = []
        if nums is None:
            return []
        self.helper(nums, 0, [])

        return self.result

    def helper(self, nums, index, path):
        self.result.append(path)
        for i in range(index, len(nums)):
            temp_list = list(path)
            temp_list.append(nums[i])
            self.helper(nums, i + 1, temp_list)


class Solution(object):

    def subsets(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        self.result = []
        if nums is None:
            return []
        self.helper(nums, 0, [])

        return self.result

    def helper(self, nums, index, path):
        temp_list = list(path)
        self.result.append(temp_list)
        for i in range(index, len(nums)):
            path.append(nums[i])
            self.helper(nums, i + 1, path)
            path.pop()


class Solution(object):
    # T.C id O(2pow(n))
    # S.c is O(1)
    def subsets(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        result = []
        if nums is None:
            return []
        result.append([])
        for ele in range(len(nums)):
            size_result = len(result)
            for each in range(size_result):
                temp = list(result[each])
                temp.append(nums[ele])
                result.append(temp)

        return result