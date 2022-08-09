class Solution {
public:
    //Time Complexity : O(N⋅2powerN) 
//where N is the length of string ss. This is the worst-case time complexity when all the possible substrings are palindrom
    bool ispal(string &s,int i, int j){
        while(i<j){
            if(s[i++]!=s[j--])return false;
        }
        return true;
    }
void helper(string &s,int i,int n, vector<string> &temp,vector<vector<string>>&res){
    if(i==n){
        res.push_back(temp);
     // return;
    }
    else{
    for(int j=i;j<n;++j){
       if(ispal(s,i,j)){
           temp.push_back(s.substr(i,j-i+1));
            helper(s,j+1,n,temp,res);
        temp.pop_back();
       }
       
    }
    
    } 
}
    vector<vector<string>> partition(string &s) {
        
        int n=s.size();
       vector<vector<string>>res;
        if(n==0)return res;
        vector<string> temp;
        helper(s,0,n,temp,res);
        return res;
    }
};