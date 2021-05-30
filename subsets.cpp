/*

Intuition: We have to exhaust all possible combinations. 
Therefore for each number we can either pick that number or skip that number.
For each number we have 2 choices. Either we can pick it or not. ( Pattern 1 - Cases Pattern) 

We can also start with an empty path and built it from there. ( Pattern 2 - For loop Pattern)

//////////////////////////////////////////////
Time and space complexity is same for both patterns
Time Complexity: O(2^N)
Space Complexity: O(H), H = Height of the tree
//////////////////////////////////////////////
*/
class Solution {
public:
    vector<vector<int>> result;
    vector<vector<int>> subsets(vector<int>& nums) {
        vector<int> path;
        helper(nums, 0, path);
        return result;
    }
    
    void helper(vector<int> nums, int index,vector<int> path){
    
        if (index == nums.size()){
            result.push_back(path);
            return;
            
        }

        helper(nums, index+1, path);
        vector<int> temp(path);
        temp.push_back(nums[index]);
        helper(nums, index+1, temp);
    
    }
};
//Backtrack solution using pattern 1 ( Cases pattern)
class Solution {
public:
    vector<vector<int>> result;
    vector<vector<int>> subsets(vector<int>& nums) {
        vector<int> path;
        helper(nums, 0, path);
        return result;
    }
    
    void helper(vector<int> nums, int index,vector<int> path){
    
        if (index == nums.size()){
            vector <int> temp(path);
            result.push_back(temp);
            return;
            
        }

        helper(nums, index+1, path);
        path.push_back(nums[index]);
        helper(nums, index+1, path);
        path.pop_back();

    }
};

//Pattern 2: For loop without backtarcking

class Solution {
public:
    vector<vector<int>> result;
    vector<vector<int>> subsets(vector<int>& nums) {
        vector<int> path;
        helper(nums, 0, path);
        return result;
    }
    
    void helper(vector<int> nums, int index,vector<int> path){
    
        result.push_back(path);
        for( int i = index; i < nums.size(); i++){
            vector <int> temp(path);
            temp.push_back(nums[i]);
            helper(nums, i + 1, temp);

        
        }

    }
};
//Pattern 2: For loop with backtarcking

class Solution {
public:
    vector<vector<int>> result;
    vector<vector<int>> subsets(vector<int>& nums) {
        vector<int> path;
        helper(nums, 0, path);
        return result;
    }
    
    void helper(vector<int> nums, int index,vector<int> path){
    
        result.push_back(path);
        for( int i = index; i < nums.size(); i++){
            
            path.push_back(nums[i]);
            helper(nums, i + 1, path);
            path.pop_back();
        
        }

    }
};