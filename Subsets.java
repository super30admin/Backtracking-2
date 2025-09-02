import java.util.ArrayList;
import java.util.List;

// Idea is to use an exhaustive approach to generate all possible subsets by using choose&no-choose recursion
// To optimize on space we backtrack the path formed 

//Time Complexity: O(n*2^(n)); 
//Space Complexity: O(n)
public class Subsets {
        private List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        result.add(new ArrayList<Integer>());
        helper(nums,0, new ArrayList<>());
        return result;
    }

    public void helper(int[] nums, int index, List<Integer> path)
    {
        if(index==nums.length) return;
        //No Choose
        helper(nums,index+1,path);

        path.add(nums[index]);
        result.add(new ArrayList<>(path));
        helper(nums,index+1,path);

        path.remove(path.size()-1);

    }   

}
