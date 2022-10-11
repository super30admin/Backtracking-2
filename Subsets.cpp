// Approach copy of path at every node.
// not choose first
// Time COmplexity - O(2^n)
// Space Complexity - O(2^n) - is this correct? since I'm making copies of my path at every node.
// Problems Faced - No!
// It runs on leetcode!
class Solution {
    private:
    void helper(vector<int>& nums, vector<vector<int>>& answer, int i, vector<int> path){
        // base
        if(i == nums.size()){
            answer.push_back(path);
            return;
        }
        
        // logic
        
        // not choose
        vector<int> pathCopy(path);
        helper(nums, answer, i+1, pathCopy);
        
        //choose
        path.push_back(nums[i]);
        vector<int> pathCopy2(path);
        helper(nums, answer, i+1, pathCopy2);
    }
public:
    vector<vector<int>> subsets(vector<int>& nums) {
        vector<vector<int>> answer;
        vector<int> path;
        helper(nums, answer, 0, path);
        return answer;
    }
};

// Approach copy of path at every node.
// choose first
// Time COmplexity - O(2^n)
// Space Complexity - O(2^n) - Is this correct?
// Problems Faced - No!
// It runs on leetcode!
class Solution {
    private:
    void helper(vector<int>& nums, vector<vector<int>>& answer, int i, vector<int> path){
        // base
        if(i == nums.size()){
            answer.push_back(path);
            return;
        }
        
        // logic
        
        //choose
        vector<int> pathCopy2(path);
        pathCopy2.push_back(nums[i]);
        helper(nums, answer, i+1, pathCopy2);
        
        // not choose
        vector<int> pathCopy(path);
        helper(nums, answer, i+1, pathCopy);
        
        
    }
public:
    vector<vector<int>> subsets(vector<int>& nums) {
        vector<vector<int>> answer;
        vector<int> path;
        helper(nums, answer, 0, path);
        return answer;
    }
};



// Approach - Backtrack
// Time COmplexity - O(2^n)
// Space Complexity - O(n)
// Problems Faced - No!
// It runs on leetcode!
class Solution {
    private:
    void helper(vector<int>& nums, vector<vector<int>>& answer, int i, vector<int>& path){
        // base
        if(i == nums.size()){
            answer.push_back(path);
            return;
        }
        
        // logic
        
        // not choose
        helper(nums, answer, i+1, path);
        
        //choose
        // action
        path.push_back(nums[i]);
        helper(nums, answer, i+1, path);
        
        // backtrack
        path.pop_back();
    }
public:
    vector<vector<int>> subsets(vector<int>& nums) {
        vector<vector<int>> answer;
        vector<int> path;
        helper(nums, answer, 0, path);
        return answer;
    }
};

// For-loop based recursion
// Time COmplexity - O(2^n)
// Space Complexity - O(n)
// Problems Faced - No!
// It runs on leetcode!
class Solution {
    private:
    void helper(vector<int>& nums, vector<vector<int>>& subsets, vector<int>& subset, int index){
        // base
        if(index > nums.size())
            return;
        
        subsets.push_back(subset);
        // logic
        for(int i = index; i < nums.size(); i++){
            // action
            subset.push_back(nums[i]);
            
            // recurse
            helper(nums, subsets, subset, i+1);
            
            // backtrack
            subset.pop_back();
        }
    }
public:
    vector<vector<int>> subsets(vector<int>& nums) {
        vector<vector<int>> subsets;
        vector<int> subset;
        helper(nums, subsets, subset, 0);
        return subsets;
    }
};


// Iterative approach
// Time COmplexity - O(2^n)
// Space Complexity - O(2^n)
// Problems Faced - No!
// It runs on leetcode!
class Solution {
public:
    vector<vector<int>> subsets(vector<int>& nums) {
        vector<vector<int>> subsets;
        vector<int> subset;
        subsets.push_back(subset);
        for(int i = 0; i < nums.size(); i++){
            int temp = subsets.size();
            for(int j = 0; j < temp; j++){
                vector<int> curr = subsets[j];
                vector<int> currCopy(curr);
                currCopy.push_back(nums[i]);
                subsets.push_back(currCopy);
            }
        }
        return subsets;
    }
};