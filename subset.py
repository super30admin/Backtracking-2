Time complexity: o(n*2^n)
space complexity: o(n*2^n)


class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        def backtrack(first = 0, curr = []):
            print(curr)
            # if the combination is done
            if len(curr) == k:  
                output.append(list(curr))
            for i in range(first, n):
                print(i)
                # add nums[i] into the current combination
                curr.append(nums[i])
                # use next integers to complete the combination
                backtrack(i + 1, curr)
                # backtrack
                curr.pop()      
        output = []
        n = len(nums)
        for k in range(n + 1):
            backtrack()
        return output
