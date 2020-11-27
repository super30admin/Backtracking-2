// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// recurrsion

var subsets = function(nums) {
    const res = [];
    if(nums == null || nums.length == 0) return res
    helper(nums, 0);
    return res;

    function helper(nums,index, curr = [])
    {
        if(index == nums.length){
            res.push(curr);
            return
        }

        helper(nums, index + 1, curr)

        helper(nums, index + 1, curr.concat(nums[index]))
    }
}

var subsets = function(nums) {
    const res = [];
    if(nums == null || nums.length == 0) return res
    helper(nums);
    return res;

    function helper(nums,i = 0, curr = [])
    {
        res.push([curr]);

        for(; i < nums.length; i++){
            //action
            
            //recurse
            helper(nums, i + 1, curr.concat(nums[i]))
            curr.splice(curr.length - 1)
        }
    }
}
