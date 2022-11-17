package textproc;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


public class Holgersson {

	public static final String[] REGIONS = { "blekinge", "bohuslän", "dalarna", "dalsland", "gotland", "gästrikland",
			"halland", "hälsingland", "härjedalen", "jämtland", "lappland", "medelpad", "närke", "skåne", "småland",
			"södermanland", "uppland", "värmland", "västerbotten", "västergötland", "västmanland", "ångermanland",
			"öland", "östergötland" };

	public static void main(String[] args) throws FileNotFoundException {
		long t0 = System.nanoTime();
		TextProcessor p = new SingleWordCounter("nils");
		TextProcessor p2 = new SingleWordCounter("norge");
		TextProcessor l = new MultiWordCounter(REGIONS);

		Scanner s = new Scanner(new File("C:\\Users\\Mraxj\\Documents\\GitHub\\EDAA30\\experimental_vscode_workspace_v1\\experimental_vscode_workspace_v1\\lab2\\src\\nilsholg.txt"), "UTF-8");
		Scanner s2 = new Scanner(new File("C:\\Users\\Mraxj\\Documents\\GitHub\\EDAA30\\experimental_vscode_workspace_v1\\experimental_vscode_workspace_v1\\lab2\\src\\undantagsord.txt"), "UTF-8");
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

		TextProcessor g = new GeneralWordCounter(stopwords);

		while (s.hasNext()) {
			String word = s.next().toLowerCase();

			p.process(word);
			p2.process(word);
			l.process(word);
			g.process(word);
		}
		s.close();


		p.report();
		p2.report();
		l.report();
		g.report();

		long t1 = System.nanoTime();
		System.out.println();
		System.out.println("tid: " + (t1 - t0) / 1000000.0 + " ms");
	}
}