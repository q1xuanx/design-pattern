package Creational_Patterns;

public class SingletonPattern {

	public static class Car { 
		private static Car instance; 
		
		private int hp; 
		private String color; 
		
		public Car() { 
			
		}
		
		public Car(int hp, String color) { 
			this.hp = hp; 
			this.color = color; 
		}
		
		public static Car getInstance(int hp, String color) { 
			if (Car.instance == null) {
				Car.instance = new Car();
				Car.instance.hp = hp;
				Car.instance.color = color;
				return Car.instance;
			}
			return Car.instance;
		}

		@Override
		public String toString() {
			return "Car [hp=" + hp + ", color=" + color + "]";
		}
		
	}
	
	public static void main(String[] args) {
		Car car = Car.getInstance(4166, "Green");
		System.out.println(car);
		
		Car car_1 = Car.getInstance(294, "Black");
		System.out.println(car_1);
	}

}
