//Time Complexity: O(n*2^n);
//Space complexity:O(n)
//Approach: we used backtracking solution
class Solution {
    List<List<Integer>> output = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        backtracking(nums,0,new ArrayList<>());
        return output;
    }
    
    public void backtracking(int[] nums,int index,List<Integer> path){
        if(index>nums.length){
            return;
        }
        output.add(new ArrayList<>(path));
        
        for(int i=index;i<nums.length;i++){
            path.add(nums[i]);
            backtracking(nums,i+1,path);
            path.remove(path.size()-1);
        }
    }
}
