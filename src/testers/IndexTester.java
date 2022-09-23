package testers;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import org.junit.jupiter.api.Test;
import classes.Index;
import classes.Blob;
class IndexTester {
	
	
	@Test
	
	void testIndex() throws Exception {
		Index index = new Index();
		index.initialize();
		
		assertTrue(new File("tester/objects").exists() && new File("tester/index.txt").exists());
		index.addBlobs("f.txt");
		Blob b = new Blob("f.text");
		String s = b.getSha1();
		index.addBlobs("fi.txt");
		Blob bl = new Blob("fi.text");
		String sh = bl.getSha1();
		index.addBlobs("fil.txt");
		Blob blo = new Blob("fil.text");
		String sha = blo.getSha1();
		
		File folder = new File("tester/objects");
		ArrayList<String> fileNames = new ArrayList<String>(Arrays.asList(folder.list()));
		if (!fileNames.contains(s)||!fileNames.contains(sh)||!fileNames.contains(sha)) {
			fail("fail");
		}
		
		Scanner scan = new Scanner("tester/index.txt");
		int counter = 0;
		while (scan.hasNextLine()) {
			counter++;
			scan.nextLine();
		}
		scan.close();
		if (counter!=3) {
			fail("fail");
		}
		
		index.removeBlobs("f.txt");
		index.removeBlobs("fi.txt");
		index.removeBlobs("fil.txt");
		
		File fold = new File("tester/objects");
		ArrayList<String> files = new ArrayList<String>(Arrays.asList(fold.list()));
		if (files.contains(s)||files.contains(sh)||files.contains(sha)) {
			fail("fail");
		}
		
		Scanner scanner = new Scanner("tester/index.txt");
		int count = 0;
		while (scanner.hasNextLine()) {
			count++;
			scanner.nextLine();
		}
		scanner.close();
		assertTrue(count==0);
	}

}
