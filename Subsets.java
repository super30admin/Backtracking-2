import java.util.ArrayList;
import java.util.List;


/*
TC : It will be exponential O(N^k) where N is the length of the given array
SC : It will also be exponential of the same order as above
LC(LeetCode): yes
Problems : No
 */
public class Subsets {

    public List<List<Integer>> list = new ArrayList();

    public List<List<Integer>> subsets(int[] nums) {

        list.add(new ArrayList());
        helper_using_backtracking(nums, 0, new ArrayList());
        return list;
    }


    /**
     * The approach taken is simple. Initially we have the option of choosing the numbers of the elements one by one.
     * At every stage, we again choose all the remaining elements one by one.
     * In recursion, we make a deepCopy of the list and hence we dont need to remove the element from the list(backtracking)
     *
     * @param nums
     * @param index
     * @param path
     */
    public void helper_using_recursion(int[] nums, int index, List<Integer> path) {

        if (index == nums.length) {
            return;
        }

        for (int i = index; i < nums.length; i++) {
            List<Integer> deepCopy = new ArrayList(path);
            deepCopy.add(nums[i]);
            list.add(deepCopy);
            helper_using_recursion(nums, i + 1, deepCopy);

        }
    }

    /**
     * The approach taken is simple. Initially we have the option of choosing the numbers of the elements one by one.
     * At every stage, we again choose all the remaining elements one by one.
     * Here, we dont create a deepcopy, but we backtrack and remove the element from the list everytime.
     * While adding the list to the final list, we create a new copy to avoid overwriting.
     *
     * @param nums
     * @param index
     * @param path
     */
    public void helper_using_backtracking(int[] nums, int index, List<Integer> path) {

        if (index == nums.length) {
            return;
        }

        for (int i = index; i < nums.length; i++) {

            path.add(nums[i]);
            list.add(new ArrayList(path));
            helper_using_backtracking(nums, i + 1, path);
            path.remove(path.size() - 1);

        }
    }
}
