import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;

public class EditableBufferedReader extends BufferedReader{
    private Line line;
    public EditableBufferedReader(Line line, BufferedReader br) {
        super(br);
        this.line = line;
    }
    private int readEsc(){
        try {
            int r2 = super.read();
            r2 = super.read();
            //System.out.print(r2);
            switch (r2){
                case 67:
                    //System.out.print("RIGHT");
                    line.moveFront();
                    break;
                case 68:
                    //System.out.print("LEFT");
                    line.moveBack();
                    break;
                case 66:
                    return -1;
                case 50:
		    super.read();
		    line.setStatus();
		    break;
                case 51:
                    r2 = super.read();
                    if (r2 == 126) {
                    //    System.out.print("SUPR");
                    }
                    line.suprChar();
                    break;
		case 70:
                    line.moveEnd();
                    break;
		case 72:
                    line.moveHome();
                    break;
            }

            return r2;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return -1;
    }
    public int read(){
        int r = -1;
        try {
            r = super.read();
            //System.out.print(r);
            switch (r){
                case 13:
                    //int r2 = super.read();
                    //System.out.print(r2);
                    //System.out.print("ENTER");
		    return -1;
                case 127:
                    //System.out.print("DEL");
                    line.delChar();
                    break;
                case 27:
                    return readEsc();
                default:
                    line.addChar((char)r);
                    break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return r;
    }
	
    public String readLine(){
	this.setRaw();
	while(this.read() != -1) { }
	this.unsetRaw();	
	return line.getLine();
    }

    public void setRaw(){
        String[] cmd = {"/bin/sh", "-c", "stty raw </dev/tty"};
        try {
            Runtime.getRuntime().exec(cmd);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void unsetRaw(){
        String[] cmd = {"/bin/sh", "-c", "stty sane </dev/tty"};
        try {
            Runtime.getRuntime().exec(cmd);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
