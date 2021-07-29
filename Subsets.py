#Time:O(2^N) as we chose/unchose at each value
#Space:O(N) max depth of the recursion is equal to length of list
class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        def backtrack(first, curr = []):
            # if the combination is done
            output.append(curr[:])
            for i in range(first, n):
                curr.append(nums[i])
                backtrack(i + 1, curr)
                curr.pop()

        output = []
        n = len(nums)
        backtrack(0,[])
        return output