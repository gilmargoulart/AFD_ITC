package utilitarios;

import java.io.File;

import org.apache.commons.io.FileUtils;

public class TextWriter {
	
	/**
	 * 
	 * @param path: Caminho do arquivo
	 * @param data: Texto
	 * @return
	 * @throws Exception
	 */
	public static void writeTextToFile(String path, String data) throws Exception {
		File f = new File(path);
		
		FileUtils.writeStringToFile(f, data, "UTF-8", false);
	}	
}
