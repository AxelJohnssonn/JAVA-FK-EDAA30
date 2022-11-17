package textproc;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class MultiWordCounter implements TextProcessor{
    //private Map<String,Integer> list= new TreeMap<>();
    private Map<String, Integer> list = new HashMap<>();

	public MultiWordCounter(String [] landskap) {
		for(String s : landskap){
            list.put(s,0);
        }
	}

	public void process(String k) {
        //Om angiven k finns i list: value + 1
        if(list.containsKey(k)){
            list.merge(k,1,Integer::sum);
        }
	}

	public void report() {
        System.out.println();
        //Skriver ut varje key k och value v för landskapen
        list.forEach((k,v) -> System.out.println(k +" "+ v));
	}

    
}
