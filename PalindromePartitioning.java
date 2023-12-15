import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    //0-1 based recursion
        // TC:O(2^n)
        // SC:O(n)
        List<List<String>> result2;
        List<String> path2;
        public List<List<String>> partition2(String s) {
            result2 = new ArrayList<>();
            path2 = new ArrayList<>();
            helper2(s,0,0,0);
            return result2;
        }

        private void helper2(String s, int pivot,int i, int sum){
            //base
            if(i == s.length()){
                if(sum == s.length()){
                    result2.add(new ArrayList<>(path2));

                }
                return;
            }

            //logic
            //dont choose
            helper2(s,pivot, i + 1, sum);

            //choose
            String sub = s.substring(pivot,i+1);
            if(isPalindrome(sub)){
                path2.add(sub);
                helper2(s, i+1, i+1, sum+sub.length());
                path2.remove(path2.size()-1);
            }



        }

    // ******For based Recursion************
        List<List<String>> result;
        List<String> path;
        public List<List<String>> partition(String s) {
            result = new ArrayList<>();
            path = new ArrayList<>();
            helper(s,0);
            return result;
        }

        private void helper(String s, int pivot){
            //base
            if(pivot == s.length()){
                result.add(new ArrayList<>(path));
                return;
            }
            //logic
            for(int i = pivot; i < s.length(); i++){
                String sub = s.substring(pivot, i+1);
                if(isPalindrome(sub)){
                    path.add(sub);
                    helper(s,i+1);
                    path.remove(path.size()-1);
                }
            }


        }
        private boolean isPalindrome(String s){
            int start = 0;
            int end = s.length() - 1;
            while(start < end){
                char sChar = s.charAt(start);
                char eChar = s.charAt(end);
                if(sChar != eChar){
                    return false;
                }
                start++;
                end--;
            }
            return true;
        }
 }
