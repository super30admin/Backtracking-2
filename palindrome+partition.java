import java.util.ArrayList;
import java.util.List;

class Solution {

    List<List<String>> result;

    public List<List<String>> partition(String s) {

        result = new ArrayList<>();

       helper(s, 0, 0,new ArrayList<>());

        return result;

    }

    private void helper(String s, int pivot, int i, List<String> path){

       // base

        if(i == s.length()){

            if(pivot == s.length()){

                result.add(new ArrayList<>(path));

            }

            return;

        }

        //logic

        //dont choose

        helper(s, pivot, i+1, path);

        //choose

            String sub = s.substring(pivot, i+1);

          if(isPalindrome(sub)){

              //action

            path.add(sub);

            //recurse

              helper(s, i+1, i+1, path);

            //backtrack

              path.remove(path.size() - 1);

          }

            

      

    }

    private boolean isPalindrome(String s){

            int start=0;

            int end=s.length()-1;

            while(start<end){

                if(s.charAt(start)!=s.charAt(end))

                    return false;

                start++;

                end--;

            }

            return true;

    }

    

}