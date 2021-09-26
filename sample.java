
//o(2^n) time and o(h) space for recursion
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        if(nums == null || nums.length == 0) return result;

        helper(nums, 0, new ArrayList<>());
        return result;
    }
    private void helper(int[] nums, int index, List<Integer> path){
        //base

        result.add(new ArrayList<>(path));

        //logic
        for(int i = index; i < nums.length; i++){
            path.add(nums[i]);
            helper(nums, i +1, path);
            path.remove(path.size()-1);

        }

    }
}

//o(2^n) time

class Solution {

    List<List<String>> result;
    public List<List<String>> partition(String s) {
        result = new ArrayList<>();
        helper(s, 0, new ArrayList<>());
        return result;
    }

    private boolean isPalindrome(String s, int i, int j){

        while(i < j){
            if(s.charAt(i)!= s.charAt(j)) return false;
            i++;j--;
        }
        return true;

    }

    private void helper(String s, int index, List<String> path){

        //base

        if(index == s.length()) {
            result.add(new ArrayList<>(path));
        }

        //logic
        for(int i = index; i < s.length(); i++){
            if(isPalindrome(s, index, i)){
                //action
                path.add(s.substring(index, i+1));
                //recurse
                helper(s, i+1, path);
                //backtrack
                path.remove(path.size() - 1);
            }
        }
    }


}