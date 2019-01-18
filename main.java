import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import newlang3.*;
import newlang4.*;

public class main {
	public static void main(String[] args) throws Exception{
		// TODO 自動生成されたメソッド・スタブ
		
		String fname = "test1.bas";
		if(args.length > 0) {
			fname = args[0];
		}
		File fr = new File(fname);
		InputStream is = null;
		try {
			is = new FileInputStream(fr);
		} catch (FileNotFoundException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		
		LexicalAnalyzer la = new LexicalAnalyzerimple(is);
		Environment env = new Environment(la);
		Node program = ProgramNode.getHandler(env);
		program.parse();
		System.out.println(program.toString());
	}
}
