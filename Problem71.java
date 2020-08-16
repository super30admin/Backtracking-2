TC : O(2^N)
SC : O(N2^N)

//BACKTRACKING SOLUTION

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<>(), nums, 0);
        return list;
    }

    private void backtrack(List<List<Integer>> list , List<Integer> tempList, int [] nums, int start){
        list.add(new ArrayList<>(tempList));
        for(int i = start; i < nums.length; i++){
            tempList.add(nums[i]);
            backtrack(list, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }
}

//RECURSIVE SOLUTION

class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        if(nums == null || nums.length <1 ) return result;
        
        helper(nums, new ArrayList<>(), 0);
        return result;
    }
    
    private void helper(int[] nums, List<Integer> temp, int index){
        //Base Case
        if(index>=nums.length){
            result.add(temp);
            return;
        } 
        
        //Do Not Choose
        helper(nums, new ArrayList<>(temp), index+1);
        
        //Choosing
        temp.add(nums[index]);
        helper(nums, new ArrayList<>(temp), index+1);
    }
}