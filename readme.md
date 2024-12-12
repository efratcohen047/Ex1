# Ex1: Number Base Converter

This project implements functions for handling numbers in different bases (2-16) with the following main functionalities:

## Features
* `isNumber(String num)`: Validates if a string represents a valid number in given base
* `number2Int(String num)`: Converts a number from any base to decimal
* `int2Number(int num, int base)`: Converts a decimal number to specified base
* `equals(String n1, String n2)`: Compares two numbers in different bases
* `maxIndex(String[] arr)`: Finds index of maximum value in array of numbers

## Number Format
* Regular decimal numbers: "123"
* Base-specified numbers: "numbB" where:
  * num = number in specified base
  * b = base indicator
  * B = base (2-9 or A-G for bases 10-16)
  * Example: "101b2" (5 in binary)

## Examples
isNumber("101b2")    // true (valid binary)
number2Int("101b2")  // 5 (binary to decimal)
int2Number(5, 2)     // "101b2" (decimal to binary)
equals("101b2", "5") // true (5 in binary equals 5)
