package utilitarios;

import java.io.File;
import org.apache.commons.io.FileUtils;

public class TextReader {
	
	public static String readTextFile(String path) throws Exception {
		File f = new File(path);
		
		String txt = FileUtils.readFileToString(f, "UTF-8");
		
		return txt;
	}	
}
