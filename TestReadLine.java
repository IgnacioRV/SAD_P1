import java.io.*;
public class TestReadLine {
	public static void main(String [] args)
	   {
		Line line = new Line();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		EditableBufferedReader ebr = new EditableBufferedReader(line, br);
		Console console = new Console(line);
		line.addObserver(console);
		String str = null;		
		str = ebr.readLine();
		System.out.println("\n line is: "+str);
		
	   }
}
	
