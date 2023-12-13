// Time Complexity: O(2^n) - n is the number of elements
// Space Complexity: O(h)  - h is the height of the recursive stack
// Recursive approach
class Solution {

    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        this.result = new ArrayList<>();

        recursion(nums, new ArrayList<>(), 0);
        return result;
    }

    private void recursion(int nums[], List<Integer> path, int i){

        // base
        if(i == nums.length){
            result.add(path);
            return;
        }


        // logic
        // don't choose
        recursion(nums, new ArrayList<>(path), i+1);

        // choose
        path.add(nums[i]);
        recursion(nums, new ArrayList<>(path), i+1);
    }
}


// Time Complexity: O(2^n) - n is the number of elements
// Space Complexity: O(h)  - h is the height of the recursive stack
// Backtracking Approach
class Solution {

    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        this.result = new ArrayList<>();

        recursion(nums, new ArrayList<>(), 0);
        return result;
    }

    private void recursion(int nums[], List<Integer> path, int i){

        // base
        if(i == nums.length){
            result.add(new ArrayList<>(path));
            return;
        }


        // logic
        // don't choose case
        recursion(nums, path, i+1);

        // choose case
        // action
        path.add(nums[i]);
        // recursion
        recursion(nums, path, i+1);
        // backtrack
        path.remove(path.size()-1);
    }
}


// Time Complexity: O(2^n) - n is the number of elements
// Space Complexity: O(h)  - h is the height of the recursive stack
// For loop recursion
class Solution {

    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        this.result = new ArrayList<>();

        recursion(nums, new ArrayList<>(), 0);
        return result;
    }

    private void recursion(int nums[], List<Integer> path, int pivot){

        result.add(new ArrayList<>(path));
        
        // logic
        for(int i=pivot; i< nums.length; i++){
            path.add(nums[i]);
            recursion(nums, path, i+1);
            path.remove(path.size() -1);
        }
    }
}


// Time Complexity: O(n * 2^n) - n is the number of elements
// Space Complexity: O(1) 
// For loop based solution without recursion
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());

        for(int i=0; i<nums.length; i++){
            int size = result.size();
            for(int j=0; j<size; j++){
                List<Integer> li = new ArrayList<>(result.get(j));
                li.add(nums[i]);
                result.add(li);
            }
        }
        return result;
    }
}

