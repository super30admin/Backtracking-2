/*Time Complexity :  O(2^n)
Space Complexity  : ?
Did it run on LeetCode : Yes
Any problems : No
*/


class Solution {
public:
    
    void createSets(vector<vector<int>>&result, vector<int>&set, vector<int>&nums, int index){
       

        //storing the result
        result.push_back(set);
		
        //Edge case. 
        if(index == nums.size())return;
        
        //Loop to create subsets.
        for(int i=index;i<nums.size();i++){
            set.push_back(nums[i]);
            createSets(result, set, nums, i+1);
            set.pop_back();
        }
    }
    
    vector<vector<int>> subsets(vector<int>& nums) {
        vector<vector<int>>result;
        
        //edge case
        if(nums.size() == 0)return result;
        
        //basic recursive function call.
        vector<int> set;
        createSets(result, set, nums, 0);
        return result;
    }
    
};