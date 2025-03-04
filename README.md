# Backtracking-2

## Problem1 
Subsets (https://leetcode.com/problems/subsets/)

# Backtracking
# Initialize array of lists for result and path stack, check for initial condition and return empty 
# array.
# Helper function that consists of an pivot element, path and result array. 
# For loop based recusrion that will go over all the elements and generate list. Append the list before
# the for loop so that all the paths are maintained correctly.
# Return the result list of lists.

## Problem2

Palindrome Partitioning(https://leetcode.com/problems/palindrome-partitioning/)

# Initialize the result and path array.
# Define the Palindrome function to check if the first and last character of the string are the same
# and increment the left parameter and decrement the right parameter until they cross each other.
# Backtracking function - Base case: When length of the string is equal to length, append the path list 
# to the result array.
# Logic - Run a for loop on the pivot element to length of string and from each character check if the 
# substring (using the pivot and character index) is a Palindrome. Pop the path array.
# Return the result array that is list of lists.

