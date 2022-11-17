package textproc;

import java.io.File;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.io.FileNotFoundException;

public class BookReaderApplication {
    public static final String[] REGIONS = { "blekinge", "bohuslän", "dalarna", "dalsland", "gotland", "gästrikland",
			"halland", "hälsingland", "härjedalen", "jämtland", "lappland", "medelpad", "närke", "skåne", "småland",
			"södermanland", "uppland", "värmland", "västerbotten", "västergötland", "västmanland", "ångermanland",
			"öland", "östergötland" };

    public static void main(String[] args) throws FileNotFoundException{

		//Stationär dator:
		Scanner s = new Scanner(new File("C:\\Users\\Mraxj\\Documents\\GitHub\\EDAA30\\experimental_vscode_workspace_v1\\experimental_vscode_workspace_v1\\lab2\\src\\nilsholg.txt"), "UTF-8");
		Scanner s2 = new Scanner(new File("C:\\Users\\Mraxj\\Documents\\GitHub\\EDAA30\\experimental_vscode_workspace_v1\\experimental_vscode_workspace_v1\\lab2\\src\\undantagsord.txt"), "UTF-8");
		

		//Laptop
		/* Scanner s = new Scanner(new File("C:\\Users\\Mraxj\\OneDrive\\Dokument\\labb1datorkom\\EDAA30\\experimental_vscode_workspace_v1\\experimental_vscode_workspace_v1\\lab2\\src\\nilsholg.txt"), "UTF-8");
		Scanner s2 = new Scanner(new File("C:\\Users\\Mraxj\\OneDrive\\Dokument\\labb1datorkom\\EDAA30\\experimental_vscode_workspace_v1\\experimental_vscode_workspace_v1\\lab2\\src\\undantagsord.txt"), "UTF-8");*/
		Set<String> stopwords = new HashSet<String>();

		s.findWithinHorizon("\uFEFF", 1);
		s.useDelimiter("(\\s|,|\\.|:|;|!|\\?|'|\\\")+"); // se handledning
		s2.findWithinHorizon("\uFEFF", 1);
		s2.useDelimiter("(\\s|,|\\.|:|;|!|\\?|'|\\\")+");

		while (s2.hasNext()) {
			String word = s2.next().toLowerCase();
			stopwords.add(word);
		}
		s2.close();

		GeneralWordCounter g = new GeneralWordCounter(stopwords);
			
		while (s.hasNext()) {
			String word = s.next().toLowerCase();
			g.process(word);
		}
		s.close();
        BookReaderController bookRead = new BookReaderController(g);
    }
}
