class Solution {
    //sir taught this one in class
    //exponential tc
    
    //O(n*2^n) is TC (edit)
    //O(n) is auxillary stack space
public:
    vector<vector<int>> subsets(vector<int>& nums) {
        vector<vector<int>> res;
        vector<int> list;
        helper(nums, res, list, 0);
        return res;
    }
    void helper(vector<int>& nums, vector<vector<int>>& res, vector<int>& list, int start) {
        if(start == nums.size()) {
            res.push_back(list);
            return;
        }
        //action
        list.push_back(nums[start]);
        helper(nums, res, list, start + 1);//recurse
        //backtrack
        list.pop_back();
        helper(nums, res, list, start + 1);//recurse
    }
};


/*  vector<vector<int>> subsets(vector<int>& nums) {
     
        vector<vector<int> > results;
        int n=nums.size();
        for(int i=0; i<pow(2,n); ++i){
            vector<int> result;
            for(int j=0; j<n; ++j){
                if(((int)(i/pow(2,j))&1)) {
                  result.push_back(nums[j]);  
                }
            }
            results.push_back(result);
        }
        return results;
  }*/
