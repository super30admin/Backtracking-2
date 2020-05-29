// ## Problem1 
// Subsets (https://leetcode.com/problems/subsets/)

let result = [];
var subsets = function(nums) {
   helper(nums, [],0);
   return result;

   function helper (nums, temp, start){
       result.push([temp]);
       for(let i = start; i < nums.length; i++){
           temp.push(nums[i]);
           helper(nums, temp, i+1);
           temp.pop();
       }
   }
};

// ## Problem2
// Palindrome Partitioning(https://leetcode.com/problems/palindrome-partitioning/)