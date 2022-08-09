class Solution {
public:
    //tc:O(NX2POWERN)
    //SC:O(N)
  void subsetgenerate(int index,vector<int>&nums,vector<vector<int>>&result,vector<int> temp){
       
      //for each elemnt in the subset we have the option of either picking the elemnt 
      //or not picking ,if we are picking it we are pushing it into the temp array and we will be popping it to create a subset without that particular element 
      
      
          result.push_back(temp);
      
        for(int j=index;j<nums.size();j++){
            temp.push_back(nums[j]);
            subsetgenerate(j+1,nums,result,temp);
            temp.pop_back();
        }
    
      
    }
  vector<vector<int>> subsets(vector<int>& nums) {
        vector<vector<int>> result;
        vector<int> temp;
        subsetgenerate(0,nums,result,temp);
        return result;
    }
};