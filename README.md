# coding-problems

# deduplication
Problem statement:
Given an array of int values, remove the duplicate values without using any inbuilt Collection API such as Set

Solution: DeDup.java

The static method removeDuplicates(int arrayOfInt[]), removes the duplicate values in the Array and return the unique values as an Array

For example for the input {-1, 1, 10, 1, 1000, 10} the method would return {-1, 1, 10, 1000}, the values would be in arbitrary order.

The oterh method removeDuplicatesKeepOrder(int arrayOfInt[]) return the values in the same order without duplicates however it uses static varible to hold the data and not Thread safe, this code needs to be modifed to use local variable to make it Thread safe.
