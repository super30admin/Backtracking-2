//Time Complexity: 2^n

//Solution: Choose/NoChoose recursion backtracking

class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        this.result = new ArrayList<>();
        helper(nums, 0, new ArrayList<>());
        return result;
    }

    private void helper(int[] nums, int idx, List<Integer> path){
        //base
        if(idx == nums.length){
            result.add(new ArrayList<>(path));
            return;
        }

        //logic
        //no choose
        helper(nums, idx+1, path);

        //choose
        //action
        path.add(nums[idx]);
        helper(nums, idx+1, path);

        //backtrack
        path.remove(path.size()-1);

    }
}

//Solution: For loop based recursion backtracking

class Solution {
    private List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        this.result = new ArrayList<>();
        helper(nums, 0, new ArrayList<>());
        return result;
    }

    public void helper(int[] nums, int pivot, List<Integer> path){

        //base

        if(pivot > nums.length){
            return;
        }
        result.add(new ArrayList<>(path));

        //logic
        for(int i=pivot; i<nums.length; i++){
            //action
            path.add(nums[i]);

             //recurse
             helper(nums, i+1, path);

             //backtrack
             path.remove(path.size()-1);

        }
    }
}


//Solution: Without recursion
//Time Complexity: O(n*2^n)
//Space Complexity: O(n*2^n)

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());

        for(int i=0 ; i<nums.length; i++){
            int size = result.size();

            for(int j=0; j<size; j++){
                List<Integer> lis = new ArrayList<>(result.get(j));
                lis.add(nums[i]);
                result.add(lis);
            }
        }
        return result;
    }
}
