//Time complexity: O(N X 2 power N)
//space complexity:O(N X 2 power N)
//Run on Leetcode: yes
//Any issues: No

class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        def dfs(pointer, path, result):
            
            # base case:
            sorted_path = sorted(path)
            if sorted_path not in result:
                result.append(sorted_path)
                
            elif len(nums[pointer:]) == 0:
                return

            for i in range(pointer, len(nums)):
                dfs(i+1, path+[nums[i]], result)
                
        result = [[]]
        dfs(0, [], result)
        return result