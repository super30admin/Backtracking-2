// Time Complexity : o(2^(n))*n where n is length of string as at eevry step we have two choices to choose or not
// Space Complexity : o(n)) length of recursive stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// start from index and perform choose and not choose and when index reaches end of array clone the list and add in result

    List<List<Integer>> res;

    public List<List<Integer>> subsets(int[] nums) {
        res = new ArrayList<>();
        dfs(nums,0,new ArrayList<>());
        return res;
    }

    public void dfs(int[] nums, int index, List<Integer> l){

        if(index == nums.length){
            res.add(new ArrayList<>(l));
            return;
        }

        dfs(nums,index+1,l);

        l.add(nums[index]);
        dfs(nums,index+1,l);
        l.remove(l.size()-1);

    }

/*************************************************************************************************************/

  List<List<Integer>> res;

   public List<List<Integer>> subsets(int[] nums) {
       res = new ArrayList<>();
       dfs(nums,0,new ArrayList<>());
       return res;
   }

   public void dfs(int[] nums, int index, List<Integer> l){

       res.add(new ArrayList<>(l));

       for(int i=index; i<nums.length; i++){
           l.add(nums[i]);
           dfs(nums, i+1, l);
           l.remove(l.size()-1);
       }

   }
}
