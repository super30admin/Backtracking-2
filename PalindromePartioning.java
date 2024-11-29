// Approach : For loop based Recursion with backtracking
// Time : l*2^n // 
// Space : O(n) // n being string length
class Solution {
    List<List<String>> result;
    public List<List<String>> partition(String s) {
        this.result = new ArrayList<>();
        if(s== null || s.length() ==0) return result;
        backtrack(s,new ArrayList<>(),0);
        return result; 
    }

    public void backtrack(String s , List<String> path, int pivot){
        // Base case
        if(pivot==s.length()) {
            result.add(new ArrayList<>(path));
            return;
        };
        
        // logic
        for(int i = pivot;i<s.length();i++){
            if(isPalindrome(s,pivot,i)){
                // action - add substring
                path.add(s.substring(pivot,i+1));
                // recursion
                backtrack(s,path,i+1);
                // backtrack
                path.remove(path.size()-1);
            }
        }

    }

    public boolean isPalindrome(String s, int l , int r){
        if(l==r) return true;
        while(l<r){
            if(s.charAt(l) !=s.charAt(r)){
                return false;
            } else{
                l++;
                r--;
            }
        }
        return true;
    }
}


// Approach : 0 and 1 recursion
// Time : l*2^n  + n (substring & palindrome)
// Space : O(n) // n being length of substring
class Solution {
    List<List<String>> result;
    public List<List<String>> partition(String s) {
        this.result = new ArrayList<>();
        if(s== null || s.length() ==0) return result;
        helper(s,0,0,new ArrayList<>(), 0);
        return result; 
    }

    public void helper(String s,int pivot,int i,List<String> path, int sum){
        // base case
        if(i == s.length()){
            if(sum == s.length()){
                result.add(new ArrayList<>(path));
            }
            return;
        }
        // logic
        helper(s,pivot,i+1,path,0); // no choose
        String substring = s.substring(pivot,i+1);
        if(isPalindrome(substring)){
            // action
            path.add(substring);
            // recursion
            helper(s,i+1,i+1,path,sum+substring.length()); // choose
            // backtrack
            path.remove(path.size()-1);
        }


    }

    private boolean isPalindrome(String s){
        int l = 0 ; 
        int r=s.length()-1;
        while(l<r){
            if(s.charAt(l)!=s.charAt(r)){
                return false;
            }l++;r--; 
        }
        return true;
    }
}

    

