//Time Complexity: O(n * (2^n))
//Space Complexity: O(n)
//runs successfully
//didn't face any problems


import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning131LeetCode {

    List<List<String>> result;                      //creating the result list

    public List<List<String>> partition(String s) {

        result = new ArrayList<>();
        partition(s, 0, new ArrayList<>());         //calling the function
        return result;

    }

    private void partition(String s, int index, List<String> list){

        if(index == s.length()){            //if index == s length, which means we get the palindrome partitioning, so that we need to add the list into result list
            result.add(new ArrayList<>(list));
            //return;
        }

        for(int i = index; i<s.length(); i++){      //iterating through string

            String temp = s.substring(index, i+1);  //getting each substring, starting from 1 length substring

            if(isPalindrome(temp)){             //check if that string is palindrome or not

                list.add(temp);             //if yes, then add to the list
                partition(s, i+1, list);    //calling the recursive function with increament the index
                list.remove(list.size()-1); //backtracking the previous step and removing the last element

            }

        }

    }


    //checking the string is palindrome or not
    private boolean isPalindrome(String s){

        int i= 0;
        int j = s.length()-1;

        while(i<j){

            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

}