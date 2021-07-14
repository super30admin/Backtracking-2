// Time cpmplexity - O(n)
//Space - O(1)
//ran on leetcode - yes

class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        backtrack(nums, new ArrayList<>(), 0);
        return res;
    }
    public void backtrack(int[] num, List<Integer> curr, int start){
        //add subsets to result
        res.add(new ArrayList<>(curr));
        //create subsets for each starting point
        for(int i=start; i<num.length; i++){
            curr.add(num[i]);
            backtrack(num, curr, i+1);
            // backtrack
            curr.remove(curr.size() - 1);
        }
    }
}