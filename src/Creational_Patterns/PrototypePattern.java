package Creational_Patterns;

public class PrototypePattern {
	
	public static abstract class Shape {
		private int x; 
		private int y; 
		
		public Shape(int x, int y) {
			this.x = x; 
			this.y = y; 
		}
		
		public abstract Shape copy();

		@Override
		public String toString() {
			return "Shape [x=" + x + ", y=" + y + "]";
		}
		
		
	}
	
	public static class Rectangle extends Shape { 
		private String color; 
		
		public Rectangle(int x, int y, String color) { 
			super(x,y);
			this.color = color; 
		}
		
		
		@Override
		public Shape copy() {
			return this;
		}


		@Override
		public String toString() {
			return super.toString() + " Rectangle [color=" + color + "]";
		}
		
	}
	
	public static void main(String[] args) {
		Shape rectangle = new Rectangle(20, 10, "Green"); 
		Shape copyRectangle = rectangle.copy();
		System.out.println(rectangle);
		System.out.println(copyRectangle);
	}
}
