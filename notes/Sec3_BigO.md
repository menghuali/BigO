# Section 3. BigO

## What is good code?
1. Readable
2. Scalable (Big O)

### What is Scalable?
Big O meatures the scalability and efficiency of your code. It shows the growth of operations as the number of elements grows. I meature how quickly the running time grows.

![image](./misc/big_o_complexity_chart.png)


#### Big O Notations
* O(1) Constant- no loops
* O(log N) Logarithmic- usually searching algorithms have log n if they are sorted (Binary Search)
* O(n) Linear- for loops, while loops through n items
* O(n log(n)) Log Liniear- usually sorting operations
* O(n^2) Quadratic- every element in a collection needs to be compared to ever other element. Two
* nested loops
* O(2^n) Exponential- recursive algorithms that solves a problem of size N
* O(n!) Factorial- you are adding a loop for every element


### How to calculate Big O notation?
```
// What is the Big O of the below function? (Hint, you may want to go line by line)
function funChallenge(input) { // O(n)
  let a = 10; // O(1)
  a = 50 + 3; // O(1)

  for (let i = 0; i < input.length; i++) {
    anotherFunction(); // O(n)
    let stranger = true; // O(n)
    a++; // O(n)
  }
  return a; // O(1)
}
```
__Conclution__: BigO = O(3 + 4n) = O(n).

#### Rules to simplify Big O calculation:
1. __Worse case__: Only count the worst case scenario.
2. __Remove constants__: Remove the constants in the Big O fomula. E.g., _O(n/2 + 4)_ should be simplified as _O(n)_
3. __Different terms for inputs__: If a function has multiple inputs ... O(a+b), O(a*b)
4. __Drop non dominant__: Always keep the dominant term. E.g., O(n + n^2) > drop O(n) > O(n^2)

### Three Pilars of Good Code
* Readable
* Speed: Time Complexity
* Memory: Space Complexitiy

#### Core of Good Programming
__Data Structure + Algorithm = Programs__

Pick right data structure, right algorithm, to write good programs. Usually, there's trade of speed and memory.

### Space Complexity: Heap and Stack
* Heap stores variables.
* Stack keeps track of function calls.

We also use Big O to meature space complexity.

The following things increases space complexity:
* Variables
* Data Structures
* Function Call
* Allocations

#### Sample
```
//#5 Space complexity O(1)
function boooo(n) {
  for (let i = 0; i < n; i++) {
    console.log("booooo");
  }
}

// #6 Space complexity O(n)
function arrayOfHiNTimes(n) {
  var hiArray = [];
  for (let i = 0; i < n; i++) {
    hiArray[i] = "hi";
  }
  return hiArray;
}

arrayOfHiNTimes(6);
```

The space complexity of above code is ... O(n)

## Reference
https://zerotomastery.io/cheatsheets/big-o-cheat-sheet/?utm_source=udemy&utm_medium=coursecontent

https://www.bigocheatsheet.com/

https://zerotomastery.io/