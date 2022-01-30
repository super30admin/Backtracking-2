// Time Complexity : O(n * 2^n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        res.add(new ArrayList<>());

        for(int i = 0; i < nums.length; i++) {
            int size = res.size();
            for(int k = 0; k < size; k++) {
                List<Integer> list = new ArrayList<>(res.get(k));
                list.add(nums[i]);
                res.add(list);
            }

        }

        return res;
    }
}

// Time Complexity : O(2^n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Approach 2 - for loop recursion with backtracking
class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> subsets(int[] nums) {
        res = new ArrayList<>();
        helper(nums, 0, new ArrayList<>());
        res.add(new ArrayList<>());
        return res;
    }


    public void helper(int[] nums, int index, List<Integer> path) {
        if(index == nums.length) {
            return;
        }

        for(int i = index; i < nums.length; i++) {
            path.add(nums[i]);
            res.add(new ArrayList<>(path));
            helper(nums, i+1, path);
            path.remove(path.size()-1);
        }
    }
}

// Time Complexity : O(n * 2^n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Approach 3 - for loop recursion no backtracking
class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> subsets(int[] nums) {
        res = new ArrayList<>();
        helper(nums, 0, new ArrayList<>());
        res.add(new ArrayList<>());
        return res;
    }


    public void helper(int[] nums, int index, List<Integer> path) {
        if(index == nums.length) {
            return;
        }

        for(int i = index; i < nums.length; i++) {
            List<Integer> temp = new ArrayList<>(path);
            temp.add(nums[i]);
            res.add(new ArrayList<>(temp));
            helper(nums, i+1, temp);
        }
    }
}

// Time Complexity : O(2^n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Approach 4 - choose/not choose with backtracking
class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> subsets(int[] nums) {
        res = new ArrayList<>();
        helper(nums, 0, new ArrayList<>());
        return res;
    }

    public void helper(int[] nums, int index, List<Integer> path) {
        if(index == nums.length){
            res.add(new ArrayList<>(path));
            return;
        }

        //not choose
        helper(nums, index+1, path);

        //choose
        path.add(nums[index]);
        helper(nums, index+1, path);
        path.remove(path.size()-1);
    }

}


// Time Complexity : O(n * 2^n) , n because we are copying list
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Approach 5 - choose/not choose without backtracking
class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> subsets(int[] nums) {
        res = new ArrayList<>();
        helper(nums, 0, new ArrayList<>());
        return res;
    }

    public void helper(int[] nums, int index, List<Integer> path) {
        if(index == nums.length){
            res.add(path);
            return;
        }

        //not choose
        helper(nums, index+1, path);

        //choose
        List<Integer> temp = new ArrayList<>(path);
        temp.add(nums[index]);
        helper(nums, index+1, temp);
    }

}