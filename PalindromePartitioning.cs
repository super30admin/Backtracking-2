//TC: O(2^n)
//SC: O(n)

public class Solution {
    List<IList<string>> result;
    public IList<IList<string>> Partition(string s) {
        this.result = new List<IList<string>>();
        helper(s, 0, new List<string>());
        return result;
    }

    private void helper(string s, int pivot, List<string> path){
        //base case
        if(pivot == s.Length){
            result.Add(new List<string>(path));
        }

        //logic
        for(int i=pivot; i<s.Length;i++){
            string sub = s.Substring(pivot, i+1-pivot);
            if(isPalindrome(sub)){
                path.Add(sub);
                helper(s,i+1,path);
                path.RemoveAt(path.Count()-1);
            }
        }
    }

    private bool isPalindrome(string s){
            int l=0, r=s.Length-1;

            while(l<r){
                if(s[l] != s[r]){
                    return false;
                }
                l++; r--;
            }

            return true;
        }
}