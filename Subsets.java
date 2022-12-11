import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Subsets {

    //https://leetcode.com/problems/subsets/
    /*
    * We need to find out all the combinations of the subsets, and we will exhaustive approach.
    * Recursively call the new loop with the increment of the index value.
    *Another method was to use as for loop based without any recursion.
    * */
//Time Complexity O(2^n) n = number of elements
//Space Complexity O(n) - elements stored in the path. O(h) - height of recursive tree.






    public static void main(String[] args) {
        int[] nums ={1,2,3};
        System.out.println(subsets(nums));
    }
    static List<List<Integer>> result;
    public static List<List<Integer>> subsets(int[] nums) {
        if(nums==null || nums.length==0) return Collections.emptyList();
        result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
           int size = result.size();
            for (int j = 0; j < size; j++) {
                List<Integer> path = new ArrayList<>();
                path.add(nums[i]);
                result.add(path);
            }

        }
        return result;

    }
//Backtracking For Loop Based solution

    /*
    static List<List<Integer>> result;
    public static List<List<Integer>> subsets(int[] nums) {
        if(nums==null || nums.length==0) return Collections.emptyList();
        result = new ArrayList<>();
        recurse(nums,0,new ArrayList<>());
        return result;

    }

    private static void recurse(int[] nums, int index, List<Integer> path) {

            result.add(new ArrayList<>(path));
        //logic
        for (int i = index; i <nums.length ; i++) {
            path.add(nums[i]);
            recurse(nums,i+1,path);
            path.remove(path.size()-1);

        }

    }*/
    //BackTracking using 01 loop
//    static List<List<Integer>> result;
//    public static List<List<Integer>> subsets(int[] nums) {
//        if(nums==null || nums.length==0) return Collections.emptyList();
//        result = new ArrayList<>();
//        recurse(nums,0,new ArrayList<>());
//        return result;
//
//    }
//
//    private static void recurse(int[] nums, int index, List<Integer> path) {
//        //base
//        if(index==nums.length){
//            result.add(new ArrayList<>(path));
//            return;
//        }
//        //logic
//        recurse(nums, index+1,(path));
//        path.add(nums[index]);
//        recurse(nums,index+1,(path));
//        path.remove(path.size()-1);
//
//    }


    /*
    static List<List<Integer>> result;
    public static List<List<Integer>> subsets(int[] nums) {
        if(nums==null || nums.length==0) return Collections.emptyList();
        result = new ArrayList<>();
        recurse(nums,0,new ArrayList<>());
        return result;

    }

    private static void recurse(int[] nums, int index, List<Integer> path) {
        //base
        if(index==nums.length){
            result.add(path);
            return;
        }
        //logic
        recurse(nums, index+1,new ArrayList<>(path));
        path.add(nums[index]);
        recurse(nums,index+1,new ArrayList<>(path));

    }*/
}
