% Introductory Computer Science 2
% Week 12: Searching and Sorting
% Bryan Wodi

# Last week

> * Recursion

# This week and next

Searching, sorting, comparing algorithms

#
## Searching

Look for an item in a list of items.

We've done this!

We'll look at 2 - Linear search and Binary search

#
## Linear serach

Look at one item at a time, go through the list

`return` when we find the element

#
## Binary search

We did this last week

> * Can be done with a loop
> * Can be done with recursion
> * Data must be sorted!
> * See BinarySearch.java for both versions

#
## How do we compare them


| List size | Linear | Binary |
|----|----|----------|--------|
| 10 | 10 | 4 |
| 20 | 20 | 5 |
| 1M | 1M | 10 |
| 1B | 1B | 30 |

#
## How can we compare them, generally

By input size, call it $n$

* At worst, Linear search does $n$ operations
* At worst, Binary search does $log_2{n}$

#
## About $n$

There is some constant overhead ($c$), and possibly $m$ operations per $n$

But consider:

$$\lim_{n\to\infty} mn + c$$

we just get $n$

#
## $n\to\infty$, really?

Yeah! Can the algorithm scale? How badly does it scale?

It helps keep the mathematical representation of the algorithm simple, too.

#
## Big Oh

The 'order' of the algorithm.

> * Linear search is O(n)
> * Binary search is O(log n)
>    * The 2 doesn't really matter

#
## Orders

* $O(log n)$ – very fast – doubling n adds c to time
* $O(n)$ – linear – double n and double the time
* $O(n log n)$ – not much slower than O(n)
* $O(n^2)$ – slow – double n, 4 times the time
* $O(n^3)$ – slower – double n, 8 times the time
* All of the above are "polynomial" time, which is considered "computable". (But might not be, really.)
* $O(e^n)$ – exponential – double n, square the time
* grows more quickly than any polynomial – considered “not computable”.

#
## So, always binary search, right?

Yes, if it's already sorted.

But, keeping an array sorted isn't free...

#
## Simple Sorting

How do we sort a list?

> * Selection sort
> * Insertion sort
> * Bubble sort

All have different perks

#
## Sorting 2

We won't cover them all in detail. These are all $O(n^2)$

