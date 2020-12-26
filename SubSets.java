/* Time Complexity : Exponential
Space Complexity : O(N)
Idea : You add every set that is created in each call to the function. The list accomadates first all
values starting with 1, then starting with 2 then starting with 3 for list [1,2,3]
*/
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(nums,new ArrayList<Integer>(),0,ans);
        return ans;
    }
    
    public void helper(int[] nums,List<Integer> set,int index,List<List<Integer>> ans){
        ans.add(new ArrayList<>(set));
        for(int i=index;i<nums.length;i++){
            set.add(nums[i]);
            helper(nums,set,i+1,ans);
            set.remove(set.size()-1);
        }
    }
}