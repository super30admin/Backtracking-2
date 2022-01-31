
// Time Complexity : exponential
// Space Complexity : O(n)
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result=new ArrayList<>();
        if(nums==null || nums.length==0)
            return result;
        helper(nums,0,new ArrayList<>());
        return result;
    }
    private void helper(int nums[],int index,List<Integer>path){
        //base
        if(index==nums.length){
            result.add(new ArrayList<>(path));
            return;
        }
        //logic
        //not choose
        helper(nums, index+1, path);
        //choose
        // List<Integer> temp=new ArrayList<>(path);
        path.add(nums[index]);
        helper(nums,index+1,path);
        path.remove(path.size()-1);
    }
}



// Time Complexity : exponential
// Space Complexity : O(n)
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result=new ArrayList<>();
        if(nums==null || nums.length==0)
            return result;
        helper(nums,0,new ArrayList<>());
        return result;
    }
    private void helper(int nums[],int index,List<Integer>path){
        
        result.add(new ArrayList<>(path));
        for(int i=index;i<nums.length;i++){
            path.add(nums[i]);
            helper(nums,i+1,path);
            path.remove(path.size()-1 );
        }
    }
}


// Time Complexity : exponential
// Space Complexity : O(1)
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result= new ArrayList<>();
        result.add(new ArrayList());
        for(int i=0;i<nums.length;i++){
            int k=result.size();
            for(int j=0;j<k;j++){
                List<Integer> temp=new ArrayList<>(result.get(j));
                temp.add(nums[i]);
                result.add(temp);
            }
        }
        return result;
    }
}
