// Time Complexity : O(2^n) all the subsets of the n elements
// Space Complexity : O(n) n:Max elements added to path list at a time which is all of n elements
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Basic backtracking for finding all of the possible subsets (power set) of given elements
// create a path list for keeping a track of the elements traversing and pass it as parameters to the recur method along with the index
// In recursion, iterate from that index (initially 0) till the input lenth, finding all possibilities of the combinations with the input elements.
// while calling the next recur, increment the index to find the subsets of that index and go one.
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> output = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        recur(nums,0,output,path);
        return output;
    }
    private void recur(int[] nums, int index, List<List<Integer>> output, List<Integer> path){
        if(index>nums.length){
            return;
        }
        output.add(new ArrayList<>(path));

        for(int i=index; i<nums.length;i++){
            path.add(nums[i]);
            recur(nums,i+1,output,path);
            path.remove(path.size()-1);
        }
    }
}