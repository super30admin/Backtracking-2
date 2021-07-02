package Backtracking2;

import java.util.ArrayList;
import java.util.List;

public class question72_Subsets {
    /* Created by palak on 7/1/2021 */

    /*
        Time Complexity: O(n * 2^n)
        Space Complexity: O(n * 2^n)
    */
    List<List<Integer>> result1;
    public List<List<Integer>> subsets1(int[] nums) {
        result1  = new ArrayList<>();
        if(nums == null || nums.length == 0) return result1;
        helper1(nums, 0, new ArrayList<Integer>());
        return result1;
    }
    private void helper1(int[] nums, int index, List<Integer> path) {
        // Base
        if(index == nums.length) {
            result1.add(new ArrayList<>(path));
            return;
        }
        //Logic
        //Choose
        path.add(nums[index]);
        helper1(nums, index + 1, path);
        // backtracking
        path.remove(path.size() - 1);

        //Not Choose
        helper1(nums, index + 1, path);
    }

    /*
    Using for loop
        Time Complexity: O(n * 2^n)
        Space Complexity: O(n * 2^n)
    */
    List<List<Integer>> result2;
    public List<List<Integer>> subsets2(int[] nums) {
        result2  = new ArrayList<>();
        if(nums == null || nums.length == 0) return result2;
        helper2(nums, 0, new ArrayList<Integer>());
        return result2;
    }
    private void helper2(int[] nums, int index, List<Integer> path) {
        // Base

        //Logic
        result2.add(path);
        for(int i = index ; i < nums.length ; i++) {
            List<Integer> copy = new ArrayList<>(path);
            copy.add(nums[i]);
            helper2(nums, i + 1, copy);
        }
    }

    /*
    Using for loop & Backtracking
        Time Complexity: O(n * 2^n)
        Space Complexity: O(n * 2^n)
    */
    List<List<Integer>> result3;
    public List<List<Integer>> subsets3(int[] nums) {
        result3  = new ArrayList<>();
        if(nums == null || nums.length == 0) return result3;
        helper3(nums, 0, new ArrayList<Integer>());
        return result3;
    }
    private void helper3(int[] nums, int index, List<Integer> path) {
        // Base

        //Logic
        result3.add(new ArrayList<>(path));
        for(int i = index ; i < nums.length ; i++) {
            //Action
            path.add(nums[i]);
            //recurse
            helper3(nums, i + 1, path);
            //backtracking
            path.remove(path.size() - 1);
        }
    }

    /*
    Iterative Approch
        Time Complexity: O(n * 2^n)
        Space Complexity: O(n * 2^n)
    */
    List<List<Integer>> result4;
    public List<List<Integer>> subsets4(int[] nums) {
        result4  = new ArrayList<>();
        if(nums == null || nums.length == 0) return result4;
        result4.add(new ArrayList<>());
        for(int n : nums) {
            int size = result4.size();
            for(int i = 0 ; i < size ; i++) {
                List<Integer> temp = new ArrayList<>(result4.get(i));
                temp.add(n);
                result4.add(temp);
            }
        }
        return result4;
    }

    public static void main(String[] args) {

    }
}