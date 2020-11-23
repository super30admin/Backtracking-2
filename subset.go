// Time Complexity : O(2 to power n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
/*
append each temp to final result

for each index in nums
append nuxt digit to temp
call recursive with new temp and index
remove last from temp
*/
package main

import "fmt"

var res [][]int
func subsets(nums []int) [][]int {
	res = [][]int{}
	h(nums, []int{}, 0)
	return res
}

func h(nums []int, temp []int, index int) {
	temp1 := append([]int(nil), temp...)
	res = append(res, temp1)
	for i:= index;i<len(nums);i++ {
		temp = append(temp, nums[i])
		h(nums, temp, i+1)
		temp = temp[:len(temp)-1]
	}
}

func MainSubset() {
	fmt.Println(subsets([]int{1,2,3})) //expected [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
}


