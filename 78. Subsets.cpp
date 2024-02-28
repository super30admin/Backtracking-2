/*

Time: O(2^n)
Space: O(2^n)

Do 0-1 recursion, where the choices in every step are either take the element or not
*/

class Solution {
public:
    vector<vector<int>> sets;
    vector<int> v, nums;
    int n;

    void call(int p){
        if(p==n){
            sets.push_back(v);
            return;
        }

        for(int i=p;i<n;i++){
            v.push_back(nums[i]);
            call(i+1);
            v.pop_back();
        }

        sets.push_back(v); //important - make sure you add current vector to set even if you don't make any further calls
    }

    vector<vector<int>> subsets(vector<int>& nums) {
        this->nums = nums;
        n = nums.size();
        call(0);
        return sets;
    }
};
