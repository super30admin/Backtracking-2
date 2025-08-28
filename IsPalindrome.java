// This solution uses a recursive approach to grab the palindromic substrings to generate the required partitions.
class Solution {
    List<List<String>> response = new ArrayList();
    public List<List<String>> partition(String s) {
        divideString(s, 0, new ArrayList());
        return response;
    }

    private void divideString(String s, int pivot, List<String> st) {
        if(pivot==s.length()) {
            response.add(new ArrayList(st));
            return;
        }

        // We start with pivot and traverse through all the left over elements
        for(int i=pivot;i<s.length();i++) {
            // Get the substring starting from the pivot as we cannot break the elements
            String temp = s.substring(pivot, i+1);
            if(isPalindrome(temp)) { // Proceed only if its palindrome
                st.add(temp);
                divideString(s, i+1, st);
                st.remove(st.size()-1);
            }      
        }
    }

    private boolean isPalindrome(String s) {
        int i=0, j=s.length()-1;
        while(i<=j) {
            if(s.charAt(i)==s.charAt(j)) {
                i++;
                j--;
            } else {
                return false;
            }
        }
        return true;
    }
}
