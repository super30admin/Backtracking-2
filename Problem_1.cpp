/**
 * We have four solutions of this problem
 * 1. Recursion with maintaing copy at each node
 * 2. Recursion with backtracking
 * 3. For loop based recursion
 * 4. Iterative
 */

/**
 * Time complexity will be O(2^n) for all the recursive solutions. But for 
 * iterative it will be O(n*2^n)
 * 
 */

/**
 * Space complexity:
 * The space complexity for all the recursive solutions will be O(n).But for 
 * iterative it will be O(n*2^n)
 */

/**
 * Approach:
 * 1. Recursion with maintaing copy at each node:
 *    We will be using choose and not choose method. In it we also maintain the path,
 *    to keep track that what elements have been added to get the subsets. When
 *    we are choosing, to avoid duplicacy we will be creating a new list of path
 *    at each node.
 * 
 * 2. Recursion with backtracking:
 *    It is alos based on choose and not choose method. the only difference is that
 *    instead of maintaing a new list at each node, we simply backtrack at the end.
 * 
 * 3. For loop based recursion:
 *    It is knd of controlled recursion. We use for loop at set a pivot. For that pivot
 *    we explore all the possibilities. Then after exploring the possibilities
 *    we increment the pivot by one to explore the other possibilities. The backtrack
 *    will be here also toa void duplicacy. There will be no base case as the for loop
 *    will take care of it.
 * 
 * 4. Iterative:
 *    We start with an empty vector in the result. Now we iterate over the given array
 *    and we add the element to all the vectors present in the result vector. So,
 *    every time the result vector's size will keep on changing, so we have to maintain
 *    a variable that keeps the track of the size of new result vector.
 */

//The codes ran perfectly on leetcode

//1. Recursion with maintaing copy at each node
class Solution {
    vector<vector<int>> result;
public:
    vector<vector<int>> subsets(vector<int>& nums) {
        if(nums.size() == 0) return result;
        helper(nums, 0, {});
        return result;
    }
    
    private:
    void helper(vector<int> &nums, int index, vector<int> path){
        //base case
        if(index == nums.size()){
            result.push_back(path);
            return;
        }
        //logic
        //not choose case
        helper(nums, index + 1, vector<int> {path});
        //choose
        //action: maintaining a vector at every node
        vector<int> temp {path};
        temp.push_back(nums[index]);
        helper(nums, index + 1, temp);
    }
};

//2. recursion with backtrack
class Solution {
    vector<vector<int>> result;
public:
    vector<vector<int>> subsets(vector<int>& nums) {
        if(nums.size() == 0) return result;
        helper(nums, 0, {});
        return result;
    }
    
    private:
    void helper(vector<int> &nums, int index, vector<int> path){
        //base case
        if(index == nums.size()){
            result.push_back(path);
            return;
        }
        //logic
        //not choose
        helper(nums, index + 1, path);
        //choose
        //action
        path.push_back(nums[index]);
        //recurse
        helper(nums, index + 1, path);
        //backtrack
        path.pop_back();
        
    }
};


//3. For loop based recursion 
class Solution {
    vector<vector<int>> result;
public:
    vector<vector<int>> subsets(vector<int>& nums) {
        if(nums.size() == 0) return result;
        helper(nums, 0, {});
        return result;
    }
    
    private:
    void helper(vector<int> &nums, int index, vector<int> path){
        //base case
        result.push_back(path);
        //logic
        for(int i = index; i<nums.size(); i++){
            //action
            path.push_back(nums[i]);
            //recurse
            helper(nums, i + 1, path);
            //backtrack
            path.pop_back();
        }
        
    }
};

//4. Iterative
class Solution {
public:
    vector<vector<int>> subsets(vector<int>& nums) {
        vector<vector<int>> result {{}};
        for(int i =0; i<nums.size(); i++){
            int k = result.size(); 
            for(int j =0; j<k; j++){
                result.push_back(result[j]);
                result.back().push_back(nums[i]);
            }
        }
        return result;
    }
};
