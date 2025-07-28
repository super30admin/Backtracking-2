/**** Method 1 ****/
//Time Complexity: O(2^n)
//Space Complexity: O(n)

//Successfully submitted in LeetCode

// So this is pick not pick recursive method, at each index of the array we have two choices either to pick or not pick, if we choose to pick we add to the list and while coming back we remove it from it list as backtracking so go to not pick method. So if we reach the last index then it implies we have found a ans, so we create a new copy of arraylist and add to our list of lists ans and continue with next recursive calls. At very end we return the ans list.

/**** Method 2 ****/
//Time Complexity: O(2^n)
//Space Complexity: O(n)

//Successfully submitted in LeetCode

// So this is for loop recursive method, at start we have n choices to choose from so we start with first index and from there we have option to choose the next index, so we choose to element and add to the list and while coming back we remove it from it list as backtracking. So if we reach the last index then it implies we have found a ans, so we create a new copy of arraylist and add to our list of lists ans and continue with next recursive calls. At very end we return the ans list.

import java.util.ArrayList;
import java.util.List;

public class _78_Subsets {

  public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> ans = new ArrayList<>();

    powerSet1(0, nums, new ArrayList<>(), ans);

    return ans;
  }

  /**** Method 1 ****/
  public void powerSet(
    int i,
    int nums[],
    List<Integer> list,
    List<List<Integer>> ans
  ) {
    if (i == nums.length) {
      ans.add(new ArrayList<>(list));
      return;
    }

    list.add(nums[i]);
    powerSet(i + 1, nums, list, ans);
    list.remove(list.size() - 1);
    powerSet(i + 1, nums, list, ans);
  }

  /**** Method 2 ****/
  public void powerSet1(
    int idx,
    int nums[],
    List<Integer> list,
    List<List<Integer>> ans
  ) {
    ans.add(new ArrayList<>(list));

    for (int i = idx; i < nums.length; i++) {
      list.add(nums[i]);
      powerSet(i + 1, nums, list, ans);
      list.remove(list.size() - 1);
    }
  }
}
