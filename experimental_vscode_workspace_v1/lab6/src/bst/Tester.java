package bst;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test; 
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

class Tester {
    private BinarySearchTree<Integer> intBST;
    private BinarySearchTree<String> stringBST; 

    @BeforeEach
    void setUp(){
        intBST = new BinarySearchTree<Integer>();
        stringBST = new BinarySearchTree<String>();
    }

    @AfterEach
    void tearDown(){
        intBST = null; 
        stringBST = null; 
    }

    @Test
    void testHeight(){
        for (int i = 0; i < 10; i++){
            intBST.add(i);
            assertEquals(i, intBST.height(), "fel längd!");
            stringBST.add(String.valueOf(i));
            assertEquals(i, stringBST.height(), "Fel längd!");
        }

    @Test
    void test

    }
}
