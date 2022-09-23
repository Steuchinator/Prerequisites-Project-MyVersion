package testers;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import classes.Blob;

class BlobTester {

	@Test
	void test() throws NoSuchAlgorithmException, IOException {
		Blob blob = new Blob("file.txt");
		String Sha = blob.getSha1();
		assertTrue(new File("tester/objects/" + Sha).exists());
	}
	
	
	
	

}
