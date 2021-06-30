
// Time - O(N * 2^N)
// Space - O(N)



// Jaspreet's solution


class Solution {
    List<List<String>> result;
    public List<List<String>> partition(String s) {
        result = new ArrayList<List<String>>();
        backTrack(s, new ArrayList<>());
        return result;

    }

    private void backTrack(String s, List<String> path) {


        // base case
        if(s.length() == 0) {
            result.add(new ArrayList<>(path));
            return;

        }


        //logic

        for(int i = 0; i < s.length(); i++) {

            if(isPalindrome(s,0,i)) {

                // add current substring in the current list

                path.add(s.substring(0, i + 1));

                // recurse from end + 1; next position after the current ends
                backTrack(s.substring(i+1), path);

                //backtrack

                path.remove(path.size() - 1);

            }



        }





    }

    // check if it is palindrome
    private boolean isPalindrome(String s, int low, int high) {

        while(low < high) {

            if(s.charAt(low++) != s.charAt(high--)) return false;

        }

        return true;


    }


}



class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<List<String>>();
        backTrack(0, result, new ArrayList<String>(), s);
        return result;

    }

    private void backTrack(int start,List<List<String>> result, List<String> currentList, String s) {


        // base case

        if(start >= s.length()) result.add(new ArrayList<>(currentList));

        //logic

        for(int end = start; end < s.length(); end ++) {

            if(isPalindrome(s,start,end)) {

                // add current substring in the current list

                currentList.add(s.substring(start, end + 1));

                // recurse from end + 1; next position after the current ends
                backTrack(end + 1, result,currentList,s);

                //backtrack

                currentList.remove(currentList.size() - 1);

            }



        }





    }

    private boolean isPalindrome(String s, int low, int high) {

        while(low < high) {

            if(s.charAt(low++) != s.charAt(high--)) return false;

        }

        return true;


    }


}


