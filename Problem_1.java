// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Three line explanation of solution in plain english

// Your code here along with comments explaining your approach

class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result=new ArrayList<>();
        helper(nums,0,new ArrayList<Integer>());
        return result;
    }
    
    public void helper(int[] nums,int index,List<Integer> path){
        //base condition
        if(index>=nums.length){
            result.add(new ArrayList<>(path));
            return;
        }
        //action
        //choose
        List<Integer> newPath=new ArrayList<>(path);
        newPath.add(nums[index]);
        helper(nums,index+1,newPath);
        //not choose
        helper(nums,index+1,new ArrayList<>(path));
        
    }
}

//using the backtracking
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result=new ArrayList<>();
        helper(nums,0,new ArrayList<Integer>());
        return result;
    }
    
    public void helper(int[] nums,int index,List<Integer> path){
        //base condition
        if(index>=nums.length){
            result.add(new ArrayList<>(path));
            return;
        }
        //action
        //choose
        path.add(nums[index]);
        helper(nums,index+1,path);
        path.remove(path.size()-1);
        //not choose
        helper(nums,index+1,new ArrayList<>(path));
        
    }
}










