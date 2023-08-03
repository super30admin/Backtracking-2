class Solution {
   

public:
 vector<vector<string>> result;
    vector<vector<string>> partition(string s) {
        vector<string> p;
        helper(s,0,p);
        return result;
        
    }

    
    void helper(string stt, int pivot, vector<string> path){

        if(pivot == stt.size()){
            vector<string> m = path;
            result.push_back(m);
            return;
        }

        for(int i=pivot;i<stt.size();i++){
            string sub = stt.substr(pivot,i - pivot + 1);
            if(isPalindrome(sub)){
                path.push_back(sub);
                helper(stt,i+1,path);
                path.pop_back();
            }
        }

    }

bool isPalindrome(string S)
{
    int i = 0;
    int j = S.size()-1;
    
    while (i < j)
    {
        if (S[i] != S[j])
        {
            return false;
        }
        i++;
        j--;
    }
    
    return true;
}


};