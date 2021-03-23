//TC: O(n * 2^n) since for each candidate, we either add it to the set or we don't. 
//SC: O(n) where n is size of candidate set


class Solution {
public:
    
    vector<vector<int>> ans;
    
    void backtrack(vector<int>& nums, vector<int> combinations, int startIndex){
        
        //add the combination to the answer
        ans.push_back(combinations);
        
        for(int i=startIndex; i<nums.size(); i++){
            //push a new element into the combination
            combinations.push_back(nums[i]);
            backtrack(nums, combinations, i+1);
            //remove from the combination
            combinations.pop_back();
        }
        
        return;
        
    }
    
    
    vector<vector<int>> subsets(vector<int>& nums) {
        vector<int> combinations;
        int startIndex = 0;
        //call recursive backtracking function
        backtrack(nums, combinations, startIndex);
        
        return ans;
        
        
    }
};