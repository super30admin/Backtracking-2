import java.util.*;

public class PalindromePartitioning {
        /*

        TC: O(2^n)
        SC: O(n)

        */
        List<List<String>>  result;
        public List<List<String>> partition(String s) {
            result=new ArrayList<>();
            if(s==null || s.length()==0) return result;
            backtrack(s,0,new ArrayList<>());
            return result;
        }

        private void backtrack(String s,int index,List<String> path){
            //base
            if(index==s.length()){
                result.add(new ArrayList<>(path));
                return;
            }

            //logic

            for(int i=index;i<s.length();i++){
                String word=s.substring(index,i+1);
                if(isPalindrome(word)){
                    path.add(word);
                    backtrack(s,i+1,path);
                    path.remove(path.size()-1);
                }
            }

        }

        private boolean isPalindrome(String word){
            int i=0;
            int j=word.length()-1;
            while(i<j){
                if(word.charAt(i)!=word.charAt(j)){
                    return false;
                }
                i++;
                j--;
            }
            return true;
        }
}
