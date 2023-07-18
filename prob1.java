// Time Complexity : O(n^2)
// Space Complexity : O(n^2)
// Did this code successfully run on Leetcode : Yes


class Solution {
    static void subsequence(int i,int[] arr, List<Integer> lst, List<List<Integer>> res){
        if(res.contains(lst)) return;
        if(i==arr.length){
            res.add(new ArrayList<>(lst));
            return;
        }
        lst.add(arr[i]);
        subsequence(i+1, arr, lst, res);
        lst.remove(lst.size()-1);
        subsequence(i+1, arr, lst, res);
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        subsequence(0, nums, new ArrayList<>(), res);
        return res;
    }
}