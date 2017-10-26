import java.util.Observer;
import java.util.Observable;

public class Console implements Observer
{
   private Line line = null;

   public Console(Line line)
   {
      this.line = line;
   }

   private void gotoxy(int x, int y){
	char escCode = 0x1B;
	System.out.print(String.format("%c[%d;%df",escCode,y,x));
   }
   private void updateView(){
	String text = line.getLine();
	int pos = line.getPos();

	clearScreen();
	System.out.print(text);
	gotoxy(pos+1,0);
   }

   private static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o == line)
        {
            updateView();
        }
    }
}
