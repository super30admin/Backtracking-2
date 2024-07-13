class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        helper(candidates, target, 0, new ArrayList<>() ,result );
        return result;
    }

    private void helper(int[] candidates, int target, int idx, List<Integer> path, List<List<Integer>> result)
    {
        //base case
        if(target == 0)
        {
            result.add(new ArrayList<>(path));
            return;
        }

        if(target < 0 || idx == candidates.length) return;
        //no choose
        helper(candidates, target, idx + 1, path, result);

        //action
        path.add(candidates[idx]);

        //recurse
        helper(candidates, target - candidates[idx], idx, path, result);

        //backtrack
        path.remove(path.size()-1);
    }
}
