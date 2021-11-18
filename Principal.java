package lexico;

import javax.swing.JFileChooser;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String caminho = "";
		JFileChooser fc = new JFileChooser();
		int retorno = fc.showOpenDialog(null);
		
		if (retorno == JFileChooser.APPROVE_OPTION) {
			caminho = fc.getSelectedFile().getAbsolutePath();
			System.out.println(caminho);
		}
		
		Analisador ent = new Analisador(caminho);
		Token t = null;
		
		while ((t = ent.proximoToken()) != null) {
			System.out.println(t);
		}
	}

}
