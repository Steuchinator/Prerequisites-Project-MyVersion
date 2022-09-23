package testers;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileWriter;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.platform.suite.api.IncludeClassNamePatterns;
import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;

// Format for JUnit 5 Jupiter Tests 
// stolen from https://junit.org/junit5/docs/current/user-guide/#junit-platform-suite-engine (Links to an external site.)
// more docs found  https://www.baeldung.com/junit-5 (Links to an external site.)

@Suite
@SuiteDisplayName("Git Project Tester")
@SelectPackages("testers")
@IncludeClassNamePatterns(".*Tester")

class GitTest {
	private static File f, fi, fil, file;
	@Test
	public void test() {
		
	}
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		File f = new File("f.txt");
		FileWriter fw = new FileWriter(f);
		fw.write("content");
		fw.close();
		
		File fi = new File("fi.txt");
		FileWriter fwr = new FileWriter(fi);
		fwr.write("some content");
		fwr.close();
		
		File fil = new File("fil.txt");
		FileWriter fwri = new FileWriter(fil);
		fwri.write("othercontent");
		fwri.close();
		
		file = new File("file.txt");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		file.delete();
		f.delete();
		fi.delete();
		fil.delete();
	}
	

}
