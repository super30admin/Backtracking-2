//// Time Complexity : O(N^N)
//// Space Complexity : O(N^3) due to palindrome check at each node
//// Did this code successfully run on Leetcode : yes
//// Any problem you faced while coding this :

// internalizing backtracking problems

//// Your code here along with comments explaining your approach

// recurse over the input string from 0 to input string length
// at each recursion,
//   base case: if you have exhausted your input, add path to output
//   build substrings upon substrings into a path
//   if a substring isn't a palindrome return immediately
//   keep recursing on remaining strings

// return output
var partition;

partition = function(s) {
  var backtracking, isPalindrome, output, path;
  output = [];
  path = [];
  isPalindrome = function(s) {
    var left, right;
    left = 0;
    right = s.length - 1;
    while (left < right) {
      if (s[left] !== s[right]) {
        return false;
      }
      left += 1;
      right -= 1;
    }
    return true;
  };
  // input, way to traverse, current path
  backtracking = function(index, path) {
    var i, j, ref, ref1, results, temp;
    // base case
    if (index >= s.length) {
      output.push(path);
      return;
    }
// recursive
    results = [];
    for (i = j = ref = index, ref1 = s.length; (ref <= ref1 ? j < ref1 : j > ref1); i = ref <= ref1 ? ++j : --j) {
      temp = s.substring(index, i + 1);
      if (isPalindrome(temp)) {
        results.push(backtracking(i + 1, [].concat(path).concat(temp)));
      } else {
        results.push(void 0);
      }
    }
    return results;
  };
  backtracking(0, path);
  return output;
};

//# sourceMappingURL=problem2-palindrome-partitioning.js.map
