
// Time Complexity : O(n * 2^n) since we are running the for loop for n times 2^n possibilities(exploring each node)
// Space Complexity :  O(n * Math.pow(2,n)) number of solutions of subsets multiplied by the total number of possibilities or choices we have to make
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach

//  this is classic backtracking 
// three things to rememeber for backtracking return type void ... add to path, recursively do the path and then remove from path(pooping out from stack).. for loop from the current postion to the end
// here we have helper which asks for parameters(data,progression,output)
// where data is nums, progression is idx and current output is pathSoFar
// here we just add the number and the for i = the next num to end we do it recursively in a for loop
// but in these for loop pathSoFar is updated and the it recursively calls next i.e i+1
// but since we are returning from the next iteration we have to roll back the updated path
// (since this will be needed to pass again say after finsihin iteration with left child now we want to explore right child )

class Solution {
    public List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {

        helper(nums, 0, new ArrayList<>());
        return res;
    }

    public void helper(int[] nums, int idx, List<Integer> pathSoFar) {
        res.add(new ArrayList(pathSoFar));

        for (int i = idx; i < nums.length; i++) {
            pathSoFar.add(nums[i]);
            helper(nums, i + 1, pathSoFar);

            pathSoFar.remove(pathSoFar.size() - 1);
        }

    }
}