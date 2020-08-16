/*
Mattias Galliano 3347016
COP-3530 Data Structures
Programming Assignment 3:
Balanced/Unbalanced Trees

UnbalancedTreeMap.java

Description:
This class is designed to provide binary tree data structure objects 
containing nodes with ordered key-value objects. The class contains
multiple functional and helper methods designed for use with the
binary tree with key-value nodes. The unbalanced tree class is later
compared against a native java tree map class.

Input:
n/a

Process:
n/a

Output:
n/a

Dependencies:
BinaryNode.java OrderedKeyValue.java

Instructions:
javac UnbalancedTreeMap.java BinaryNode.java OrderedKeyValue.java
*/

public class UnbalancedTreeMap {
    BinaryNode root;

    /**
     * Constructs tree map with empty (null) root
     */
    UnbalancedTreeMap()
    {
        root = null;
    }

    /**
     * Constructs tree map with passed ordered key value as root
     */
    UnbalancedTreeMap(OrderedKeyValue okv)
    {
        root = new BinaryNode(okv);
    }

    /**
     * Get method searches binary tree to see if any node in tree
     * stores key value object which matches parameter key. If found,
     * returns value associated with key, else returns 0.
     * @param key
     * @return
     */
    public int get(String key) // traverse for key to return value
    {
        if (root == null) {return 0;} // if tree empty return 0

        BinaryNode current = root;

        while (current != null)
        {
            if (key.compareTo(current.keyValue.key) == 0) // if match return node value
            {
                return current.keyValue.value;
            }
            else if (key.compareTo(current.keyValue.key) < 0) // if less than examine left child
            {
                current = current.leftChild;
            }
            else // else examine right child
            {
                current = current.rightChild;
            }
        }

        return 0; // if no children remain, return 0
    }

    /**
     * Put method searches through tree, similar to get method, except that
     * if a node key matches the parameter key, the node's value is replaced
     * with the passed parameter value. Otherwise, if no match is found, a
     * new node is inserted in the tree, containing the passed key and value,
     * at the appropriate position and 0 is returned.
     * @param key
     * @param value
     * @return
     */
    public int put(String key, int value) // traverse update and return, or insert and return 0
    {
        OrderedKeyValue keyValue = new OrderedKeyValue(key, value);

        if (root == null) {root = new BinaryNode(keyValue); return 0;} // if empty tree insert new node as root

        BinaryNode current = root;

        while (current != null)
        {
            if (key.compareTo(current.keyValue.key) == 0)
            {
                int previousValue = current.keyValue.value; // if match, update value
                return previousValue;
            }
            else if (key.compareTo(current.keyValue.key) < 0)
            {
                current = current.leftChild;
            }
            else
            {
                current = current.rightChild;
            }
        }
        
        insert(key, value); // if no match, insert new node into tree
        return 0;
    }

    /**
     * keySet method traverses tree in order, appending keys in order,
     * to return string array. Helpful for visualizing tree contents.
     */
    public String[] keySet() // append to list in order traversal return list
    {
        int size = size(); // determine appropriate array size for tree contents
        String[] keys = new String[size];

        appendInOrder(root, keys); // helper method

        return keys;
    }

    /**
     * Method recursively traverses tree in order and appends each node key to arry during
     * traversal.
     * @param node
     * @param keys
     */
    public void appendInOrder(BinaryNode node, String[] keys) // ** check i to append at right idx
    {
        if (node == null) {return;}

        appendInOrder(node.leftChild, keys);
        System.out.println(" key is " + node.keyValue.key);
        append(keys, node.keyValue.key); // append node key to array
        appendInOrder(node.rightChild, keys);
    }

    /**
     * Helper method ensures strings are added to array in order by adding strings to last array
     * position during in order tree traversal.
     * @param keys
     * @param key
     */
    public void append(String keys[], String key)
    {
        int i = keys.length - 1;

        while (i != 0 && keys[i-1] == null)
        {
            i--;
        }

        keys[i] = key;
    }

    /**
     * Recursively traverse each right and left child of tree to get tree size.
     * @return
     */
    public int size()
    {
        return size(root);
    }

    public int size(BinaryNode node)
    {
        if (node == null) {return 0;}
        else {return size(node.leftChild) + 1 + size(node.rightChild);}
    }

    /**
     * Insert method takes passed key and value parameters, constructs a
     * key value pair object, then constructs a node object containing the
     * pair, then inserts the node into the tree.
     * @param key
     * @param value
     */
    public void insert(String key, int value)
    {
        OrderedKeyValue okv = new OrderedKeyValue(key, value);
        BinaryNode node = new BinaryNode(okv);

        if (root == null)
        {
            root = node;
            node.leftChild = null;
            node.rightChild = null;
        }
        else
        {
            BinaryNode current = root;
            while (current != null)
            {
                if (node.keyValue.key.compareTo(current.keyValue.key) < 0)
                {
                    if (current.leftChild == null)
                    {
                        current.leftChild = node;
                        current = null;
                    }
                    else
                    {
                        current = current.leftChild;
                    }
                }
                else
                {
                    if (current.rightChild == null)
                    {
                        current.rightChild = node;
                        current = null;
                    }
                    else
                    {
                        current = current.rightChild;
                    }
                }
            }
            node.leftChild = null;
            node.rightChild = null;
        }
    }
}
