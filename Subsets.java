import java.util.*;

public class Subsets {
        /*

        TC: O(n * 2^n)
        SC: O(n)

        */
        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> res=new LinkedList<>();
            List<Integer> sub=new LinkedList<>();
            backtrack(nums,0,sub,res);
            return res;
        }

        public void backtrack(int[] nums,int indx,List<Integer> sub,List<List<Integer>> res){
            res.add(new LinkedList<>(sub));
            for(int i=indx;i<nums.length;i++){
                sub.add(nums[i]);
                backtrack(nums,i+1,sub,res);
                sub.remove(sub.size()-1);
            }
        }
}
