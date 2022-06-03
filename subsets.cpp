01 Recursion

TC = O(n 2^n)
SC = O(n*n)
 
class Solution {
public:
    vector<vector<int>> result;
    vector<vector<int>> subsets(vector<int>& nums) {
        recursion(nums,{},0);
        return result;
    }
    
    void recursion(vector<int>& nums, vector<int> path, int i){
        //base
        if(i==nums.size()){
            result.push_back(path);
            return;
        }
        //recursion
        //dont choose
        recursion(nums,vector<int>(path),i+1);
    
        //choose
        path.push_back(nums[i]);
        recursion(nums,vector<int>(path),i+1);
    }
};
------------------------------------------------------------------
 01 BACKTRACKING
 
 TC = O(n 2^N)
 SC = O(N)
 
 class Solution {
public:
    vector<vector<int>> result;
    vector<vector<int>> subsets(vector<int>& nums) {
        recursion(nums,{},0);
        return result;
    }
    
    void recursion(vector<int>& nums, vector<int> path, int i){
        //base
        if(i==nums.size()){
            result.push_back(vector<int>(path));
            return;
        }
        //recursion
        //dont choose
        recursion(nums,path,i+1);
    
        //choose
        path.push_back(nums[i]);
        recursion(nums,path,i+1);\
        path.pop_back();
    }
};
------------------------------------------------------------------
FOR LOOP RECURSION

TC = O(n 2^n)
SC = O(n*n)

class Solution {
public:
    vector<vector<int>> result;
    vector<vector<int>> subsets(vector<int>& nums) {
        recursion(nums, {},0);
        return result;
    }
    
    void recursion(vector<int>& nums, vector<int> path, int pivot){
        result.push_back(path);
        for(int i=pivot;i<nums.size();i++){
            vector<int> temp(path);
            temp.push_back(nums[i]);
            recursion(nums,temp,i+1);
        }
    }
};
------------------------------------------------------------------
 FOR LOOP BACKTRACKING
 
 TC = O(n 2^n)
SC = O(n)
 
 class Solution {
public:
    vector<vector<int>> result;
    vector<vector<int>> subsets(vector<int>& nums) {
        recursion(nums, {},0);
        return result;
    }
    
    void recursion(vector<int>& nums, vector<int> path, int pivot){
        result.push_back(path);
        for(int i=pivot;i<nums.size();i++){
            path.push_back(nums[i]);
            recursion(nums,path,i+1);
            path.pop_back();
        }
    }
};

------------------------------------------------------------------
 NO RECURSION
 
 TC = O(2^N)
 SC = O(1)
 
 class Solution {
public:
    vector<vector<int>> subsets(vector<int>& nums) {
        vector<vector<int>> result;
        result.push_back({});
        for(int i=0;i<nums.size();i++){
            int size = result.size();
            for(int j=0;j<size;j++){
                vector<int> temp(result[j]);
                temp.push_back(nums[i]);
                result.push_back(temp);
            }
        }
        return result;
    }
};
 
