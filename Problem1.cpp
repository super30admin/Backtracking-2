// Time Complexity : O(2^n)  
// Space Complexity : O(2^n)  
// Did this code successfully run on Leetcode : Yes

// Your code here along with comments explaining your approach:
// 1. Traverse each element and for each element include and exclude that element(choose element or don't).
// 2. For further subset recursively select remaining element combination. 
// 3. If we choose element add it to subset else skip it.

class Solution {
public:
    vector<vector<int>> ans;
    void getsub(vector<int>& nums,int it,vector<int> &p){
        ans.push_back(p);
        for(int i=it;i<nums.size();i++){
            if(i==it || nums[i]!=nums[i-1]){
                p.push_back(nums[i]);
                cout<<nums[i]<<' ';
                getsub(nums,i+1,p);
                p.pop_back();
            }
        }
    }
    vector<vector<int>> subsets(vector<int>& nums) {
        sort(nums.begin(),nums.end());
        vector<int> p;
        getsub(nums,0,p);
        return ans;
    }
};
