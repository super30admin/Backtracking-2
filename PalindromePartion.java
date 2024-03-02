// Time Complexity : O(n * 2 ^ n)
// Space Complexity : O(n * 2 ^ n))
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

import java.util.ArrayList;
import java.util.List;

class Solution {
    List<List<String>> results;

    public List<List<String>> partition(String s) {
        this.results = new ArrayList<>();

        // helperIterativeRecursion(s, 0, new ArrayList<>());
        helperRecursion(s, 0, 0, new ArrayList<>(), 0);
        return results;
    }

    private void helperRecursion(String s, int pivot, int idx, List<String> path, int cnt) {
        //base
        if(idx == s.length()) {
            if(cnt == s.length()) {
                results.add(new ArrayList<>(path))
            }
            return;
        }

        //logic
        //don't choose
        helperRecursion(s, pivot, idx+1, path, cnt);

        //choose
        String currSub = s.substring(pivot, idx + 1);
        if(isPalindrome(currSub)) {
            //action
            path.add(currSub);

            //recurse
            helperRecursion(s, idx+1, idx+1, path, cnt + currSub.length());

            //backtrack
            path.remove(path.size() -1);
        }
    }

    private void helperIterativeRecursion(String s, int pivot, List<String> path) {
        // System.out.print("pivot: "  + pivot);
        //     System.out.println("      path:" +  path);
        //base
        if(pivot == s.length()) {
            results.add(new ArrayList<>(path));
            return;
        }


        //logic  
        for(int i = pivot; i < s.length(); i++) {

            String currSub = s.substring(pivot, i + 1);

            // System.out.println("currSub: " + currSub + "    i: " + i + "    pivot: "  + pivot);
            if(isPalindrome(currSub)) {

                //action
                path.add(currSub);
                //recurse
                helperIterativeRecursion(s, i + 1, path);
                //backtrack
                path.remove(path.size() -1);
            }
        }

    }

    private boolean isPalindrome(String s) {
        int l = 0;
        int h = s.length() - 1;
        while (l < h) {
            if (s.charAt(l) != s.charAt(h)) {
                return false;
            }
            l++;
            h--;
        }
        return true;
    }
}