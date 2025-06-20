// ## Problem1 
// Subsets (https://leetcode.com/problems/subsets/)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : I thought in for loop based recursion we would need a base case, but our base case is handled in the for loop termination condition 

//! Recursion is banned 
//! Meta Follow up
// https://www.youtube.com/watch?v=OLGZUQQYEPg&ab_channel=%7BS30%7D
//TimeStamp = 43:38
var subsets = function(nums) {
    let res = [[]]
    for(let i =0;i<nums.length;i++){
        let size = res.length
        for(let j=0;j<size;j++){
            let newArray = [...res[j],nums[i]]
            res.push(newArray)
        }
    }
    return res
};


// var subsets = function(nums = [1,2,3]) {
//! For Loop Based recuriion
//     //Time Complexity : O(N * 2^N)
//     //Space Complexity : O(N) auxiliary, O(N * 2^N) total
//     let res = [[]]
//     function helper(nums,pivot,subSet){
//         for(let i =pivot;i<nums.length;i++){

//             subSet.push(nums[i])
//             res.push([...subSet])
//             helper(nums,i+1,subSet)
//             subSet.pop()
//         }
//     }
//     helper(nums,0,[])
//     return res
// };

// var subsets = function(nums) {
//! 0 1 - Recursive Sol 
//     //Time Complexity : O(N * 2^N)
//     //Space Complexity : O(N) auxiliary, O(N * 2^N) total
//     let res = []
//     function helper(nums,idx,subSet){
//         //Base 
//         if(idx >= nums.length)
//         {
//             res.push([...subSet])
//             return 
//         }

//         let newArray  = [...subSet,nums[idx]]
//         helper(nums,idx+1,newArray)
//         helper(nums,idx+1,subSet)
//     }  
//     helper(nums,0,[])
//     return res
// };

// var subsets = function(nums) {
//! BackTracking Sol 
//     //Time Complexity : O(N * 2^N)
//     //Space Complexity : O(N)
//     let res = []
//     function helper(nums,idx,subSet){
//         //Base 
//         if(idx >= nums.length)
//         {
//             res.push([...subSet])
//             return 
//         }

//         subSet.push(nums[idx])
//         helper(nums,idx+1,subSet)
//         subSet.pop()
//         helper(nums,idx+1,subSet)
//     }  
//     helper(nums,0,[])
//     return res
// };