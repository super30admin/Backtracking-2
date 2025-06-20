//SOlved successfully on leetcode and faced no issues
//TC : O(2^n) SC = O(2^n)

class Solution {
    //without using recursion
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>>result = new ArrayList<>();
        //initially result has empty subset
        result.add(new ArrayList<>());

        for(int i = 0 ; i < nums.length ; i++){ //for loop at nums array
            int resultsize = result.size(); //because never run the for loop pon data structure u r mutating
            for(int j = 0 ; j < resultsize ; j++) { //for loop over result
                //we will create a deep copy of current result and add the current i
                List<Integer>deepcopy = new ArrayList<>(result.get(j));
                deepcopy.add(nums[i]);
                result.add(deepcopy);
            }
        }
        return result;
    }


    //for loop based recursion
    // public List<List<Integer>> subsets(int[] nums) {
    //     List<List<Integer>>result = new ArrayList<>();
    //     List<Integer>subset = new ArrayList<>();
    //     helper(nums , 0 , subset , result);
    //     return result;
    // }
    // private void helper(int[] nums , int currentindex ,List<Integer>subset , List<List<Integer>>result){
    //     result.add(new ArrayList<>(subset));  // Add current subset, empty or not
    //     //base
    //     if(currentindex == nums.length){
    //         return;
    //     }
     
    //    //logic
    //     for(int i = currentindex ; i < nums.length ; i++){
    //         subset.add(nums[i]);
    //         helper(nums , i+1 , subset , result);
    //         subset.remove(subset.size()-1);

    //     }
    // }




    //0-1 based recursion
    // public List<List<Integer>> subsets(int[] nums) {
    //     List<List<Integer>>result = new ArrayList<>();
    //     List<Integer>subset = new ArrayList<>();
    //     helper(nums , 0 , subset , result);
    //     return result;
    // }
    // private void helper(int[] nums , int currentindex ,List<Integer>subset , List<List<Integer>>result){
    //     //base
    //     if(currentindex > nums.length){
    //         return;
    //     }
    //     if(currentindex == nums.length){
    //         result.add(new ArrayList<>(subset));
    //         return;
    //     }


    //     //logic 
    //     //choose
    //     subset.add(nums[currentindex]);
    //     helper(nums , currentindex + 1 , subset , result);
    //     subset.remove(subset.size()-1);

    //     //not choose
    //     helper(nums , currentindex + 1 , subset , result);
    // }
}