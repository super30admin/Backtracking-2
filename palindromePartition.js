// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


var partition = function(s) {
    let res = [];
    if(s == null) return res
    helper(s, 0)
    return res;
    function helper(s, index, temp = []){
        //base
 

        //logic
        for(let i = index; i < s.length; i++){
            if(checkPalindrom(s.substr(index, i))){
                helper(s, i+1, temp.concat(s.substr(index, i + 1)))
            }
        }
    }
    function checkPalindrom (str) {
        return str == str.split('').reverse().join('');
    }
};