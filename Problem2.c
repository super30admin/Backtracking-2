/* Problem Statement:
Verified on leetcode

Given a set of distinct integers, nums, return all possible subsets (the power set).

Note: The solution set must not contain duplicate subsets.

Example:

Input: nums = [1,2,3]
Output:
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]



 *
 * Time Complexity : O(2 ^ N) as for each stage, we are deciding whether to take that char or not.
 * Space Complexity : O(n) excluding the result set 
 */




/**
 * Return an array of arrays of size *returnSize.
 * The sizes of the arrays are returned as *returnColumnSizes array.
 * Note: Both returned array and *columnSizes array must be malloced, assume caller calls free().
 */

void subsets_helper(int *nums, int numsSize, int *returnSize, int **final_arr, int *ret_col, int curr_pos, int *temp_arr, int temp_size) {
    int idx = 0, idx1 = 0;
    int **fin_arr = final_arr;
    int *curr_res_arr = temp_arr;
    
    /* Have some data, add it to the final list */
    if (temp_size){
        final_arr[*returnSize] = (int *)calloc(sizeof(int), temp_size);
        ret_col[*returnSize] = temp_size;
        
        for (idx = 0; idx < temp_size; idx++) {
            fin_arr[*returnSize][idx] = curr_res_arr[idx];
        }
        *returnSize = *returnSize + 1;
     }
    
    /* For each index in the array, add it to temp array, ie make a choice, call recursion again and then undo the choice :) */
    for (idx1 = curr_pos; idx1 < numsSize; idx1++) {
        /* make a choice */
        curr_res_arr[idx] = nums[idx1];
        temp_size = temp_size + 1;
        subsets_helper(nums, numsSize, returnSize, final_arr, ret_col, idx1 + 1, curr_res_arr, temp_size);
        /* Undo the choice, here I can even set some NULL value to curr_res_arr[idx] too*/
        temp_size = temp_size - 1;
    }
}
int** subsets(int* nums, int numsSize, int* returnSize, int** returnColumnSizes){

    int **final_arr = NULL;
    *returnSize = 0;
    int *ret_col = NULL;
    
    /* Init case handle */
    if (!numsSize) {
        return final_arr;
    }
    /* Memory allocation */
    #define FINAL_ARR 5000
    final_arr = (int **)calloc(FINAL_ARR, sizeof(int *));
    final_arr[*returnSize] = NULL;
    /* Adding [] case */
    ret_col = (int *)malloc(sizeof(int) * FINAL_ARR);
    ret_col[*returnSize] = 0;

    *returnSize = *returnSize + 1;
    
    /* temporary buffer for output */
    int *temp_res = NULL;
    temp_res = (int *)calloc(1, sizeof(int) * FINAL_ARR);
    subsets_helper(nums, numsSize, returnSize, final_arr, ret_col, 0, temp_res, 0);
    free(temp_res);
    
    /* set the return column size */
    *returnColumnSizes = ret_col;
    return final_arr;
}





/* use leetcode platform to test it */


