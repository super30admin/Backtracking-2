class Solution {
public:
    vector<vector<string>> partition(string s) {

      vector<vector<string>> ans;
      vector<string>path;

        subs(s,0,path,ans);
 
      return ans;
    }

    void subs(string s,int k,vector<string> &path,vector<vector<string>> &ans){

        if(k == s.length()){
            ans.push_back(path);
            return;
        }

        for(int i=k;i<s.length();i++){
            string sub = s.substr(k,i-k+1);
        
            if(isPalindrome(sub)){
                cout<< "for sub " <<k <<"for value i: "<<i  <<" values is : "<< sub<<endl; 
                path.push_back(sub);

                subs(s,i+1,path,ans);
                path.pop_back();
            }
        }
    }


 bool isPalindrome(string str) {
  int n = str.length();
  for (int i = 0; i < n / 2; i++) {
    if (str[i] != str[n - i - 1]) {
      return false;
    }
  }
  return true;
}
};