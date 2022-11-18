package s30.backTracking.b2;

import java.util.ArrayList;
import java.util.List;

//Algo
// run dfs for all the indices
// Add to the res list for every recurse call

// TC : O(2^n) iterate through all the subsets
// SC: O(n) max height would be n, for the biggest subset
public class subsets {



    private List<List<Integer>> result;
    private List<Integer> currList;
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList();
        currList = new ArrayList();

        result.add(new ArrayList());

        subsets(nums,0);

        return result;
    }


    private void subsets(int[] nums, int index){

        //base
        if(index == nums.length) return;


        for(int i = index; i < nums.length; i++){

            //op
            currList.add(nums[i]);
            result.add(new ArrayList(currList));

            //recurse
            subsets(nums, i + 1);

            //backTrack
            currList.remove(currList.size()-1);

        }

    }
    public static void main(String[] args) {

    }
}
