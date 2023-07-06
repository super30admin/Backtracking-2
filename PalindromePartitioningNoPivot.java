import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PalindromePartitioningNoPivot {

    // FOR LOOP RECURSION - NO PIVOT - WITH BACKTRACKING
        List<List<String>> partPalindrome;

        public List<List<String>> partition(String s) {

            partPalindrome = new ArrayList<>();

            forRecurseBacktrack(s, new ArrayList<>());

            return  partPalindrome;

        }

        private void forRecurseBacktrack(String s, List<String> partStrings) {

            //base
            if(s.length() == 0) {

                partPalindrome.add(new ArrayList<>(partStrings));
                return;
            }

            //logic
            for(int i = 0; i < s.length(); i++) {

                String currPart = s.substring(0, i+1);

                if(isPalindrome(currPart)) {

                    //action
                    partStrings.add(currPart);

                    //recurse
                    // recursion on the rest of string avoids the need of maintaining a pivot
                    forRecurseBacktrack(s.substring(i+1), partStrings);

                    //backtrack
                    partStrings.remove(partStrings.size() - 1);
                }
            }
        }

        private boolean isPalindrome(String s) {

            int start = 0;

            int end = s.length() - 1;

            while(start < end) {

                if(s.charAt(start) != s.charAt(end)) return false;

                start++;

                end--;
            }
            return true;
        }

        public static void main(String[] args){

            PalindromePartitioningNoPivot object = new PalindromePartitioningNoPivot();

            Scanner input = new Scanner(System.in);

            System.out.print("Enter a string: ");
            String str = input.nextLine();

            List<List<String>> result = object.partition(str);

            for (List<String> innerList : result) {
                for (String element : innerList) {
                   System.out.print(element + " ");
                }
            System.out.println();
            }
        }



}
/* Time Complexity = O(N*2^N)

N = Length of string,
O(N) = generate substring and check if palindrome
2^N = substrings - worst case

Space Complexity = O(N) - recursive stack in backtracking */