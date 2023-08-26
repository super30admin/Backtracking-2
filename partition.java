import java.util.ArrayList;
import java.util.List;

public class Solution {
    List<List<String>> partitions;

    public List<List<String>> partition(String inputStr) {
        partitions = new ArrayList<>();
        generatePartitions(inputStr, 0, new ArrayList<>());
        return partitions;
    }

    private void generatePartitions(String inputStr, int startIndex, List<String> currentPartition) {
        if (startIndex >= inputStr.length()) {
            partitions.add(new ArrayList<>(currentPartition));
        }

        for (int endIndex = startIndex; endIndex < inputStr.length(); endIndex++) {
            if (isPalindrome(inputStr, startIndex, endIndex)) {
                currentPartition.add(inputStr.substring(startIndex, endIndex + 1));
                generatePartitions(inputStr, endIndex + 1, currentPartition);
                currentPartition.remove(currentPartition.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String inputStr, int left, int right) {
        if (left == right) return true;
        while (left < right) {
            if (inputStr.charAt(left) != inputStr.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String s = "aab";
        List<List<String>> output = sol.partition(s);
        System.out.println(output);  // ans: [[a, a, b], [aa, b]]
}
}
