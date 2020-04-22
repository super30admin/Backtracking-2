"""
// Time Complexity : O(m*2^n) m-> target, n-> number of candidates
// Space Complexity : O(maxDepth)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach
Algorithm explanation
The main idea is to iterate over the entire array and for each iteration,
divide into prefix and postfix and if the postfix is at least of size 1,
then recurse until we reach the end of the string
- In order to keep track of order of elements(1,2 same as 2,1), we use
set as intermediate data structure
"""
