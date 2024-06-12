/* 
We take 0-1 Recursion approach - Creating deep copies - copying all data to new copies takes N time
TC- O( N * 2^N), SC - O(N)

When we do not create deep copes - remove num from list 
TC - O( N*2^N) SC - O(N);


For loop based recursion: TC - O( N*2^N) SC - O(N);
*/
class Solution {
    List<List<Integer>> result ;
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        //helper(nums,0, new ArrayList<>());
        //helper1(nums, 0, new ArrayList<>());
        helper3(nums, 0, new ArrayList<>());
       

        return result;
    }
//0/1 recursion with deep copies
    private void helper(int[] nums, int i , List<Integer> path){

        // base
        if( i == nums.length){
            result.add(path);
            return;
        }
        // logic
        // dont choose
        helper(nums,i+1,new ArrayList<>(path));

        //choose
        path.add(nums[i]);
        helper(nums,i+1,new ArrayList<>(path));
    }

    // 0/1 recuesion with backtracking
    private void helper1(int[] nums, int i , List<Integer> path){

        // base
        if( i == nums.length){
            System.out.println(path);
            result.add(new ArrayList<>(path));
            return;
        }

        // logic
        //choose

        //action
        path.add(nums[i]);

        //recurse
        helper1(nums,i+1,path);

        // backtrack
        path.remove(path.size()-1);

        // dont choose
        helper1(nums,i+1,path);

    }

    // for loop based recusion
    private void helper3(int[] nums, int pivot, ArrayList<Integer> path){
        // base
        result.add(path);

        //logic
        for(int i=pivot;i<nums.length;i++){
            ArrayList<Integer> li = new ArrayList<>(path);
            li.add(nums[i]);
            helper3(nums, i+1,li);
        }
    }
}
