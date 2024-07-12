# Section 12. Recursion
https://en.wikipedia.org/wiki/Recursion_(computer_science)

## Concepts
### What is Recursion?
https://en.wikipedia.org/wiki/Recursion_(computer_science)

```
In computer science, recursion is a method of solving a computational problem where the solution depends on solutions to smaller instances of the same problem. Recursion solves such recursive problems by using functions that call themselves from within their own code. The approach can be applied to many types of problems, and recursion is one of the central ideas of computer science.
```

### Stack Overflow
https://en.wikipedia.org/wiki/Stack_overflow

```
In software, a stack overflow occurs if the call stack pointer exceeds the stack bound. The call stack may consist of a limited amount of address space, often determined at the start of the program. The size of the call stack depends on many factors, including the programming language, machine architecture, multi-threading, and amount of available memory. When a program attempts to use more space than is available on the call stack (that is, when it attempts to access memory beyond the call stack's bounds, which is essentially a buffer overflow), the stack is said to overflow, typically resulting in a program crash.
```

### Rules of Building Recursive Functions
1. Identify the base case
2. Identify the recursive case
3. Get closer and closer and returm when needed. Usually you have to two returns

### When to use Recursion?
1. When use a tree or convert something into a tree, consider recursion
   * Divide a problem into a number of sub-problems.
   * Each instance of sub-problem is identical in nature (aka the way to resolve them is always the same).
   * The solutions of each sub-problem can be combined to solve the problem at hand.
2. Divide and conquer using recursion

**Pros:**
* DRY
* Readability

**Cons:**
* Large stack
* Time complexity


## Reference
Taill call optimization: https://2ality.com/2015/06/tail-call-optimization.html

Tail call: https://en.wikipedia.org/wiki/Tail_call

Samples of using recursion: https://stackoverflow.com/questions/105838/real-world-examples-of-recursion
