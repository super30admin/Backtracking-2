/* Problem Statement:
Verified on leetcode

Given a string s, partition s such that every substring of the partition is a palindrome.

Return all possible palindrome partitioning of s.

Example:

Input: "aab"
Output:
[
  ["aa","b"],
  ["a","a","b"]
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

bool is_str_palindrome(const char *str, int end) {
    int start = 0;
 
    for (; start < end; start++, end--) {
        if (str[start] != str[end]) {
            return false;
        }
    }
    return true;
}

/* Test cases failed : Memory copy not correct, indexes were creating issues */

void partition_helper(char *s, int str_len, int *returnSize, int *ret_col, char ***final_arr, char **current_arr, int curr_arr_len) {
    int idx = 0;
    int len = 0;
    int till_this_point = 0;
    char ***fin_arr = final_arr;
    char **curr_arr = current_arr;

    /* if string is not processed, till now, */
    if (str_len) {
        /* Check if string upto idx is palindrom or not, */
        /* If it is a palindrome, then call the function again with rest of string and also add str to curr_arr
         */
        for (idx = 0; idx < str_len; idx++) {
            if (is_str_palindrome(s, idx)) {
                /* allocate, copy */
                curr_arr[curr_arr_len] = (char *)malloc(sizeof(char) * (idx + 2));
                strncpy(curr_arr[curr_arr_len], s, idx + 1);
                curr_arr[curr_arr_len][idx + 1] = '\0';
                curr_arr_len = curr_arr_len + 1;
                
                partition_helper(s + idx + 1, strlen(s + idx + 1), returnSize, ret_col, final_arr, curr_arr, curr_arr_len);
                /* Undo the choice */
                curr_arr_len = curr_arr_len - 1;
                free(curr_arr[curr_arr_len]);
            }
        }
        
    } else {
        /* allocate memory for new string result */
        final_arr[*returnSize] = (char **)malloc(sizeof(char *) * curr_arr_len);
        ret_col[*returnSize] = curr_arr_len;
        /* copy 2d array to the output */
        for (idx = 0; idx < curr_arr_len; idx++) {
            len = strlen(curr_arr[idx]);
            final_arr[*returnSize][idx] = (char *)malloc(sizeof(char) * (len + 1));
            strncpy(final_arr[*returnSize][idx], curr_arr[idx], len);
            final_arr[*returnSize][idx][len] = '\0';
        }
        *returnSize = *returnSize + 1;
    }
    
}
char *** partition(char * s, int* returnSize, int** returnColumnSizes){
    
    char ***final_arr = NULL;
    *returnSize = 0;
    int *ret_col = NULL;
    char **current_arr = NULL;
    
    /* Init case handle */
    if (!s) {
        return final_arr;
    }
    
    /* Memory allocation */
    #define FINAL_ARR 5000
    final_arr = (char ***)calloc(FINAL_ARR, sizeof(char **));

    ret_col = (int *)malloc(sizeof(int) * FINAL_ARR);
    
    /* processing*/
    current_arr = (char **)malloc(sizeof(char *) * FINAL_ARR);
    partition_helper(s, strlen(s), returnSize, ret_col, final_arr, current_arr, 0);
    free(current_arr);
    
    /* set the return column size */
    *returnColumnSizes = ret_col;
    return final_arr;
}



/* use leetcode platform to test it */


