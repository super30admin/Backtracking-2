/*
// Time Complexity : O(2^n)
// Space Complexity : O(2^n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :
// nope

// Your code here along with comments explaining your approach
*/

class Solution {
    List<String> temp;
    List<List<String>> ret;
    public List<List<String>> partition(String s) {
        this.temp = new ArrayList<>();
        this.ret = new ArrayList<>();
        helper(s);
        return this.ret;
    }

    private void helper(String s){
        //base case. if this substring is empty.
        //means we saw all possible palin partitions.
        if(s.length() == 0){
            this.ret.add(new ArrayList<>(temp));
            return;
        }

        //strting from 0->s.length. in case a substring from 0->s.length is
        //a palin only then see if rest of the string still has valid palins.
        for(int i = 0; i < s.length(); i++){
            if(isPalin(s, 0, i)){
                temp.add(s.substring(0, i+1));
                helper(s.substring(i+1));
                temp.remove(temp.size()-1);
            }
        }
    }

    private boolean isPalin(String s, int st, int en){
        while(st < en){
            if(s.charAt(st) != s.charAt(en))
                return false;
            st++; en--;
        }
        return true;
    }

}
