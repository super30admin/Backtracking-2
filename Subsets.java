
//Time: O(2^N) | Space: O(N)

//Iterative solution
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        for(int i=0;i<nums.length;i++) { //O(N)
            int size = result.size();
            for(int j=0;j<size;j++) { //O(2^N)
                List<Integer> temp = new ArrayList<>(result.get(j));
                temp.add(nums[i]);
                result.add(temp);
            }
        }
        return result;
    }
}

// For-Loop based recursion - Time: O(2^N) | Space: O(N) for recursive stack - O(N) for maintaining path
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        helper(nums, 0, new ArrayList<>());
        return result;
    }
    private void helper(int[] nums, int pivot, List<Integer> path) {
        result.add(new ArrayList<>(path));
        for(int i=pivot;i<nums.length;i++) {
            path.add(nums[i]);
            helper(nums, i+1, path);
            path.remove(path.size()-1);
        }
    }
}


// choose not choose recursion O(2^N) | Space: O(N)
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        helper(nums, 0, new ArrayList<>());
        return result;
    }
    private void helper(int[] nums, int idx, List<Integer> path) {
        if(idx == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }
        helper(nums, idx+1, path);
        path.add(nums[idx]);
        helper(nums, idx+1, path);
        path.remove(path.size()-1);
    }
}
