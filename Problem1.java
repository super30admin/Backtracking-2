// Time Complexity - O(n*2^n)
// Space Complexity - O(n)   or O(n*2^n) - With Output space
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        // backtrackI(nums,0,new ArrayList<>());
        // result.add(new ArrayList<>());

        backtrackII(nums,0,new ArrayList<>());
        return result;
    }

    private void backtrackI(int[] nums, int index,List<Integer> list){

        if(index >= nums.length){
            return;
        }
        // action
        list.add(nums[index]);
        // recursive
        backtrackI(nums,index+1, list);
        // add to result
        result.add(new ArrayList<>(list));
        // backtrack
        list.remove(list.size()-1);
        backtrackI(nums,index+1,list);
    }

    private void backtrackII(int[] nums, int index, List<Integer> list){
        result.add(new ArrayList<>(list));

        for(int i= index; i<nums.length;i++){
            // action
            list.add(nums[i]);
            // recursion
            backtrackII(nums,i+1,list);
            // backtrack
            list.remove(list.size()-1);
        }
    }
}