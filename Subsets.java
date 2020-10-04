//TC: Adding elements to path + recursion : O(N * 2^N)
//SC: path length + recursion stack : O(N * 2^N)

/*
1. Keep a for loop to avoid duplicate entries.
2. Elements at index are added to path in each backtracking call. 
3. when the index reaches array length, the last element is remove. 
4. Thus, we get all combination subsets.
*/

import java.util.*;


public class Subsets{
    static List<List<Integer>> result = new ArrayList<>();

    public static List<List<Integer>> subset(int[] nums){
        
        bt(nums, 0, new ArrayList<>());
        return result;

    }

    private static void bt(int[] nums, int index, List<Integer> path){
        result.add(new ArrayList<>(path));

        for(int i = index; i < nums.length; i++){
            //add
            path.add(nums[i]);

            //recursion
            bt(nums, i + 1, path);

            //removal
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args){
        int[] nums = new int[]{4,5,6};
        System.out.println(subset(nums));
    }

}