/Time Complexity: O(n* (2^n)) //each level we have 2 choice
//Space Complexity: O(n)
//runs successfully
//didn't face any problems


import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        backtrack(list, new ArrayList<>(), nums, 0);
        return list;
    }

    private void backtrack(List<List<Integer>> list , List<Integer> tempList, int [] nums, int start){
        list.add(new ArrayList<>(tempList)); //add to the result list

        System.out.println("function called : " + list+" start : "+start);
        for(int i = start; i < nums.length; i++){
            System.out.println("i :--> " + i);
            tempList.add(nums[i]);
            System.out.println("Resultant list: " + tempList);
            backtrack(list, tempList, nums, i + 1);
            System.out.println("templist " + tempList +" i : "+i);
            tempList.remove(tempList.size() - 1);
        }
    }
}


    //    public List<List<Integer>> subsets(int[] nums) {

//         List<List<Integer>> result = new ArrayList<>();
//         result.add(new ArrayList<>());


//         for(int num: nums){

//             List<List<Integer>> newSubset = new ArrayList<>();

//             for(List<Integer> ip : result){

//                 List<Integer> temp = new ArrayList<>(ip);
//                 temp.add(num);
//                 newSubset.add(temp);

//             }

//             for(List<Integer> curr: newSubset){

//                 result.add(curr);
//             }

//         }

//         return result;

//     }






//    private List<List<Integer>> result;
//     public List<List<Integer>> subsets(int[] nums) {

//         result = new ArrayList<>();
//         subset(nums, 0, new ArrayList<>());
//         return result;

//     }

//     private void subset(int[] nums, int index, List<Integer> list){

//         if(index == nums.length){
//             result.add(new ArrayList<>(list));
//             return;
//         }

//         subset(nums, nums.length, list);

//         for(int i=index; i<nums.length; i++){

//             list.add(nums[i]);
//             subset(nums, i+1, list);
//             list.remove(list.size()-1);
//         }

//     }



//Time Complexity: O(n* (2^n)) //each level we have 2 choice
//Space Complexity: O(n)

//     private List<List<Integer>> result;

//     public List<List<Integer>> subsets(int[] nums) {

//         result = new ArrayList<>();
//         subset(nums, 0, new ArrayList<>());
//         return result;

//     }

//     private void subset(int[] nums, int index, List<Integer> list){

//         //base
//         if(index== nums.length){
//             result.add(new ArrayList<>(list));
//             return;
//         }

//         //recurse
//         //choose
//         list.add(nums[index]);
//         subset(nums, index+1, list);
//         list.remove(list.size()-1);


//         //notChoose
//         subset(nums, index+1, list);

//     }
}