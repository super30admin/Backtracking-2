public class Problem1 {
    class Solution {
        //t.c -> exponential
        //s.c -> exponential + O(n)(recursive call)
        List<List<Integer>> result;
        public List<List<Integer>> subsets(int[] nums) {
            if(nums == null || nums.length ==0){
                return new ArrayList<>();
            }
            result = new ArrayList<>();
            backtrack(nums,0,new ArrayList<>());
            return result;
        }
        private void backtrack(int[] nums, int index, List<Integer> path){
            //base
            if(index == nums.length){
                result.add(new ArrayList<>(path));
                return;
            }

            //logic
            //0 case : donot pick
            backtrack(nums,index+1,path);

            //1 case : pick
            //action
            path.add(nums[index]);
            //recursion
            backtrack(nums,index+1,path);
            //backtrack
            path.remove(path.size()-1);

        }
    }
}
