import java.util.Observable;

public class Line extends Observable {
	String text;
	int pos;
	Boolean status; // true = insert --> sobreescriu

	public Line() {
		pos = 0;
		text = new String();
		status = true;
	}

	void setStatus() {
		status = !status;
		this.setChanged();
		notifyObservers();
	}

	Boolean getStatus() {
		return status;
	}

	String getLine() {
		return text;
	}

	int getPos() {
		return pos;
	}

	void addChar(char c) {
		if (pos == text.length()){
			text+=Character.toString(c);
		}
		else{
			if (status){ //sobreescriu
				text = text.substring(0,pos)+Character.toString(c)+text.substring(pos+1);
			}
			else{
				text = text.substring(0,pos)+Character.toString(c)+text.substring(pos);
			}
		}
		pos++;
		this.setChanged();
		notifyObservers();
	}

	void delChar() {
		if (pos == text.length()) {
			text = text.substring(0,pos);
			pos--;
		}
		else if (pos >0){
			text = text.substring(0,pos)+text.substring(pos+1);
			pos--;
		}
		this.setChanged();
		notifyObservers();

	}

	void suprChar() {
		if (pos == text.length()) {
			text = text.substring(0,pos);
		}
		else if (pos >=0){
			text = text.substring(0,pos)+text.substring(pos+1);
		}

		this.setChanged();
		notifyObservers();
	}

	void moveBack(){
		if (pos > 0) pos--;
		this.setChanged();
		notifyObservers();
	}

	void moveFront() {
		if (pos < text.length()) pos++;
		this.setChanged();
		notifyObservers();
	}

	void moveHome() {
		pos = 0;
		this.setChanged();
		notifyObservers();
	}

	void moveEnd() {
		pos = text.length() - 1;
		this.setChanged();
		notifyObservers();
	}
}
