//Time Complexity O(2^N*N)
//Space Complexity O(N)
//LeetCode tested

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        generateSubsets(0,nums,new ArrayList<>(),subsets);
        return subsets;
    }
    public static void generateSubsets(int index,int[] nums,List<Integer> current,List<List<Integer>> subsets){
        subsets.add(new ArrayList<>(current));
        for(int i=0;i<current.size();i++) System.out.print(current.get(i)+"   ");
        System.out.println();
        for (int i = index; i < nums.length; i++) {
            current.add(nums[i]);
            generateSubsets(i+1,nums,current,subsets);
            current.remove(current.size()-1);
        }
    }
}
