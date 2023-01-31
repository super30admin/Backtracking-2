package main

import "fmt"

// Time : n2^n
// Space :
func partition(s string) [][]string {
	result := [][]string{}
	var helper func(s string, path []string, idx int)
	helper = func(s string, path []string, idx int) {
		//base
		if idx == len(s) {
			newPath := make([]string, len(path))
			copy(newPath, path)
			result = append(result, newPath)
			return
		}
		// logic
		for i := idx; i < len(s); i++ {
			ss := s[idx : i+1]
			fmt.Println(ss)
			if isPalindrom(ss) {
				path = append(path, s[idx:i+1])
				helper(s, path, i+1)
				path = path[:len(path)-1]
			}
		}
	}
	helper(s, []string{}, 0)
	return result
}

func isPalindrom(str string) bool {
	reversedStr := ""
	for i := len(str) - 1; i >= 0; i-- {
		reversedStr += string(str[i])
	}
	for i := range (str) {
		if str[i] != reversedStr[i] {
			return false
		}
	}
	return true
}