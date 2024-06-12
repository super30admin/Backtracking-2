/**

For loop based recursion: Find substring between pivot and i: TC: O(n*2^n), SC -O(n)
 */

 class Solution {

    List<List<String>> result;
    public List<List<String>> partition(String s) {

        this.result = new ArrayList<>();

        helper(s,0,new ArrayList<>() );

        return result;
        
    }
    private void helper(String s, int pivot, List<String> path){

        //base
        if(pivot == s.length()){
            result.add(new ArrayList<>(path));
            return;
        }

        //logic
        for(int i = pivot;i<s.length();i++ ){
            String str = s.substring(pivot, i+1);
            if(isPallindrome(str)){
                path.add(str);
                helper(s,i+1,path);
                path.remove(path.size()-1);
            }
        }
    }

    private boolean isPallindrome(String s){
        int start =0; int end = s.length()-1;

        while(start<end){
            if(s.charAt(start) != s.charAt(end)){return false;}
            start++;end--;
        }

        return true;
    }
}