[Visualization](https://www.cs.usfca.edu/~galles/visualization/ComparisonSort.html)

#
## Selection sort

> * Start at spot 1
> * Find the smallest (search)
> * swap it in spot 1
> * step to spot 2, find the smallest...
> * See [this video](https://www.youtube.com/watch?v=g-PGLbMth_g)

#
## Selection sort analysis

* Have to run the algorithm for each element - 1
    * $O(n - 1) \to O(n)$
* Searching for what to select average $n/2$ operations
    * $O(n/2) \to O(n)$
* The search is run $n-1$ times
    * $O(n) * O(n) \to O(n^2)$

#
## 
![](images/printyo.png)


#
## Insertion sort

> * Start with a sorted part of the array, size 1
> * Take item in spot 2, insert it into place, so we have an ordered array of size 2
> * Take item in spot 3, insert into place....
> * See [this video](https://www.youtube.com/watch?v=JU767SDMDvA)

#
## Insertion sort analysis

* Have to run the algorithm for each element - 1
    * $O(n - 1) \to O(n)$
* Searching for where to insert average $n/2$ operations
    * $O(n/2) \to O(n)$
* The search is run $n-1$ times
    * $O(n) * O(n) \to O(n^2)$

#
## Bubble sort

My personal favorite: The slowest, unless it's the fastest.

* Compare 1st and 2nd element, swap so they are in order
* Compare 2nd and 3rd element, swap so they are in order
* ... until we are at the end of the array. 
  * The highest element will "bubble" its way to the right with each iteration
* do this n times
* See [this video](https://www.youtube.com/watch?v=xli_FI7CuzA)

#
## Bubble sort anaylsis

* Swapping n-1 times, $O(n-1)$
* Run the algorithm $O(n-1)$ times
* $O(n-1) * O(n-1) \to O(n^2)$
* Is there any optimizations we can do?
    * What if the list is sorted... stop! $\Omega{(n)}$
    * Best-case analysis!

#
## 
![](images/growth.jpg)

#
## Advanced sorting

> * Shell sort
> * Quick sort
> * Merge sort

#
## Shell sort

Shuffling takes time, how do we minimize it?

Do a rough sort - sort every 3rd element before a "good" sort

* Why?...

#
## Mostly sorted lists...

* Insertion sort runs faster - less swapping
* Bubble sort would take fewer executions
* Selection sort unaffected

#
## Rough sorting

Don't compare to a neighbour, compare to an item $k$
items down the list. Do insertion sort moving by $k$s.

> * Swap a[0] with a[0+k], a[0+2k]
> * Swap a[1] with a[1+k], a[1+2k]
> * Do for all k

#
## What does that look like?

[Great visualization here](https://www.cs.usfca.edu/~galles/visualization/ComparisonSort.html)

#
## Shell sorting

If we have lots of data:

* make k huge number that is a power of 3 (say $3^4 \to 81$)
* Next step, k = $3^3$ (27)
* k = $3^2$
* k = $3^1$
* k = 1 - this is a normal insertion sort
* See [this video](https://www.youtube.com/watch?v=qzXAVXddcPU)

#
## How is this faster?

We did an insertion sort as the last step! That's $O(n^2)$

Yes...  but the last sort functionally works as $O(3n)$

* Roughly $O(n^{1.25})$
* Worse than $O(n log n)$, better than $O(n^2)$

#
## Advanced sorts

Can we do better using our best friend, recursion?

What recursive cases can we make?

We'll cover two:

* Merge sort
* Quick sort

#
## Merge sort

First, merging 2 arrays:

Possible to do in-place, but how do we merge 2 ordered arrays so the resulting array is in order?

#
## How?

Keep an index into each array, choose the lowest.

#
## Now... how we sort an array

* Cut the array down into halves
* Are these halves sorted? .... No....
* What about an array of size 1? YES!

#
## Whoa

We end up with $n$ sorted arrays

Put them back together!

See [this video](https://www.youtube.com/watch?v=4VqmGXwpLqc)

#
## Algorithm:

```
mergesort(a[]) {
    if (a.length > 1) {
        part1 = mergesort( subarray(a, start, end/2))
        part2 = mergesort( subarray(a, end/2, end))
        return merge(part1, part2)
    }
    return a
```

#
## Analysis

Breaking it into pieces - $O(log{n})$

Putting it back together - $O(n)$

So... $O(n log{n})$

#
## QuickSort

Mergesort can be written in-place (but it's hard). Quicksort
easily does all the work in-place.

Pros and cons... stay tuned.

#
## The algorithm

* Choose an element from the array - call it a pivot
* Order the array:
    * Everything to the left of the pivot is less than pivot
    * Everything to the right of the pivot is greater than pivot
* quicksort(left), quicksort(right)
* Done
* See [this video](https://www.youtube.com/watch?v=Hoixgm4-P4M)

#
## The pivot

Quicksort lives and dies by the pivot

* What happens if we choose the smallest element
    * World's worst insertion sort
* What about greatest
    * Same...
* Ideally we choose the middle-most element

#
## Pivot decisions

* Choose first
    * What if array is already ordered?
* Check 3 - first, middle, last. Choose middle
    * Good idea!**
* Check entire array for middlemost
    * selection sort?


#
## Quicksort Algorithm: ([Wikipedia](https://en.wikipedia.org/wiki/Quicksort#Lomuto_partition_scheme))

```java
algorithm quicksort(A, lo, hi) is
    if lo < hi then
        p := partition(A, lo, hi)
        quicksort(A, lo, p - 1)
        quicksort(A, p + 1, hi)

algorithm partition(A, lo, hi) is
    pivot := A[hi]
    i := lo
    for j := lo to hi do
        if A[j] < pivot then
            swap A[i] with A[j]
            i := i + 1
    swap A[i] with A[hi]
    return i

```



#
## Quicksort analysis

Worst case, it's a insertion sort - $O(n^2)$

Best case:

* Pivoting $O(n)$
* $log{n}$ recursive calls
* $O(n log{n})$


#
## Quicksort, conclusion

Great on randomly ordered data

Horrible on sorted data

#
## Sorting, wrap-up

Which should you choose?

* `¯\_(ツ)_/¯`
* Know your data, then choose
* [Great video](https://www.youtube.com/watch?v=kPRA0W1kECg )
* [Sorts, visualized](https://imgur.com/gallery/voutF)

#
## 
![](images/legend.jpg)


#
## Acknowledgements

Slides contain materials from R. Guderian (2019)

Memes from [reddit](https://www.reddit.com/r/ProgrammerHumor)
