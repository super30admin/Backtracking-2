package com.javadwarf.backtracking.leetcode;

import java.util.ArrayList;
import java.util.List;

//o/p = [["a","b","a"],["aba"]]
public class _131_PalindromePartitioning {

	public static void main(String[] args) {
		System.out.println(new _131_PalindromePartitioning().partition("aba"));
	}

	List<List<String>> res = null;

	public List<List<String>> partition(String s) {
		res = new ArrayList<>();
		partition(0, s, new ArrayList<String>());
		return res;
	}

	public void partition(int pos, String s, List<String> temp) {

		if(pos==s.length()) {
			res.add(new ArrayList<String>(temp));
			return;
		}
		for(int i=pos; i<s.length(); i++) {
			if(isPalindrom(s, pos, i)) {
				temp.add(s.substring(pos, i+1));
				partition(i+1, s, temp);
				temp.remove(temp.size()-1);
			}
		}
	}

	public boolean isPalindrom(String s, int start, int end) {
		while(start<end) {
			if(s.charAt(start++) != s.charAt(end--)) return false;
		}
		return true;
	}
}
