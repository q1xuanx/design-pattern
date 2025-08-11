package Creational_Patterns;

public class FactoryPattern {
	// Create product
	public interface Product {
		void doStuff();
	}
	
	public static class ProductA implements Product {
		
		@Override
		public void doStuff() {
			System.out.println("I'm a Product A, I do stuff A");
		}
	}
	
	public static class ProductB implements Product {
		@Override 
		public void doStuff() {
			System.out.println("I'm a Product B, I do stuff B");
		}
	}
	
	
	// Make creator to create product
	public static abstract class CreaterProduct {
		public abstract Product createProduct();
		
		public void sampleOperation() { 
			// Khi này createProduct sẽ tham chiếu đến thực thể thực sự gọi tới 
			// để khởi tạo Product
			Product pTest = createProduct(); 
			pTest.doStuff();
		}
	}
	
	public static class CreateProductA extends CreaterProduct {
		@Override
		public Product createProduct() {
			return new ProductA();
		}
	}
	
	public static class CreateProductB extends CreaterProduct {
		@Override
		public Product createProduct() {
			return new ProductB();
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CreaterProduct createProd = new CreateProductB(); 
		createProd.sampleOperation();
	}

}
