#In this code, I implemented a recursive backtracking approach to generate all possible subsets of a given list of numbers. The subsets function initializes the result list res and calls the helper function explore with the initially empty chosen list and the input nums as remaining. The explore function operates by exploring all possibilities of including or excluding each element in the subset. For each element, it is added to the chosen list (representing inclusion), and the function is recursively called to explore further. After returning from the recursion, the element is removed from chosen (representing exclusion), and the function is called again. The base case of the recursion is when remaining is empty, at which point the current chosen subset is appended to res. The time complexity of this solution is O(2^n⋅n), where n is the length of the input list, as there are 2^n possible subsets and each subset takes O(n) time to create. The space complexity is O(n) due to the recursion stack and additional space used for storing subsets in res.

class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        def explore(chosen, remaining, res):
            if not remaining:
                res.append(chosen[:])
                return
            d = remaining.pop(0)
            #choose
            chosen.append(d)
            #explore
            explore(chosen, remaining, res)
            chosen.pop()
            explore(chosen, remaining, res)
            #unchoose
            remaining.insert(0, d)
        
        res = []
        chosen = []
        explore(chosen, nums, res)
        return res