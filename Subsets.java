//Time Complexity: O(2^n)
//Space Complexity: O(2^n)

/*
 * In this approach we can do it with a for loop in recursion. At each iteration we will get a subset. We then run a for loop from pivot to end of array length. We create a deep copy of path to avoid using same reference.
 * We add the current element in the path and we recurse on all the children with increasing the index.
*/
//for loop based recursion
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        if(nums == null || nums.length == 0) return result;
        helper(nums,0,new ArrayList<>());
        return result;
    }
    private void helper(int[] nums, int index, List<Integer> path){
        //base
        result.add(new ArrayList<>(path));
        //logic
        for(int i = index; i<nums.length;i++){
            // List<Integer> li = new ArrayList<>(path);
            // li.add(nums[i]);
            path.add(nums[i]);
            helper(nums,i+1,path);
            path.remove(path.size()-1);
        }
    }
}
//Time Complexity: O(n*2^n)
//Space Complexity: O(n*2^n)
//without recursion - in this approach we add a new list to result first and then we do nested loop, then we get the list at that point. We create a deep copy
//we add the nums at that index to the copy. We then add it to the result.
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        if(nums == null || nums.length == 0) return result;
        result.add(new ArrayList<>());
        for(int i =0;i<nums.length;i++){
            int size = result.size();
            for(int j=0;j<size;j++){
                List<Integer> li = new ArrayList<>(result.get(j));
                li.add(nums[i]);
                result.add(li);
            }
        }
        return result;
    }
    
}

//0-1 recursion - backtrack
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        if(nums == null || nums.length == 0) return result;
        helper(nums,0,new ArrayList<>());
        return result;
    }
    private void helper(int[] nums, int index, List<Integer> path){
        //base
        if(index == nums.length){
            result.add(new ArrayList<>(path));
            return;
        }
        //logic
        //not choose
        helper(nums,index+1, path);
        //choose
        //action
        path.add(nums[index]);
        //recurse
        helper(nums,index+1,path);
        //backtrack
        path.remove(path.size()-1);
    }
}