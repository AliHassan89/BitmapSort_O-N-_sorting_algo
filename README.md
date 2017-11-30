# BitmapSort O(N) sorting algo

This sorting algorithm takes O(n) time to sort the array. Bitmap sorting can be used when maxmimum of the array is known. 
A new byte array can be created of size of max. Traverse through the unsorted array and set the bit to true in byte array for each entry of unsorted array.
Lastly traverse through the byte array and add the set bits to sorted array.

However, the above algo does not work if we have duplicates in the array which needs to be sorted.
Inorder to solve it, we can use HashMap, as implemented in the solution.
