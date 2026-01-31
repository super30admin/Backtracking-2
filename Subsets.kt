// In this problem, we need to find all possible subsets of a given set of integers. We are using backtracking to explore all combinations. We maintain a path that represents the current subset being constructed. 
//At each step, we have the choice to either include or exclude the current element. When we reach the end of the array, we add the current path to our result list.
// Time complexity: O(n * 2^n) where n is the number of elements and 2^n is the no. of substes
 // Space complexity : O(n)
class Solution {
    val result = mutableListOf<List<Int>>()
    fun subsets(nums: IntArray): List<List<Int>> {
        val path = mutableListOf<Int>()
        helper(nums, 0, path)
        return result
    }
    fun helper(nums: IntArray, i: Int,path: MutableList<Int>) {
        //base
        if(i == nums.size) {
            result.add(path.toList())
            return
        }

        //no choose
        helper(nums, i + 1, path)
        //choose
        //action
        path.add(nums[i])
        //recurse
        helper(nums, i+ 1, path)
        //backtrack
        path.removeAt(path.size - 1)
    }
}