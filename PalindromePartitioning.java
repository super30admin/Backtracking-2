package s30.backTracking.b2;

import java.util.ArrayList;
import java.util.List;


//Algo
// You have choice of placing the partition after every index or not
// choose the substring for the partition in every iteration and apply similar to the next index;

// TC: (2^n) * n  here n is length of the input string
// SC: n
public class PalindromePartitioning {

    private List<String> currList;
    private List<List<String>> res;
    public List<List<String>> partition(String s) {

        res = new ArrayList();
        currList = new ArrayList();

        partition(s, 0);


        return res;

    }

    private void partition(String s, int index){

        //base
        if(index == s.length()) {
            res.add(new ArrayList(currList));
        }

        for(int i = index; i < s.length(); i++){
            //op
            String sub = s.substring(index, i+1);

            if(isPalindrome(sub)){
                currList.add(sub);

                //recurse
                partition(s, i+1);


                //backTrack
                currList.remove(currList.size()-1);

            }

        }
    }

    private boolean isPalindrome(String s){

        int left = 0, right = s.length()-1;

        while(left < right){
            if(s.charAt(left) != s.charAt(right)) return false;

            left++;
            right--;
        }

        return true;

    }
    public static void main(String[] args) {

    }
}
