//Time Complexity=O(2^n)
//Space Complexity=O(n)
public class Subsets {

    List<List<Integer>> result;

    public List<List<Integer>> subsets(int[] nums) {

        result=new ArrayList<>();
        helper(nums,0, new ArrayList<Integer>());

        return result;
    }

    private void helper(int[] nums,int i,List<Integer> path){
        //base
        if(i==nums.length){
            result.add(path);
            return;
        }
        //logic
        helper(nums,i+1,new ArrayList<>(path));
        path.add(nums[i]);
        helper(nums,i+1,new ArrayList<>(path));

    }
}
