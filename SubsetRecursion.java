//Time complexity: Exponential TC
//Space complexity: O(N)
import java.util.ArrayList;
import java.util.List;

class Solution3
{
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result= new ArrayList<>();

        helper(nums,0,new ArrayList<>());
        return result;
    }
    public void helper(int[] nums, int index, List<Integer> list){
        //base case
        if(index>=nums.length){
            result.add(new ArrayList(list));
            return;
        }
        //dont choose
        helper(nums,index+1,new ArrayList(list));

        //choose
        list.add(nums[index]);
        helper(nums,index+1,new ArrayList(list));
        list.remove(list.size()-1);
    }
}