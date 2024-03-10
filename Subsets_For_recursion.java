package week6.day2;

import java.util.ArrayList;
import java.util.List;

public class Subsets_For_recursion {
	List<List<Integer>> result;
    List<Integer> path;
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        path = new ArrayList<>();
        helper(nums, path, 0);
        return result;
    }
    private void helper(int[] candidates, List<Integer> path, int pivot) {
        //base

        //logic
        result.add(new ArrayList<>(path));
        for(int i = pivot;i<candidates.length;i++){
            path.add(candidates[i]);
            helper(candidates, path, i+1);
            path.remove(path.size()-1);
        }
    }
	public static void main(String[] args) {
		Subsets_For_recursion obj = new Subsets_For_recursion();
		int[] candidates = { 1,2,3};
		List<List<Integer>> result = obj.subsets(candidates);
		System.out.println("Result: " + result);

	}

}
