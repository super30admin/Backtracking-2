/*
Time: O(2^n)
Space: O(2^n)

Backtrack: For every call we have two choices, either choose (if it is a palindrome and proceed with a new empty substring) 
and not-choose (continue building the current substring)

*/

class Solution {
public:
    vector<vector<int>> is_pali;
    int n;
    string s;
    
    vector<vector<string>> v;
    

    //pre calculation of is_pali 2d array for all possible indices i,j
    void pre_calc(){
        is_pali = vector(n, vector(n, 0));

        for(int i=0;i<n;i++)  is_pali[i][i] = 1;

        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                is_pali[i][j] = 1;

                int lo = i, hi = j;
                while(lo<hi){
                    if(s[lo++]!=s[hi--])  is_pali[i][j] = 0;  
                }
            }
        }
    }

    vector<string> tmp;
    string str = "";
    void call(int curr, int last){
        if(curr == n){
            if(last == n)  v.push_back(tmp);
            return;
        }

        //not choose - continue
        str += s[curr];
        call(curr+1, last);
        str.pop_back(); //backtrack


        //choose if the substring is a palindrome - proceed with a new empty substring
        if(is_pali[last][curr]){
            str += s[curr];
            tmp.push_back(str);
            str = "";

            call(curr+1,curr+1);

            //backtrack
            str = tmp[tmp.size()-1]; 
            str.pop_back();
            tmp.pop_back();  

        }
    }

    vector<vector<string>> partition(string s) {
        n = s.length();
        this->s = s;
        pre_calc();
        call(0,0);

        return v;      
    }
};
