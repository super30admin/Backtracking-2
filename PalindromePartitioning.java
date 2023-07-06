import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class PalindromePartitioning {

        // FOR LOOP RECURSION WITH BACKTRACKING
        static List<List<String>> partPalindrome;

        public static List<List<String>> partition(String s) {

            partPalindrome = new ArrayList<>();

            forRecurseBacktrack(s, 0, new ArrayList<>());

            return  partPalindrome;

        }

        private static void forRecurseBacktrack(String s, int pivot, List<String> partStrings) {

            //base
            if(pivot == s.length()) {

                partPalindrome.add(new ArrayList<>(partStrings));
                return;
            }

            //logic
            for(int i = pivot; i < s.length(); i++) {

                String currPart = s.substring(pivot, i+1);

                if(isPalindrome(currPart)) {

                    //action
                    partStrings.add(currPart);

                    //recurse
                    forRecurseBacktrack(s, i+1, partStrings);

                    //backtrack
                    partStrings.remove(partStrings.size() - 1);
                }
            }
        }

        private static boolean isPalindrome(String s) {

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

            PalindromePartitioning object = new PalindromePartitioning();

            Scanner scanner = new Scanner(System.in);

            System.out.print("Enter a string: ");
            String input = scanner.nextLine();

            List<List<String>> result = object.partition(input);

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