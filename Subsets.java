import java.util.ArrayList;
import java.util.List;

class Solution {
    List<List<Integer>> answer = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        helper(nums, 0, new ArrayList<Integer>());
        answer.add(new ArrayList<Integer>());
        return answer;
    }
    void helper(int[] nums, int i, List<Integer> curList) {
        int n = nums.length;
        // base
        if(i >= n) {
            return;
        }
        // backtracking solution
        // Don't include nums[i]
        helper(nums, i+1, curList);
        // Include nums[i]
        // 1. Action
        curList.add(nums[i]);
        answer.add(new ArrayList<Integer>(curList));
        // 2. Recurse
        helper(nums, i+1, curList);
        // 3. backtrack
        curList.remove(curList.size() - 1);
    }
}
class Solution2 {
    List<List<Integer>> answer = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        helper(nums, 0, new ArrayList<Integer>());
        return answer;
    }
    // for loop based recursion
    void helper(int[] nums, int pivot, List<Integer> path) {
        //base

        //logic
        answer.add(new ArrayList<>(path));
        for(int i=pivot; i<nums.length; i++) {
            //action
            path.add(nums[i]);
            //recurse
            helper(nums, i+1, path);
            //backtrack
            path.remove(path.size() - 1);
        }   
    }
}

// time - n*(2^n)
// space - O(n)


// not using recursion
class Solution3 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        answer.add(new ArrayList<>());
        for(int i=0; i<nums.length; i++) {
            int cur = nums[i];
            int size = answer.size();
            for(int j=0; j<size; j++) {
                List<Integer> newList = new ArrayList<>(answer.get(j));
                newList.add(cur);
                answer.add(newList);
            }
        }
        return answer;
    }
}
// time - O(n*2^n)
// space - O(2^n) // for result 