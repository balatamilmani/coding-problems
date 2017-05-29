# coding-problems

# deduplication
Problem statement:
Given an array of int values, remove the duplicate values without using any inbuilt Collection API such as Set

Solution: DeDup.java

The static method removeDuplicates(int arrayOfInt[]), removes the duplicate values in the Array and return the unique values as an Array

For example for the input {-1, 1, 10, 1, 1000, 10} the method would return {-1, 1, 10, 1000}, the values would be in arbitrary order.

The oterh method removeDuplicatesKeepOrder(int arrayOfInt[]) return the values in the same order without duplicates however it uses static varible to hold the data and not Thread safe, this code needs to be modifed to use local variable to make it Thread safe.

# list-adder
Problem statement:
Given Two Linked List's of int values, return its sum as Linked List

Solution: LinkedListAdder.java
The static method add(List<Integer> listOne, List<Integer> listTwo), sum the values of Two Lists and return the result in the form of Linked List.

For example for the input 
  list1: 1 -> 2 -> 3
  list2:      5 -> 6
the method retuns 
  list: 1 -> 7 -> 9
i.e. [1,2,3], [5,6] will result in [1,7,9]
