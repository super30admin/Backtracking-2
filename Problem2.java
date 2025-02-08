public class Problem2 {
    class Solution {

        //t.c -> exponential
        //s.c -> exponential + O(n) (no of recursive call);
        List<List<String>> result;
        public List<List<String>> partition(String s) {
            if(s == null || s.length() ==0 ){
                return new ArrayList<>();
            }
            result = new ArrayList<>();
            backtrack(s,0,new ArrayList<>());
            return result;
        }
        private void backtrack(String s, int index, List<String> path){
            //base
            if(index == s.length()){
                result.add(new ArrayList<>(path));
                return;
            }

            //logic
            for(int i = index;i<s.length();i++){
                //find if the substring is palindrome or not then only do recursion
                if(isPalindrome(s,index,i)){
                    //action
                    path.add(s.substring(index,i+1));
                    //recurse
                    backtrack(s,i+1,path);
                    //backtrack
                    path.remove(path.size()-1);
                }
            }
        }
        private boolean isPalindrome(String s, int left,int right){
            while(left<right){
                if(s.charAt(left) != s.charAt(right)){
                    return false;
                }
                left++;
                right--;
            }
            return true;
        }
    }
}
