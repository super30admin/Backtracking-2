
/**
 * @param {number[]} nums
 * @return {number[][]}
 */

 //Solution using 0/1 recursion 
// var subsets = function(nums) {
//     let result = [];

//     const subsetsHelper = (nums, index, path, result) => {

//         //base logic
//         if(index === nums.length){
//             result.push([...path]); // with backtrack we need to create new copy of path, without we don't
//             return;
//         }
//         //logic 
//         //We either choose a num or don't at each step, we recurse over both the possibilities 
//         //don't choose
//             //subsetsHelper(nums, index+1, [...path], result) // extra space so need to use backtracking
//             subsetsHelper(nums, index+1, path, result)
//         //choose
//             //subsetsHelper(nums, index+1, [...path, nums[index]], result) // here we are creating deep copy of path 
//                                                              //at each recursion, so to avoid this we use backtracking
//             //action
//             path.push(nums[index]);
//             //recurse
//             subsetsHelper(nums, index+1, path, result)
//             //backtrack
//             path.pop();
//     }

//     subsetsHelper(nums, 0, [], result);
//     return result;
// };

//solution with for loop recursion
var subsets = function(nums) {
    let result = [];

    const subsetsHelper = (nums, pivot, path, result) => {

        //base logic
        result.push([...path]);

        //recursion logic
        for(let i = pivot; i<nums.length; i++){
            //action
            path.push(nums[i]);
            //recurse
            subsetsHelper(nums, i+1, path, result);

            //backtrack
            path.pop();
        }
    }

    subsetsHelper(nums, 0, [], result);
    return result;
};

//Iterative solution 
//T.C 2^n 
// var subsets = function(nums) {
//     let result = [[]];
//     for(let i=0; i<nums.length; i++){
//         let resLen = result.length;
//         for(let j=0; j<resLen; j++){
//             let currList = [...result[j]];
//             currList.push(nums[i]);
//             result.push(currList);
//         }
//     }
//     return result;
// };