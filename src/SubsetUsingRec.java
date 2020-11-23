import java.util.ArrayList;
import java.util.List;

public class SubsetUsingRec {
	
	List<List<Integer>> result = new ArrayList<>();

	public List<List<Integer>> subsets(int[] nums) {

		if (nums.length == 0 || nums == null) {
			return result;
		}

		helper(nums, 0, new ArrayList<Integer>());

		return result;
	}

	private void helper(int[] nums, int index, List<Integer> temp) {

		// base
		if (index == nums.length) {
			result.add(temp);

			return;
		}

		// dont choose
		helper(nums, index + 1, new ArrayList<>(temp));

		// choose
		temp.add(nums[index]);
		helper(nums, index + 1, new ArrayList<>(temp));

	}

}
