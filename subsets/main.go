package main

// Time : 2^n : for each element in the array; we make further calls
// Space : O(n) : max space is n is length of array
func subsets(nums []int) [][]int {
	result := [][]int{}
	var helper func(nums []int, idx int, path []int)
	helper = func(nums []int, idx int, path []int) {
		// copy to result
		newcopy := make([]int, len(path))
		copy(newcopy, path)
		result = append(result, newcopy)

		// base
		if idx == len(nums) {
			return
		}
		for i := idx; i < len(nums); i++ {
			path = append(path, nums[i])
			helper(nums, i+1, path)
			path = path[:len(path)-1]
		}
	}
	helper(nums, 0, []int{})
	return result
}
