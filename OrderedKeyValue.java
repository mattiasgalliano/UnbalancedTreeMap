/*
Mattias Galliano 3347016
COP-3530 Data Structures
Programming Assignment 3:
Balanced/Unbalanced Trees

OrderedKeyValue.java

Description:
This class is designed to provide ordered key-value objects,
with string keys and integer values, and helpful key-comparison
methods, for use within nodes in tree data structures.

Input:
n/a

Process:
n/a

Output:
n/a

Dependencies:
n/a

Instructions:
javac OrderedKeyValue.java
*/

public class OrderedKeyValue implements Comparable<OrderedKeyValue> {

    String key;
    int value;
    
    /**
     * Constructor creates OrderedKeyValue with input string as key,
     * integer as value.
     * @param s
     * @param i
     */
    public OrderedKeyValue (String s, int i)
    {
        key = s;
        value = i;
    }

    /**
     * Method compares this OrderedKeyValue object to another passed in,
     * specifically comparing their string keys numerically by comparing
     * the sum of equivalent character arrays according to their unicode
     * code point values. This comparison is represented as a returned
     * integer difference between said array sums.
     */
    public int compareTo(OrderedKeyValue okv)
    {
        char[] okvArray = okv.key.toCharArray();
        char[] thisArray = this.key.toCharArray();

        int okvSum = toValue(okvArray);
        int thisSum = toValue(thisArray);

        return okvSum - thisSum;
    }

    /**
     * Helper method converts character array to lowercase then
     * sums characters in the array according to their corresponding
     * unicode code point values and returns the sum.
     * @param a
     * @return
     */
    private int toValue(char[] a)
    {
        int sum = 0;

        for (int i = 0; i < a.length; ++i)
        {
            a[i] = Character.toLowerCase(a[i]);
            sum += Character.getNumericValue(a[i]);
        }

        return sum;
    }
}