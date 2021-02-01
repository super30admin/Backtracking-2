class Solution {
    public List<List<Integer>> subsets(int[] nums) {

        backtracking(new ArrayList<>(), nums,0);

        return answer;
    }

    List<List<Integer>> answer = new ArrayList<>();

    private void backtracking(List<Integer> path, int[] nums, int index){

        answer.add(new ArrayList<>(path));

        for(int i=index;i<nums.length;i++){
            // add
            path.add(nums[i]);

            // backtrack
            backtracking(path,nums,i+1);

            // remove
            path.remove(path.size()-1);
        }
    }
}