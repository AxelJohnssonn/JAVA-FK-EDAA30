package testqueue;

import static org.junit.jupiter.api.Assertions.*;

import java.util.NoSuchElementException;
import java.util.Queue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import queue_singlelinkedlist.FifoQueue;

public class TestAppendFifoQueue {
    private FifoQueue<Integer> firstIntQueue;
	private FifoQueue<Integer> secondIntQueue;

	@BeforeEach
	void setUp() {
		firstIntQueue = new FifoQueue<Integer>();
		secondIntQueue = new FifoQueue<Integer>();
	}

	@AfterEach
	void tearDown() {
		firstIntQueue = null;
		secondIntQueue = null;
	}

    //Testar att merga två tomma listor 

    @Test 
    void testEmptyAppend(){
        firstIntQueue.append(secondIntQueue);
        
        assertEquals(0, firstIntQueue.size(), "Storleken av FirstIntQueue är inte lika med 0");
        assertEquals(0, secondIntQueue.size(),"Storleken av secondIntQueue är inte like med 0");
        assertEquals(null, firstIntQueue.peek(), "första noden är inte null på FirstIntQueue");
        assertEquals(null, secondIntQueue.peek(), "första noden är inte null på secondIntQueue");
        
    }

    //Testar att merga en tom lista med en icke tom lista. 
    @Test
    void testEmptyTofilledAppend(){
        for(int i = 0; i < 10; i++){
            firstIntQueue.offer(i);
        }

        firstIntQueue.append(secondIntQueue);

        assertEquals(0, secondIntQueue.size(), "Storleken på secondIntQueue är inte rätt");
        assertEquals(10, firstIntQueue.size(),"storleken på firstintqueue är inte rätt");

        for(int i = 0; i < 10; i++){
            assertEquals(i, firstIntQueue.poll(),"Värderna i listan stämmer inte");
        }

        assertEquals(null, secondIntQueue.poll(), "Kön är inte tom");
    }

    //Testar att merga en icke tom lista med en tom lista
    @Test
    void testFilledToEmptyAppend(){
        for(int i = 0; i < 10; i++){
            firstIntQueue.offer(i);
        }

        secondIntQueue.append(firstIntQueue);

        assertEquals(0, firstIntQueue.size(), "Storleken på secondIntQueue är inte rätt");
        assertEquals(10, secondIntQueue.size(),"storleken på firstintqueue är inte rätt");

        for(int i = 0; i < 10; i++){
            assertEquals(i, secondIntQueue.poll(),"Värderna i listan stämmer inte");
        }

        assertEquals(null, firstIntQueue.poll(), "Kön är inte tom");
    }
    //Provar att merga två fyllda köer
    @Test
    void TestFilledQueues(){
        for(int i = 0; i < 15; i++){
            
            if(i < 5){
                firstIntQueue.offer(i);
            }
            else {
                secondIntQueue.offer(i);
            }

        }

        firstIntQueue.append(secondIntQueue);

        assertEquals(15, firstIntQueue.size(), "Storleken på firstIntQueue är inte 5");

        for(int i=0; i < 15; i++){
            assertEquals(i, firstIntQueue.poll(), "Värderna stämmer inte");
        }

        assertEquals(0, secondIntQueue.size(), "Storleken av secondIntQueue är inte 0");
        assertEquals(null, secondIntQueue.poll(), "Listan är inte tom");
    }

    //Provar att merga med sig själv
    @Test
    void testSelfMerge(){
        try {
            firstIntQueue.append(firstIntQueue);
            fail("Ska throwa IlleagalArgumentException");
        }
        catch(IllegalArgumentException e){
            
        }
    }
}
