package lexico;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class Entrada {
	InputStream is;
	
	public Entrada(String arquivo) {
		try {
			is = new FileInputStream (new File(arquivo));
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public int LerProximoCaractere() {
		try {
			int pos = is.read();
			if ((char)pos != ' ' && (char)pos != '\n') {
				System.out.println((char)pos);
			}
			return pos;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}
}
