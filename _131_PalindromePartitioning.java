// Time Complexity : o(2^(n))*n where n is length of string as at eevry step we have two choices to choose or not
// Space Complexity : o(n)) length of recursive stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// start from index and and get substring and get result for right substring and add the left palindrom to the result of right substring

class Solution {
    public List<List<String>> partition(String s) {

        List<List<String>> res = new ArrayList<>();

        if(s.length() == 0){
            res.add(new ArrayList<>());
            return res;
        }

        for(int i=0; i<s.length(); i++){

             String str1 = s.substring(0,i+1);

             if(isPalindrom(str1)){
                 List<List<String>> temp = partition(s.substring(i+1));
                 for(List<String> x : temp){
                     x.add(0,str1);
                     res.add(x);
                 }
             }
        }
         return res;
    }

    public boolean isPalindrom(String s){
        int i=0;
        int j= s.length()-1;
        while(i<j && s.charAt(i) == s.charAt(j)){
            i++;
            j--;
        };
        return i>=j;
    }
}
