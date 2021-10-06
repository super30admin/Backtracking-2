
time complexity: O(n)
space complexity: O(n)

class Solution {
    public List<List<String>> partition(String s) {
       List<List<String>> result = new ArrayList<>();
 
	if (s == null || s.length() == 0) {
		return result;
	}
 
	ArrayList<String> partition = new ArrayList<String>();//track each possible partition
	addPalindrome(s, 0, partition, result);
 
	return result;
}
 
private void addPalindrome(String s, int start, ArrayList<String> partition,
		List<List<String>> result) {
	//stop condition
	if (start == s.length()) {
		ArrayList<String> temp = new ArrayList<String>(partition);
		result.add(temp);
		return;
	}
 
	for (int i = start + 1; i <= s.length(); i++) {
		String str = s.substring(start, i);
		if (isPalindrome(str)) {
			partition.add(str); 
			addPalindrome(s, i, partition, result);
			partition.remove(partition.size() - 1);
		}
	}
}
 
private boolean isPalindrome(String str) {
	int left = 0;
	int right = str.length() - 1;
 
	while (left < right) {
		if (str.charAt(left) != str.charAt(right)) {
			return false;
		}
 
		left++;
		right--;
	}
 
	return true; 
    }
}