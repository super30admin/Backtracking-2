// Time Complexity: O(2^n * n) where n is the number of elements in the input array
// Space Complexity: O(n) where n is the stack space
// Were you able to solve the problem? Yes
// Did you face any challenges while solving the problem? No

class Solution {
public:
    
    vector<vector<int>> result;
    vector<vector<int>> subsets(vector<int>& nums) {
        
        vector<int> path;
        backtrack(nums, 0, path);

        return result;
        
    }
private:
    void backtrack(const vector<int>& nums, int index, vector<int>& path){

        // base case : store path at very recursive level making sure that we are only adding once and all subsets are explored
        result.push_back(path);


        // for loop recursion - explore all possible subsets
        // start from current index and go till the end of the array
        for (int i = index; i<nums.size(); i++){

            // action - add the current number to the path
            path.push_back(nums[i]);
            // cout<<path<<"\n";

            //explore - recurse with the next index
            backtrack(nums, i+1, path);


            // backtrack - remove the last added number from the path
            path.pop_back();
            // cout<<path<<"\n";

        }
        
        
    }
};
