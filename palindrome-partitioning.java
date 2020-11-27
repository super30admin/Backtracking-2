//Time complexity: O(n*2^n)
//Space complexity: O(N)
//Attempted on leetcode and accepted
class Solution {
    public List<List<String>> partition(String s) 
    {
       //result list
       List<List<String>> list = new ArrayList<>();
        //backtrack 
       backtrack(list, new ArrayList<>(), s, 0);
        //return result list
       return list;
    }

public void backtrack(List<List<String>> list, List<String> tempList, String s, int start)
    {
    //if start index is length of string then add the temp list t o resultant list
       if(start == s.length())
          list.add(new ArrayList<>(tempList));
       else{
           //Iterate over the string from start index
          for(int i = start; i < s.length(); i++){
              //Check if it is palindrome between start index and i+1
             if(isPalindrome(s, start, i)){
                 //add the substring to temp list
                tempList.add(s.substring(start, i + 1));
                 //call backtrack function recursively for start index i+1
                backtrack(list, tempList, s, i + 1);
                 //Remove the last value in templist
                tempList.remove(tempList.size() - 1);
             }
          }
       }
    }
    //function to check if string is palindrome
    public boolean isPalindrome(String s, int low, int high){
        //while low point less thab high point 
       while(low < high)
           //Check if values at the 2 points are equal if not return false not a palindrome
          if(s.charAt(low++) != s.charAt(high--)) return false;
        //else return true
       return true;
    }
}