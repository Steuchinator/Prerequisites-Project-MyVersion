package testers;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import org.junit.jupiter.api.Test;
import classes.Tree2;

class TreeTester {
	
	@Test
	void testTree() throws IOException {
		ArrayList<String> list = new ArrayList<String>();
		list.add("blob : 81e0268c84067377a0a1fdfb5cc996c93f6dcf9f");
		list.add("blob : 01d82591292494afd1602d175e165f94992f6f5f");
		list.add("blob : f1d82236ab908c86ed095023b1d2e6ddf78a6d83");
		list.add("tree : bd1ccec139dead5ee0d8c3a0499b42a7d43ac44b");
		list.add("tree : e7d79898d3342fd15daf6ec36f4cb095b52fd976");
		Tree2 t = new Tree2(list);
		assertTrue(t.encryptThisString(t.generateString(list)).equals("dd4840f48a74c1f97437b515101c66834b59b1be"));
		Scanner scan = new Scanner(t.encryptThisString(t.generateString(list)));
		for (int i = 0; i < list.size(); i++) {
			assertTrue(list.get(i).equals(scan.nextLine()));
		}
	}
}
