Task4 - How i optimize ??


To improve the Levenshtein algorithm, I implemented the space complexity from O(m × n) down to O(n) with just two one-dimensional arrays rather than a complete two-dimensional dynamic programming table.
In the default method, every cell within the matrix is used to denote the cost of transforming one substring into another, which takes up a lot of memory in large strings.Though, as every row of the matrix only relies upon the values of the previous row, there's no need to keep the whole matrix.
By keeping only the current and previous rows and updating them in each iteration, we get the same result but use much less memory. This improvement makes the algorithm more efficient and scalable with the same original O(m × n) time complexity.


github link : https://github.com/karan96108/onebanc-Project