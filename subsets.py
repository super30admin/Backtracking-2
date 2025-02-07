# tc O(2^n * n), sc O(2^n * n).
all_subsets = [[]]

for num in nums:
    for idx in range(len(all_subsets)):
        all_subsets.append(all_subsets[idx] + [num])

return all_subsets