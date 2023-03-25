// brute force 0-1 recursion
public class Subsets {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        int n = nums.length;
        if(nums==null || n<0) return result;
        helper(nums,0,new ArrayList<>());
        return result;
    }
    private void helper(int[] nums, int idx, List<Integer> path){
        // base case
        if(idx==nums.length){
            result.add(path);
            return;
        }
        // logic
        // not choose
        helper(nums, idx+1, new ArrayList<>(path));
        // choose
        path.add(nums[idx]);
        helper(nums,idx+1, new ArrayList<>(path));
    }
}

// TC - exponential

// backtracking 0-1 recursion
public class Subsets {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        int n = nums.length;
        if(nums==null || n<0) return result;
        helper(nums,0,new ArrayList<>());
        return result;
    }
    private void helper(int[] nums, int idx, List<Integer> path){
        // base case
        if(idx==nums.length){
            result.add(new ArrayList<>(path));
            return;
        }
        // logic
        // action
        path.add(nums[idx]);
        // recurse
        helper(nums,idx+1, path);
        // backtrack
        path.remove(path.size()-1);
        
        helper(nums,idx+1, path);
    }
}

// for loop based recursion - brute force
public class Subsets {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        int n = nums.length;
        if(nums==null || n<0) return result;
        helper(nums,0,new ArrayList<>());
        return result;
    }
    private void helper(int[] nums, int pivot, List<Integer> path){
       result.add(path);
        for(int i=pivot;i<nums.length;i++){
            List<Integer> temp = new ArrayList<>(path);
            temp.add(nums[i]);
            helper(nums,i+1,temp);
        }
    }
}


// for loop based recursion - backtracking
public class Subsets {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        int n = nums.length;
        if(nums==null || n<0) return result;
        helper(nums,0,new ArrayList<>());
        return result;
    }
    private void helper(int[] nums, int pivot, List<Integer> path){
       result.add(new ArrayList<>(path));
        for(int i=pivot;i<nums.length;i++){
            // action
            path.add(nums[i]);
            // recurse
            helper(nums,i+1,path);
            // backtrack
            path.remove(path.size()-1);
        }
    }
}


// without recursion
public class Subsets {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums){

        result = new ArrayList<>();

        //adding an empty ArrayList in the result
        result.add(new ArrayList<>());

        for(int i = 0 ; i < nums.length ; i++){
            int size = result.size();
            for(int j = 0 ; j < size ; j++){
                List<Integer> temp = new ArrayList<>(result.get(j));
                temp.add(nums[i]);
                result.add(temp);
            }
        }
        return result;
    }
}

// TC - O(2^n)