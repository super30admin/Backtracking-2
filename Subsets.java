// Time Complexity : O(2 pow n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : -

//DFS with backtracking to find all the subsets of the given tree
import java.util.ArrayList;
import java.util.List;

class Subsets {
    List<List<Integer>> res;
    public List<List<Integer>> subsets(int[] nums) {
        res = new ArrayList();

        helper(nums, 0, new ArrayList());

        return res;
    }

    private void helper(int[] ip, int i, List<Integer> path){
        //base
        if(i == ip.length) {
            res.add(new ArrayList(path));
            return;
        }
        //logic
        //don't choose
        helper(ip,i+1, path);

        //choose
        path.add(ip[i]);
        helper(ip, i+1, path);
        path.remove(path.size() - 1);
    }
}
