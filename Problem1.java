import java.util.*;

class Solution {
    List<List<Integer>> result ;
    public List<List<Integer>> subsets(int[] nums) {
        this.result = new ArrayList<>();
        // recur(nums,0,new ArrayList<Integer>());
        helperForLooped(nums);
        return result;
    }

    //TC: 2^n
    //SC : O(n) where n is the height of the 0/1 resursive tree
    public void recur(int[] nums,int pivot , List<Integer> path) {
        result.add(new ArrayList<>(path));
        for(int i=pivot;i<nums.length;i++){
            path.add(nums[i]);
            recur(nums,i+1,path);
            path.remove(path.size()-1);
        }
    }

    //TC: 2^n
    //SC : O(n) where n is the height of the 0/1 resursive tree
    public void helperForLooped(int[] nums) {
        this.result.add(new ArrayList<>());
        for(int i=0;i<nums.length;i++){
            int size = this.result.size();
            for(int j=0;j<size;j++){

                List<Integer> preResult = new ArrayList<>(result.get(j));
                preResult.add(nums[i]);
                result.add(preResult);

            }


        }
    }

}