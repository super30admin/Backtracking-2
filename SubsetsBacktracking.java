//Time complexity: Exponential TC
//Space complexity: O(N)
import java.util.ArrayList;
import java.util.List;
class Subsets{
    public static void main(String[] args) {
        Solution2 s= new Solution2();
        s.subsets(new int[]{0,1,2,3,4});
    }
}
class Solution2 {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        helper(nums,0,new ArrayList<>());
        return result;
    }
    public void helper(int[] nums,int index,List<Integer> list)
    {
        result.add(new ArrayList<>(list));
        for(int i=index;i<nums.length;i++){
            list.add(nums[i]);
            helper(nums,i+1,list);
            list.remove(list.size()-1);
        }
    }

}