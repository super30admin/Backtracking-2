//Leetcode : 131. Palindrome Partitioning
// Time complexity: O(n) , n is length of the string
//Space Complexity: O(n), for recursive stack
class Solution {
     List<List<String>> res;
    public List<List<String>> partition(String s) {
       res = new ArrayList<List<String>>();
        if(s==null || s.length()==0){
            return res; 
        }
       helper(s,new ArrayList<String>(),0);
        return res; 
    }
    
    public void helper(String s1,List<String> temp, int start){
        //base
        if(start==s1.length()){
            res.add(new ArrayList(temp));
            return;
        }
        for(int i=start; i<s1.length();i++){
               if(isPalindrome(s1, start, i)){
                    temp.add(s1.substring(start,i+1));
                    helper(s1, temp,i+1);
                  temp.remove(temp.size()-1);
                }
             
           } 
       
        return;
        
    }
    public boolean isPalindrome(String t, int i, int j){
        if(i==j) return true;
        while(i<j){
            if(t.charAt(i)!=t.charAt(j)){
                return  false;
            }
            i++;
            j--;
        }
        
        return true;
    }
    
}