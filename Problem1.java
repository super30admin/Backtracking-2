
// Time - O(N * 2^N)
// Space - O(N)

// Jaspreet's solution

class Solution {

    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {

        result = new ArrayList<>();

        backTrack(nums, 0, new ArrayList<>());
        return result;


    }

    private void backTrack(int[] nums, int index, List<Integer> path) {

        // base case


        // logic
        // at every end of the node will be adding subset to the main result
        result.add(new ArrayList<>(path));

        for(int i = index; i < nums.length; i++) {

            // action

            path.add(nums[i]);

            //recurse

            backTrack(nums,i+1,path);

            //backtrack

            path.remove(path.size() - 1);


        }


    }
}




class Solution {

    List<List<Integer>> result;
    int n, k;
    public List<List<Integer>> subsets(int[] nums) {

        result = new ArrayList<>();
        n = nums.length;
        for(k = 0; k < n + 1; k++) {
            backtrack(0,nums,new ArrayList<>());
        }

        return result;


    }


    private void backtrack(int first, int[] nums, List<Integer> path) {

        // base
        if(path.size() == k) {
            System.out.println(k);
            result.add(new ArrayList<>(path));
            return;

        }

        //logic

        for(int i = first; i < nums.length; i++) {
            // action
            path.add(nums[i]);

            //recurse

            backtrack(i+1,nums,path);

            //backtrack

            path.remove(path.size() - 1);


        }


    }


}