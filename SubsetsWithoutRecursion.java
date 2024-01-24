/*
* Approach:
*  1. Take result list with empty set as first element
* 
*  2. Iterate over result list and 
        take deep copy of every element and 
        add the current index element to copied list.
        add the updated list to result.
* 
*  3. Continue till all elements are explored.
    finally, return the result.
* 
* 
* Did this code successfully run on Leetcode : YES
* 
* Any problem you faced while coding this : NO
* 
* Time Complexity: O(2^n)
    0 - 1 - 2 - 4 ........
* 
* Space Complexity: O(2^n)
* 
*/

import java.util.ArrayList;
import java.util.List;

public class SubsetsWithoutRecursion {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        result.add(new ArrayList<>());

        for (int index = 0; index < nums.length; index++) {
            int size = result.size();

            for (int itemIndex = 0; itemIndex < size; itemIndex++) {
                List<Integer> item = new ArrayList<>(result.get(itemIndex));

                item.add(nums[index]);

                result.add(item);
            }
        }

        return result;
    }
}
