TC:O(2^n)
SC:O(n)

Runtime: 0 ms, faster than 100.00% of Java online submissions for Subsets.
Memory Usage: 37.3 MB, less than 99.18% of Java online submissions for Subsets.

Approach : for loop takes care of taking each element and recursion will take care of which index from which for loop has to start.



class Solution {
    List<List<Integer>>  list ;
    public List<List<Integer>> subsets(int[] nums) {
        list = new ArrayList<>();
        List<Integer> sublist = new ArrayList<>();
        helper(nums,0, sublist);
        return list ;
    }
    public void helper(int [] nums,int start,List <Integer> sublist){
    
    list.add(new ArrayList<>(sublist)) ;
    for(int i= start; i< nums.length; i++){
        sublist.add(nums[i]);
        helper(nums,i+1,sublist);
        sublist.remove(sublist.size()-1);  
    }
    
    }
}
