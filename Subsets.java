//Time Complexity : O(2^n)
//Space Complexity : O(n)


import java.util.ArrayList;
import java.util.List;
public class Subsets{
    //recursion
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        if(nums ==  null || nums.length == 0)return result;
        recursion(nums,new ArrayList<>(),0);
        return result;
    }
    public void recursion(int[] nums, List<Integer> temp,int i){
        if(i == nums.length){
            result.add(temp);
            return;
        }
        
        recursion(nums,new ArrayList<>(temp),i+1);
        temp.add(nums[i]);
        recursion(nums,new ArrayList<>(temp),i+1);
    }
    //backtracking
    public List<List<Integer>> subsetsBt(int[] nums) {
        result = new ArrayList<>();
        if(nums ==  null || nums.length == 0)return result;
        backtrack(nums,new ArrayList<>(),0);
        return result;
    }
    public void backtrack(int[] nums, List<Integer> temp,int start){
        result.add(new ArrayList<>(temp));
        for(int i =  start;i < nums.length;i++){
            temp.add(nums[i]);
            backtrack(nums, temp, i+1);
            temp.remove(temp.size()-1);
        }
    }
    public static void main(String args[]){
        Subsets obj = new Subsets();
        System.out.println(obj.subsets(new int[]{1,2,3}));
        System.out.println(obj.subsetsBt(new int[]{1,2,3}));

    }
}