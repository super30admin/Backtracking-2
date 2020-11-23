// Time Complexity : O(n*2Pown)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
/*
in recursive
if index is same as length of s
append it to res

for each i from index to length
if current is palindrome then
append to temp suncstring from index to i+1
call recursive with new temp and index
remove last from temp
*/
package main

import "fmt"

var res1 [][]string
func partition(s string) [][]string {
	res1 = [][]string{}
	h1(s, []string{}, 0)
	return res1
}

func h1(s string, temp []string, index int) {
	if index == len(s) {
		temp11 := append([]string(nil), temp...)
		res1 = append(res1, temp11)
	}

	for i:=index;i<len(s);i++ {
		if isPalin(s, index, i) {
			temp = append(temp, s[index:i+1])
			h1(s, temp, i+1)
			temp = temp[:len(temp)-1]
		}
	}
}

func isPalin(s string, l, r int) bool {
	if l == r {
		return true
	}
	for l < r {
		if s[l] != s[r] {
			return false
		}
		l++
		r--
	}
	return true
}

func MainPalindrome() {
	fmt.Println(partition("aab")) //expected [["aa","b"],["a","a","b"]]
}
