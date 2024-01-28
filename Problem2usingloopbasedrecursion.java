 /*Approach:
*  1. Explore exhaustively by choose, not choose.
        To do this, 
            we need to keep track of start of substring and end of substring,
            so we maintain two variables, pivot and index.
        "count" is used to keep track of valid path size,
        because path should include all elements in main string.
* 
*  2. not choose case:
            move index to next position and recurse
        choose case:
            take substring from pivot to index
            check substring is palindrome or not.
            if yes,
                add to partition and increment count value by path length
                recurse with pivot and index updated to index+1.
            backtrack once recurse step is completed.
* 
*  3. When index reaches end of string, 
        check the count(length of valid partition elements) with s.length
            if equal, add partition to result
            */
            class Solution {
                //TC: O(n*2^n)
                List<List<String>> result;
                public List<List<String>> partition(String s) {
                    this.result = new ArrayList<>();
                    helper(s,0,0,new ArrayList<>(),0);
                    return result;
                }
                private void helper(String s, int pivot, int i, List<String> path, int count){
                    //base
                    if(i == s.length()) {
                        if(count == s.length()){
                            result.add(new ArrayList<>(path));
                            
                        }
                        return;
                    }
                    //logic
                    //not choose
                    helper(s, pivot, i+1, path, count);
            
                    //choose
                    String Sub = s.substring(pivot,i+1);
                    if(isPlaindrome(Sub)){
                        path.add(Sub);
                        count += Sub.length();
            
                        //move pivot and index by 1
                        helper(s, i + 1, i + 1, path, count);
            
                        path.remove(path.size() - 1);
                    }
                }
                private boolean isPlaindrome(String s){
                    int start = 0;
                    int end = s.length() - 1;
                    while(start < end){
                        if(s.charAt(start) != s.charAt(end)) return false;
                        start++;
                        end--;
                    } 
                    return true;
                }
            }