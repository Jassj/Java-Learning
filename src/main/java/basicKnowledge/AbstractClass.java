package basicKnowledge;

public class AbstractClass {
	
	public static void main(String[] args) {
		Square square = new Square(1, 2);
		square.draw();
	}
}

abstract class Pic {
	public abstract void draw();
}

class Square extends Pic {
	private int length;
	private int width;
	
	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}
	
	public Square(int length, int width) {
		super();
		this.length = length;
		this.width = width;
	}

	@Override
	public void draw() {
		System.out.println(this.length * this.width);
	}
}
