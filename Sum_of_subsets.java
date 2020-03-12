import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 */

/**
 * @author aupadhye
 *
 */

//Time complexity would be O(N X 2^N) to generate all subsets
//Space complexity would be O(N X 2^N) to keep all subsets
public class Sum_of_subsets {

	/**
	 * @param args
	 */
	  static List<List<Integer>> output = new ArrayList();
	  static int n;
	  static int k;

	  public static  void backtrack(int first, ArrayList<Integer> curr, int[] nums) {
	    // if the combination is done
	    if (curr.size() == k)
	      output.add(new ArrayList(curr));

	    for (int i = first; i < n; ++i) {
	      // add i into the current combination
	      curr.add(nums[i]);
	      // use next integers to complete the combination
	      backtrack(i + 1, curr, nums);
	      // backtrack
	      curr.remove(curr.size() - 1);
	    }
	  }

	  public static List<List<Integer>> subsets(int[] nums) {
	    int n = nums.length;
	    for (int k = 0; k < n + 1; ++k) {
	      backtrack(0, new ArrayList<Integer>(), nums);
	    }
	    return output;
	  }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] nums = new int[] {1,2,3};
		List<List<Integer>> result = subsets(nums);
		System.out.println(Arrays.asList(result));
		
	}

}
