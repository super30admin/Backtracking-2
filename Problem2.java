//Palindrome partitioning

//tc O(n*2^n)
//sc-(n)
//backtracking iterative
import java.util.*;
public class Problem2 {
    public static void main(String[] args){
        Problem2 p = new Problem2();
        p.partition("aab");
        System.out.println(res);

    }
    public static List<List<String>> res = new ArrayList<>();
    public List<List<String>> partition(String s) {
        if(s== null || s.length()==0){
            return res;
        }
        helper(s, 0, new ArrayList<>());
        return res;
    }
    public void helper(String s, int index, List<String> path){
        //base
        if(index == s.length()){
            res.add(new ArrayList<>(path));
            return;
        }
        
        
        //logic
        for(int i = index; i< s.length(); i++){
            if(isPalindrome(s,index,i)){
                path.add(s.substring(index,i+1));
                helper(s,i+1,path);
                path.remove(path.size()-1);
            }
            
        }
        
    }
    public boolean isPalindrome(String s, int l, int r){
        if(l==r){
            return true;
        }
        while(l < r){
            if(s.charAt(l) != s.charAt(r)){
                return false;
            }
            l++;
            r--;
        }
        return true;
    } 

}
