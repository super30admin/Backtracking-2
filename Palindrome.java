/*
 * Tc - o(n*2^n)
 * sc - o(n)
 * approach - generating the substrings using backtracking, and once generated 
 * we would check if it is a palindrome only then move forward. Else stop
 */


import java.util.ArrayList;
import java.util.List;

public class Palindrome {
    List<List<String>> res;
    public List<List<String>> partition(String s) {
        this.res= new ArrayList<>();
        List<String> curr = new ArrayList<>();
        // forBacktrack(curr, s, 0);
        backtrack(curr,s,0,0,0);
        return res;
    }

    //for loop based backtrack 
    public void forBacktrack(List<String> list, String s, int pivot){
        //base 
        if(pivot == s.length()){
            res.add(new ArrayList<>(list));
            return;
        }

        //backtrack
        for(int i = pivot; i < s.length(); i++){
            String substr = s.substring(pivot,i+1);
            if(isPalindrome(substr)){
                list.add(substr);
                forBacktrack(list, s, i+1);
                list.removeLast();
            }
        }
    }

    //choose /no choose backtrack
    public void backtrack(List<String> list, String s, int i, int pivot, int sum){
        //base 
        if(i == s.length()){
            if(sum == s.length()){
                res.add(new ArrayList<>(list));
            }
            return;       
        }

        //recursion
        // no choose 
        backtrack(list, s, i+1, pivot,sum);

        //choose 
        String substr = s.substring(pivot,i+1);
        if(isPalindrome(substr)){
            list.add(substr);
            backtrack(list, s, i+1, i+1, sum+substr.length());
            list.removeLast();
        }

    }


    public boolean isPalindrome(String s){
        int low = 0, high = s.length()-1;
        while(low < high){
            if(s.charAt(low++) != s.charAt(high--)){
                return false;
            }
        }

        return true;
    }
}
