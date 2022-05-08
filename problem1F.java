import java.util.ArrayList;

class subset1{
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        if(nums == null || nums.length == 0) return result;

        helper(nums, 0, new ArrayList<>());
        return result;
        
    }

    private void helper(int[] nums, int index, ArrayList path){
        
        result.add(new ArrayList<>(path));
        for(int i = index; i < nums.length; i++){
            path.add(nums[i]);
            helper(nums, i + 1, path);
            path.remove(path.size() - 1);
        }
    }
}
//time complexity O(2^n)
//space complexity O(n)