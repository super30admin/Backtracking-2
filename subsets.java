//TC: O(N* 2^N)
//SC: O(N)
class Solution {
 
public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> list = new ArrayList<>();
    Arrays.sort(nums);
    backtrack(list, new ArrayList<>(), nums, 0);
    return list;
}

private void backtrack(List<List<Integer>> list , List<Integer> tempList, int [] nums, int start){
    list.add(new ArrayList<>(tempList));
    for(int i = start; i < nums.length; i++){
        tempList.add(nums[i]);
        backtrack(list, tempList, nums, i + 1);
        tempList.remove(tempList.size() - 1);
        }
    }
}

//Class :
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        if(nums==null || nums.length == 0)
            return output;
        backtracker(nums,0,new ArrayList<>());
        return output;
    }
    private List<List<Integer>> output = new ArrayList<>();
    private void backtracker(int[] nums, int index, List<Integer> path){
        if(index>  nums.length)
            return;
        
        output.add(new ArrayList<>(path));
                   for(int i= index;i<nums.length;i++){
                       path.add(nums[i]);
                       backtracker(nums,i+1,path);
                       path.remove(path.size()-1);
                   }
    }
}