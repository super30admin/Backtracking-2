//TimeComplexity: O(2^n) -- n is no of elements
//TimeComplexity: O(2^n) -- n is no of elements ie we are storing 2 pow n times in lists.\\

// idea : for each iteration , add the element and make subset and add it to result.

// Run on the leet code : N

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(nums == null) return result;
        List<Integer> tempList = new ArrayList<>(); // this is used to store the temp list and add it to main list.
        findSubSets(nums,0, result, tempList);
        return result;
    }
    
    public void findSubSets(int[] nums, int index, List<List<Integer>> result,List<Integer> tempList){
        System.out.println(tempList);
        result.add(new ArrayList<Integer>(tempList)); // Added this new Arraylist.
        for(int i = index; i< nums.length;i++){
        // take the number
            tempList.add(nums[i]);
            findSubSets(nums,i+1,result,tempList);
            tempList.remove(tempList.size()-1);
        }
    
    }
}
