class Solution:
    def subsets(self, nums):
        result = []
        if nums is None or len(nums) == 0:
            return result

        result.append([])

        for i in range(len(nums)):
            size = len(result)
            # print(size, "size")
            for k in range(size):
                temp = result[k].copy()
                # print(result[k])
                temp.append(nums[i])
                # print(temp,"temp")
                result.append(temp)
        return print(result)


if __name__ == "__main__":
    obj = Solution()
    obj.subsets([1, 2, 3, 4])

# [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3],[4],[1,4],[2,4],[1,2,4],[3,4],[1,3,4],[2,3,4],[1,2,3,4]]

# Time Complexity = O(2^n)
# Space complexity : O(2^n)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : No
