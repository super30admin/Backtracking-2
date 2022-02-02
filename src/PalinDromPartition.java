import java.util.ArrayList;
import java.util.List;
/*  Problem 1
// Time Complexity : O(N*2^n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

*/
public class PalinDromPartition {
    class ChooseNotBackTrack {
        List<List<String>> result;
        public List<List<String>> partition(String s) {
            result = new ArrayList<>();
            if(s == null) return result;
            if(s.length() == 1){
                List<String> a = new ArrayList<>();
                a.add(s);
                result.add(a);
                return result;
            }
            helper(s, 0, new ArrayList<>());
            return result;
        }
        private void helper(String s, int index, List<String> list) {
            //base
            if(index  == s.length())    {
                if(s.length()>0 && isPalindrom(s.substring(0, index)))
                {
                    list.add(s);
                    result.add(new ArrayList(list));
                }
                return;
            }
            //logic
            helper(s, index+1, new ArrayList(list));
            if(isPalindrom(s.substring(0, index+1)))
            {
                list.add(s.substring(0, index+1));
                helper(s.substring(index+1), 0, list);
                list.remove(list.size()-1);
            }



            // helper(s, index+1, list);
        }
        private boolean isPalindrom(String s){
            int i=0;
            int j=s.length()-1;
            while(i<j){
                if( s.charAt(i) != s.charAt(j))
                    return false;
                i++;
                j--;
            }

            return true;
        }
    }

    class ForRecurseBackTract {
        List<List<String>> result;
        public List<List<String>> partition(String s) {
            result = new ArrayList<>();
            if(s == null) return result;

            helper(s, 0, new ArrayList<>());
            return result;
        }
        private void helper(String s, int index, List<String> list) {

            if(index == s.length())
            {
                result.add(new ArrayList(list));
            }
            for(int i=index; i<s.length(); i++) {
                String sb = s.substring(index, i+1);
                if(isPalindrom(sb))
                {
                    list.add(sb);
                    helper(s, i+1, list);
                    list.remove(list.size()-1);
                }
            }

        }
        private boolean isPalindrom(String s){
            int i=0;
            int j=s.length()-1;
            while(i<j){
                if( s.charAt(i) != s.charAt(j))
                    return false;
                i++;
                j--;
            }
            return true;
        }
    }

    class ForRecurseBackTractWithZeroIndex {
        List<List<String>> result;
        public List<List<String>> partition(String s) {
            result = new ArrayList<>();
            if(s == null) return result;

            helper(s, 0, new ArrayList<>());
            return result;
        }
        private void helper(String s, int index, List<String> list) {

            if(index == s.length())
            {
                result.add(new ArrayList(list));
            }
            for(int i=0; i<s.length(); i++) {
                String sb = s.substring(index, i+1);
                if(isPalindrom(sb))
                {
                    list.add(sb);
                    helper(s.substring(i+1), 0, list);
                    list.remove(list.size()-1);
                }
            }

        }
        private boolean isPalindrom(String s){
            int i=0;
            int j=s.length()-1;
            while(i<j){
                if( s.charAt(i) != s.charAt(j))
                    return false;
                i++;
                j--;
            }
            return true;
        }
    }
}
