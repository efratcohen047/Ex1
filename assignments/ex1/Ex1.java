package assignments.ex1;

public class Ex1 {

    public static boolean isNumber(String num) {
        //first checks of the input
        if (num == null || num.isEmpty() || num.length() <3) {
            return false;
        }
        // make sure b is in right place
        int bPlace = num.indexOf('b');
        if (bPlace <= 0 || bPlace == num.length() - 1) {
            return false;
        }
        // figure out what base is the input
        char baseChar = num.charAt(bPlace + 1);
        int base;
        if (baseChar >= 'A' && baseChar <= 'G') {
            base = baseChar - 'A' + 10; //convert A-G to 10-Hexa
        } else if (baseChar >= '2' && baseChar <= '9') {
            base = baseChar - '0';  //convert '2' - '9' to 2-9
        } else {
            return false;
        }
        //check the digits before 'b'
    String numBefore = num.substring(0, bPlace);
        for (char digit : numBefore.toCharArray()) {
            int digitValue;
            if ( digit >= '0' && digit <= '9') {
                digitValue = digit - '0';
            } else if (digit >= 'A' && digit <= 'F') {
                digitValue = digit - 'A' + 10;
            } else {
                return false;
            }
            //check if digits are valid in this base
            if (digitValue >= base) {
                return false;
            }
        }
            boolean ans = true;
        return ans;
    }
}

public static int number2Int (String num) {
    // check validity using isNumber function
    if (!Ex1.isNumber(num)) {
        return -1;
    }
    // work through regular int - without 'b'
    int bPlace = num.indexOf('b');
    if (bPlace == -1) {
        try {
            return Integer.parseInt(num);
        } catch (NumberFormatException e) {
            return -1;
        }
    }
    // get the number part and base
    String numBefore = num.substring(0, bPlace);
    char baseChar = num.charAt(bPlace + 1);
    int base;

    if (baseChar >= 'A' && baseChar <= 'G') {
        base = baseChar - 'A' + 10;
    } else {
        base = baseChar - '0';
    }
    // convert to decimal
    int result = 0;
    for (int i = 0; i < numBefore.length(); i++) {
        char digit = numBefore.charAt(i);
        int digitValue;

        if (digit >= '0' && digit <= '9') {
            digitValue = digit - '0';
        } else {
            // convert A-F to 10-15
            digitValue = digit - 'A' + 10;
        }
        //for each digit- multiply current result by base and add new digit
        result = result * base + digitValue;
    }
    return result;
}

   // check if inputs are valid- new function
    public static String int2Number(int num, int base) {
        if (num < 0 || base < 2 || base > 16) {
            return ""; // return empty string for invalid input
        }
        // handle special case of 0
        if (num == 0) {
            // return "0b" plus the base
            return "0b" + (base <= 9 ? base : (char) ('A' + (base - 10)));
        }
        // convert number to wanted base
        StringBuilder result = new StringBuilder();
        int tempNum = num;

        while (tempNum > 0) {
            int digit = tempNum % base;
            // convert digit to character
            char digitChar;
            if (digit < 10) {
                digitChar = (char) ('0' + digit); // 0-9
            } else {
                digitChar = (char) ('A' + (digit - 10)); // A-F
            }

            result.insert(0, digitChar);
            // divide number by base
            tempNum /= base;
        }
        // add the 'b' and base indicator
        result.append('b');
        if (base <= 9) {
            result.append(base);
        } else {
            result.append((char) ('A' + (base - 10)));
        }
        return result.toString();
    }

    public static boolean equals(String n1, String n2) {
        // convert both numbers to decimal using number2Int
        int val1 = number2Int(n1);
        int val2 = int2Number(n2);
        // if either conversion returned -1, they're invalid
        if (val1 == -1 || val2 == -1) {
            return false;
        }
        // compare the decimal values
        return val1 == val2;
    }


    public static int maxIndex(String[] arr) {
        // check empty or null array
        if (arr == null || arr.length == 0){
          return 0;
      }
        // start with first element
        int maxIndex =0;
      int maxValue = number2Int(arr[0]);
        // compare with rest of array
      for (int i = 1; i < arr.length; i++){
          int currentValue= number2Int(arr[i]);
          // update max if current value is larger
          if (currentValue > maxValue) {
              maxValue = currentValue;
              maxIndex = i;
          }
      }
        return maxIndex;
    }
}
