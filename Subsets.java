// Approach : Using Recursion with Backtrack (no deep copy during the recursion).
// Time : O(2^n)
// Space : O(n) // with backtracking will be just stack space
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        this.result = new ArrayList<>();
        if(nums == null || nums.length ==0) return result;
        helper(nums,0,new ArrayList<>());
        return result;
    }

    public void helper(int[] nums ,int i, List<Integer> path){
        // Base case
        if(i==nums.length){
            result.add(new ArrayList<>(path));
            return;
        }

        // logic
        // recursion
        helper(nums,i+1,path); // dont choose
        path.add(nums[i]);
        helper(nums,i+1,path); // choose
        // Backtracking
        path.remove(path.size()-1);
    }
}

// Approach : Using Recursion (choose case 1st) with Backtrack (no deep copy during the recursion).
// Time : O(2^n)
// Space : O(n) // with backtracking will be just stack space
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        this.result = new ArrayList<>();
        if(nums == null || nums.length ==0) return result;
        helper(nums,0,new ArrayList<>());
        return result;
    }

    public void helper(int[] nums ,int i, List<Integer> path){
        // Base case
        if(i==nums.length){
            result.add(new ArrayList<>(path));
            return;
        }

        // logic
        // recursion
        path.add(nums[i]);
        helper(nums,i+1,path); // choose
        // Backtracking
        path.remove(path.size()-1);
        
        helper(nums,i+1,path); // dont choose
    }
}

// Approach : Using Recursion without Backtracking.
// Time : n* O(2^n)
// Space : n*O(2^n) + O(n)
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        this.result = new ArrayList<>();
        if(nums == null || nums.length ==0) return result;
        helper(nums,0,new ArrayList<>());
        return result;
    }

    public void helper(int[] nums ,int i, List<Integer> path){
        // Base case
        if(i==nums.length){
            result.add(path);
            return;
        }

        // logic
        // recursion
        helper(nums,i+1,new ArrayList<>(path)); // dont choose
        path.add(nums[i]);
        helper(nums,i+1,new ArrayList<>(path)); // choose
    }
}

// Approach : Using Recursion (choose scenraio first and only deep copies) without Backtracking.
// Time : n* O(2^n)
// Space : n*O(2^n) + O(n)
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        this.result = new ArrayList<>();
        if(nums == null || nums.length ==0) return result;
        helper(nums,0,new ArrayList<>());
        return result;
    }

    public void helper(int[] nums ,int i, List<Integer> path){
        // Base case
        if(i==nums.length){
            result.add(path);
            return;
        }

        // logic
        // recursion
        List<Integer> temp = new ArrayList<>(path);
        temp.add(nums[i]);
        helper(nums,i+1,new ArrayList<>(temp)); // choose

        helper(nums,i+1,new ArrayList<>(path)); // dont choose
    }
}

// Approach : Using for loop based Recursion with Backtrack (no deep copy during the recursion).
// Time : O(2^n)
// Space : O(n) // with backtracking will be just stack space
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        this.result = new ArrayList<>();
        if(nums == null || nums.length ==0) return result;
        helper(nums,0,new ArrayList<>());
        return result;
    }

    public void helper(int[] nums ,int pivot,List<Integer> path){
        // Base case

        // logic
        result.add(new ArrayList<>(path)); // []
        for(int i=pivot;i<nums.length;i++){
            // Action
            path.add(nums[i]);
            // recurse
            helper(nums,i+1,path); // choose
            // Backtracking
            path.remove(path.size()-1);
        }
    }
}