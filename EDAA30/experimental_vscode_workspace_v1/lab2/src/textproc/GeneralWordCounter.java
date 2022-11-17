package textproc;

import java.util.Set;
import java.util.TreeMap;
import java.util.Map.Entry;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class GeneralWordCounter implements TextProcessor{
    private Set<String> stopwords;
    //private Map<String, Integer> list = new TreeMap<>();
    private Map<String, Integer> list = new HashMap<>();


    public GeneralWordCounter(Set<String> stopwords){
        this.stopwords = stopwords;
    }

    public void process(String w) {
        
        if(!stopwords.contains(w)){
            if(!list.containsKey(w)){
                list.put(w,1);
            }
            else{
            list.merge(w, 1, Integer::sum);
            }
        }
        
    }

    public void report() {
       /*  System.out.println();
        for(String key : list.keySet()){
            if (list.get(key) >= 200){
               System.out.println(key + " " + list.get(key));
           }
       }
*/

    Set<Map.Entry<String, Integer>> wordSet = list.entrySet();
    List<Map.Entry<String, Integer>> wordList = new ArrayList<>(wordSet);
    System.out.println();

    //Skriver ut alla med value > 200:
       //wordList.stream().filter(w -> w.getValue() >=200).forEach(w -> System.out.println(w));

       wordList.sort((w1,w2) -> {
        if(w2.getValue() - w1.getValue() == 0){
           return w1.getKey().compareTo(w2.getKey());
        }
        return w2.getValue() - w1.getValue();
       });

       //wordList.sort((w1,w2) -> w2.getValue() - w1.getValue()); 

       for(int i = 0; i < 10; i++){
        System.out.println(wordList.get(i));
       }

    }

    public List<Entry<String, Integer>> getWordList() {
        Set<Map.Entry<String, Integer>> wordSet = list.entrySet();
		List<Map.Entry<String, Integer>> wordList = new ArrayList<>(wordSet);
        return wordList;
        }
        
}
