/*
Mattias Galliano 3347016
COP-3530 Data Structures
Programming Assignment 3:
Balanced/Unbalanced Trees

BinaryNode.java

Description:
This class is designed to provide nodes containing ordered key-value
objects, for use in tree data structures.

Input:
n/a

Process:
n/a

Output:
n/a

Dependencies:
OrderedKeyValue.java

Instructions:
javac BinaryNode.java OrderedKeyValue.java
*/

public class BinaryNode {
    OrderedKeyValue keyValue;
    BinaryNode leftChild;
    BinaryNode rightChild;

    /**
     * Constructs BinaryNode with OrderedKeyValue object
     * @param okv
     */
    public BinaryNode(OrderedKeyValue okv)
    {
        keyValue = okv;
        leftChild = null;
        rightChild = null;
    }
}