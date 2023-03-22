class Solution {
	//Time: O(n * 2^n); At every point of the string we make 2 choices and we also copy the string to the output for which we have to go over the string.
	//Space: O(n)
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result = new LinkedList<>();
        dfs(0, nums, new LinkedList<>());
        result.add(new LinkedList());
        return result;
    }

    public void dfs(int index, int[] nums, List<Integer> indi){

        //I will go with the pick not pick approach. 

        //basee cases

        if(index == nums.length){
            return;
        }

        

        //pick

        indi.add(nums[index]);

        dfs(index + 1, nums, indi);
        result.add(new LinkedList(indi));

        //not pick

        indi.remove(indi.size() - 1);

        dfs(index + 1, nums, indi);
        //result.add(new LinkedList(indi));
        //result.add(indi);


    }
}