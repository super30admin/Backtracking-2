import java.util.ArrayList;
import java.util.List;

//Time Complexity: O(n*2^n)

public class PalindromePartitioning {
        List<List<String>> result;
        public List<List<String>> partition(String s) {
            result = new ArrayList<>();
            recurse(s, new ArrayList<>());
            return result;
        }

        public void recurse(String s, List<String> path){

            if(s.length() ==0){
                result.add(new ArrayList<>(path));
                return;
            }

            for(int i=0;i<s.length();i++){
                if(isPalindrome(s,0,i)){
                    path.add(s.substring(0,i+1));
                    recurse(s.substring(i+1), path);
                    path.remove(path.size()-1);
                }
            }
        }

        public boolean isPalindrome(String s, int low, int high){
            while(low<=high){
                if(s.charAt(low) != s.charAt(high)){

                    return false;
                }
                low++;
                high--;
            }
            return true;
        }
}
