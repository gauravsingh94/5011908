## Understand Sorting Algorithms

- **Bubble Sort**: compares adjacent elements and swaps them if they are in the wrong order.
- **Insertion Sort**: inserts each element into its proper position in the sorted portion of the array.
- **Quick Sort**: selects a pivot element, partitions the array around it, and recursively sorts the subarrays.
- **Merge Sort**: divides the array into smaller chunks, sorts each chunk, and merges the sorted chunks back together.

### Analysis

#### Compare the Performance (Time Complexity) of Bubble Sort and Quick Sort
- **Bubble Sort**: `O(n^2)` - quadratic time complexity
- **Quick Sort**: `O(n log n)` - linearithmic time complexity

Quick Sort is generally preferred over Bubble Sort because of its faster time complexity, especially for large datasets. However, Bubble Sort can be simpler to implement and may be suitable for small datasets or specific use cases.
