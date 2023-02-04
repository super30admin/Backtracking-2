// ####### APPROACH 1: FOR LOOP RECURSION 
// Time Complexity: O(n*2^n)
// Space Complexity: O(n)

// We iterate over the string of characters and check if each substring (i.e. substring between pivot and index) is a pallindrome
// If the substring is not a pallindrome we end the recursion and go back to the upper level (in the recursion tree)
// If the substring is pallindrome, then at that node we create arrayList which is a deep copy of the path, 
// and add the current substring to it. When you hit the base case idx=s.length() you create deep copy of path and add it to the result
// or even just adding path to the result will give you a successful outcome


class Solution {
    List<List<String>> result;
    public List<List<String>> partition(String s) {
        result=new ArrayList<>();
        helper(s,0,new ArrayList<>());
        return result;
    }
    
    
    // FOR LOOP Recursion
    private void helper(String s,int idx,List<String> path){
        
        //base
        if(idx==s.length()){
            result.add(new ArrayList<>(path));
            return;
        }
        
        //logic
        for(int i=idx;i<s.length();i++){
            String partition=s.substring(idx,i+1);
            if(isPallindrome(partition)){
                
                List<String> li = new ArrayList<>(path);
                li.add(partition);
                
                helper(s,i+1,li);
            }
        }
    }
    private boolean isPallindrome(String s){
        int start=0;
        int end=s.length()-1;
        
        while(start<end){
            if(s.charAt(start)!=s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}

// ####### APPROACH 2: FOR LOOP RECURSION with BACKTRACKING
// Time Complexity: O(n*2^n)
// Space Complexity: O(n)

// Same as regular for loop based recursion but after you add the substring to the path, you pass it to the next recursive call and
// remove it.
// WHen you hit the base condition, you create a deep copy and add it to the result.

class Solution {
    List<List<String>> result;
    public List<List<String>> partition(String s) {
        result=new ArrayList<>();
        helper(s,0,new ArrayList<>());
        return result;
    }
    
    
    // FOR LOOP Recursion with BACKTRACKING
    private void helper(String s,int idx,List<String> path){
        
        //base
        if(idx==s.length()){
            result.add(new ArrayList<>(path));
            return;
        }
        
        //logic
        for(int i=idx;i<s.length();i++){
            String partition=s.substring(idx,i+1);
            if(isPallindrome(partition)){
                
                path.add(partition);
                
                helper(s,i+1,path);
                
                path.remove(path.size()-1);
            }
        }
    }
    private boolean isPallindrome(String s){
        int start=0;
        int end=s.length()-1;
        
        while(start<end){
            if(s.charAt(start)!=s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}


// ####### APPROACH 3: 0-1 Recursion
// Time Complexity: O(n*2^n)
// Space Complexity: O(n)


// Now there will not be a for loop to iterate over the string so we will use pivot and i pointers to go over the characters
// You start with the first character where i and pivot sit and then you do a choose and dont choose
// choose condition: pivot=i+1, i=i+1
// dont choose: pivot stays the same, i=i+1
// The choose case is within the condition if the partition is a pallindrome or not, dont choose we dont check for pallindrome
// dont choose we are only moving i forward
// Recursion call here will need idx but even i pointer as parameter since again, we dont use a for loop
// Base condition, we first check if i is at the end, if at the end, then if idx is at the end, then you add the path to the global result
// so idx=s.length is nested within i=s.length because children will finish processing first of the previous pivot and then goes the next pivot

class Solution {
    List<List<String>> result;
    public List<List<String>> partition(String s) {
        result=new ArrayList<>();
        helper(s,0,0,new ArrayList<>());
        return result;
        
    }
    
    // 0-1 Recursion 
    private void helper(String s,int idx,int i,List<String>path){
        //base

        if(i==s.length()){ // if i reached the end
            if(idx==s.length()){ //if idx reached the end
                result.add(path);
            } // nested condition because child for a pivot will process first so I will finish first for one pivot
              //ex. i finished for the 2nd last pivot, you go to last pivot which has no babies
            return;       
        }
        
        //logic
        
        //not choose
        helper(s,idx,i+1,path);
        
        //choose
        String partition=s.substring(idx,i+1);
        if(isPallindrome(partition)){
            
            ArrayList<String> li=new ArrayList<>(path);
            li.add(partition);
            
            helper(s,i+1,i+1,li);
         
        }
    }
    
    private boolean isPallindrome(String s){
        int start=0;
        int end=s.length()-1;
        
        while(start<end){
            if(s.charAt(start)!=s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
    
   
}



// ####### APPROACH 4: 0-1 Recursion with BACKTRACKING
// Time Complexity: O(n*2^n)
// Space Complexity: O(n)


// Same as 0-1 regular recursion, only that after choose condition when you pass it to the next recursion call, you remove the substring
// from the path
// Global result will have a deep copy of the path within nested if loops i=s.length and idx=s.length

class Solution {
    List<List<String>> result;
    public List<List<String>> partition(String s) {
        result=new ArrayList<>();
        helper(s,0,0,new ArrayList<>());
        return result;
        
    }
    
    // 0-1 Recursion with BACKTRACKING
    private void helper(String s,int idx,int i,List<String>path){
        //base

        if(i==s.length()){ // if i reached the end
            if(idx==s.length()){ //if idx reached the end
                result.add(new ArrayList<>(path));
            } // nested condition because child for a pivot will process first so I will finish first for one pivot
              //ex. i finished for the 2nd last pivot, you go to last pivot which has no babies
            return;       
        }
        
        //logic
        
        //not choose
        helper(s,idx,i+1,path);
        
        //choose
        String partition=s.substring(idx,i+1);
        if(isPallindrome(partition)){
            path.add(partition);
            
            helper(s,i+1,i+1,path);
            
            path.remove(path.size()-1);
        }
    }
    
    private boolean isPallindrome(String s){
        int start=0;
        int end=s.length()-1;
        
        while(start<end){
            if(s.charAt(start)!=s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
    
   
}