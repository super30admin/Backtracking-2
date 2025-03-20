import java.util.*;

// Time Complexity: O(n*2^n)
// Space Complexity: O(n* 2^n) + O(n), stack space
// Brute force approch > keeping deep copy at every point
public class problem2 {
List<List<Integer>> res;
    public List<List<Integer>> subsets(int[] nums) {

        this.res= new ArrayList<>();
        helper(nums, new ArrayList<>(), 0);
        return res;
    }
    public void helper(int[] nums, ArrayList<Integer> path, int i)
    {
        //base case
        if (i==nums.length)
        {
            res.add(new ArrayList<>(path));
            return;
        }

        //logic
        // not choose

        helper(nums,new ArrayList<>(path), i+1);

        // choose
        path.add(nums[i]);
        helper(nums, new ArrayList<>(path), i+1);
    }

    // optimal approach > backtracking
    // Time complexity: O(2^n)
    // Space Complexity : O(n)
    List<List<Integer>> res1;
    public List<List<Integer>> subsets1(int[] nums) {

        this.res1= new ArrayList<>();
        helper1(nums, new ArrayList<>(), 0);
        return res1;
    }
    public void helper1(int[] nums, ArrayList<Integer> path, int i)
    {
        //base case
        if (i==nums.length)
        {
            res1.add(new ArrayList<>(path));
            return;
        }

        //logic
        // not choose

        helper(nums,path, i+1);

        // choose
        path.add(nums[i]);
        helper(nums, new ArrayList<>(path), i+1);
        path.remove(path.size()-1);
    }

    //Iteritive approach
    List<List<Integer>> res3;
    public List<List<Integer>> subsets2(int[] nums) {
        res3= new ArrayList<>();
        helper3(nums, 0, new ArrayList<>());
        return res;
    }
    private void helper3(int[] nums, int pivot, List<Integer> path)
    {
        // base case
        res.add(new ArrayList<>(path));

        if (pivot== nums.length)
        {
            return;
        }
        for (int i=pivot; i<nums.length;i++)
        {
            //action
            path.add(nums[i]);

            //recurse
            helper3(nums,i+1, path);

            //backtrack
            path.remove(path.size()-1);


        }

    }

}
