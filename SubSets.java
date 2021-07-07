package com.ds.rani.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Given a set of distinct integers, nums, return all possible subsets (the power set).
 *
 * Note: The solution set must not contain duplicate subsets.
 *
 * Example:
 * Input: nums = [1,2,3]
 * Output:
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 */

//Approach: find out all the combinations and add those combinations who meet the criteria
//Time complexity:n*(2^n)
//Space complexity:o(n) as we are maintaning only single list
public class SubSets {

    List<List<Integer>> result;

    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        backtrack( nums, new ArrayList<Integer>(), 0 );
        return result;
    }

    private void backtrack(int[] nums, List<Integer> currList, int currIndex) {

        result.add( new ArrayList<>( currList ) );
        for (int i = currIndex; i < nums.length; i++) {
            //action
            currList.add( nums[i] );

            //recurse
            backtrack( nums, currList, i + 1 );

            //backtrack
            currList.remove( currList.size() - 1 );

        }
    }
}
