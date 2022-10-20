import java.util.List;

//approach-1 Backtracking
//for loop based recursion
//first we check 1 element at a time and see if it's a palindrom, if so, then only we make recursion calls to the next instance. 
// before making next recursion call, we add the verified palindrome string to our local path 
//next call should be always at i+1. 
//base case - we will come here only if palindrome condition is true, otherwise for loop will exit us. 
//in base case, add the local path to the main result and then return 
//TC - exponential , 2^n
//SC - recursive stack - 2^n

class Solution {
    List<List<String>>  result;
    
    public List<List<String>> partition(String s) {
        result = new ArrayList<>();
        
        if(s== null || s.length() == 0) return result;

        helper(s, 0, new ArrayList<>());

        return result;
    }

    private void helper(String s, int index, List<String> path)
    {
        //base case
         if(index == s.length())
         {
             result.add(new ArrayList<>(path));
             return;   
         }  

        //logic

        for(int i = index; i< s.length(); i++)
        {
            if(isPalindrome(s, index, i))
            {
                path.add(s.substring(index, i+1));
                helper(s, i+1, path);

                //backtrack
                path.remove(path.size() -1);
            }
        }
    }

    private boolean isPalindrome(String s, int left, int right)
    {
        while(left <= right)
        {
            if(s.charAt(left) != s.charAt(right))
            {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}


//approach -2 recursion (without backtracking)

class Solution {
    List<List<String>>  result;
    
    public List<List<String>> partition(String s) {
        result = new ArrayList<>();
        
        if(s== null || s.length() == 0) return result;

        helper(s, 0, new ArrayList<>());

        return result;
    }

    private void helper(String s, int index, List<String> path)
    {
        //base case
         if(index == s.length())
         {
             result.add(path);
             return;   
         }  

        //logic

        for(int i = index; i< s.length(); i++)
        {
            
            if(isPalindrome(s, index, i))
            {
                List<String> newList = new ArrayList<>(path);
                newList.add(s.substring(index, i+1));
                helper(s, i+1, newList);
            }
        }
    }

    private boolean isPalindrome(String s, int left, int right)
    {
        while(left <= right)
        {
            if(s.charAt(left) != s.charAt(right))
            {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}


//approach -3
//forloop based recursion+ bck tracking  + passing no index. 

class Solution {
    List<List<String>>  result;
    
    public List<List<String>> partition(String s) {
        result = new ArrayList<>();
        
        if(s== null || s.length() == 0) return result;

        helper(s, new ArrayList<>());

        return result;
    }

    private void helper(String s, List<String> path)
    {
        //base case
         if( s.length() == 0 )
         {
             result.add(new ArrayList<>(path));
             return;   
         }  

        //logic

        for(int i = 0; i< s.length(); i++)
        {
            if(isPalindrome(s,0,i))
            {
                path.add(s.substring(0, i+1));
                helper(s.substring(i+1), path);

                //backtrack
                path.remove(path.size() -1);
            }
        }
    }

    private boolean isPalindrome(String s, int left, int right)
    {
        while(left <= right)
        {
            if(s.charAt(left) != s.charAt(right))
            {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}

