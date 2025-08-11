package Structual_Patterns;

public class DecoratorPattern {
	
	
	public static interface Coffee { 
		double getCost();
		String getDescription();
	}
	
	public static class SimpleCoffee implements Coffee { 
		@Override
		public double getCost() {
			return 20.0;
		}
		
		@Override
		public String getDescription() {
			return "Coffee";
		}
	}
	
	public static abstract class CoffeeDecorator implements Coffee {
		protected Coffee decoratedCoffee;
		
		public CoffeeDecorator(Coffee deCoffee) { 
			this.decoratedCoffee = deCoffee;
		}
		
		@Override
		public double getCost() {
			return decoratedCoffee.getCost();
		}
		
		@Override
		public String getDescription() {
			return decoratedCoffee.getDescription();
		}
	}
	
	public static class MilkCoffeeDecorator extends CoffeeDecorator {
		
		public MilkCoffeeDecorator(Coffee coffee) {
			super(coffee);
		}
		
		public double getCost() {
			return super.getCost() * 0.5;
		}
		
		public String getDescription() {
			return super.getDescription() + " milk added";
		}
		
	}
	
	public static class IceCoffeeDecorator extends CoffeeDecorator {
		
		public IceCoffeeDecorator(Coffee coffee) {
			super(coffee);
		}
		
		public double getCost() {
			return super.getCost() * 0.25;
		}
		
		public String getDescription() {
			return super.getDescription() + " ice added";
		}
		
	}
	
	public static void main(String[] args) {
		// Coffee coffee = new SimpleCoffee();
		
		CoffeeDecorator decorator = new IceCoffeeDecorator(new MilkCoffeeDecorator(new SimpleCoffee()));
		System.out.println(decorator.getDescription());

	}

}
