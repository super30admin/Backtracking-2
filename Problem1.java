//subset
import java.util.*;

//backtrack 
//tc - O(2^n)
//sc - O(n) recursion stack
//backtracking iterative

class Problem1{
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        Problem1 p = new Problem1();
        System.out.print(p.subsets(nums));

        
    }
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        if(nums == null || nums.length ==0){
            return res;
        }
        helper(nums,0, new ArrayList<>());
        return res;
    }
    public void helper(int[] nums, int index, List<Integer> path){
        //base
        if(index > nums.length){
            return;
        }
        //logic 
        res.add(new ArrayList<>(path));
        for(int i = index;i< nums.length; i++){
            path.add(nums[i]);
            // System.out.print(i);
            helper(nums, i+1,path);
            // System.out.println(path);
            path.remove(path.size()-1);
        }
        System.out.println();
    }
}