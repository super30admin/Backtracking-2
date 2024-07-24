def subsets(nums):
    def backtrack(start, path):
        # Add the current subset to the result
        result.append(list(path))
        
        # Explore further elements to generate all possible subsets
        for i in range(start, len(nums)):
            # Include the element nums[i] in the subset
            path.append(nums[i])
            # Move to the next element
            backtrack(i + 1, path)
            # Backtrack by removing the last element
            path.pop()
    
    result = []
    backtrack(0, [])
    return result

# Example usage:
nums = [1, 2, 3]
print(subsets(nums))
# Output: [[], [1], [1, 2], [1, 2, 3], [1, 3], [2], [2, 3], [3]]

#time = O(2^n⋅n)
#space = O(2^n⋅n)
