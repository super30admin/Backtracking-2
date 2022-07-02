//Time Complexity=O(2^n)
//Space Complexity=O(n)
public class SubsetsAlternate {
    List<List<Integer>> result;

    public List<List<Integer>> subsets(int[] nums) {

        result=new ArrayList<>();
        helper(nums,0, new ArrayList<Integer>());

        return result;
    }

    private void helper(int[] nums,int index,List<Integer> path){
        //base

        result.add(new ArrayList<>(path));
        //logic
        for(int i=index;i<nums.length;i++){

            path.add(nums[i]);
            helper(nums,i+1,path);
            path.remove(path.size()-1);
        }

    }
}
