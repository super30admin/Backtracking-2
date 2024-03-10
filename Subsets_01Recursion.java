package week6.day2;
//Tc - O(2^ n)
//SC - O(n)
import java.util.ArrayList;
import java.util.List;

public class Subsets_01Recursion {
	    List<List<Integer>> result;
	    List<Integer> path;
	    public List<List<Integer>> subsets(int[] nums) {
	        result = new ArrayList<>();
	        path = new ArrayList<>();
	        helper(nums, path, 0);
	        return result;
	    }
	    private void helper(int[] candidates, List<Integer> path, int idx) {
	        //base
	        if(idx==candidates.length){
	            result.add(new ArrayList<>(path));
	            return;
	        }
	        //logic
	        //don't choose
	        helper(candidates, path, idx+1);
	        // choose
	        path.add(candidates[idx]);
	        helper(candidates, path, idx+1);
	        path.remove(path.size()-1);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
