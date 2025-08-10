package Creational_Patterns;

public class AbstractFactoryPattern {
	
	public interface Button {
		void paint();
	}
	
	public static class WinButton implements Button {
		
		@Override
		public void paint() {
			System.out.println("This is Windows button");
		}
	}
	
	public static class MacButton implements Button { 
		@Override
		public void paint() {
			System.out.println("This is MacOS button");
		}
	}
	
	public static class LinuxButton implements Button {
		@Override
		public void paint() {
			System.out.println("This is Linux button");
		}
	}
	
	public interface CheckBox{ 
		void paint();
	}
	
	public static class WinCheckBox implements CheckBox { 
		@Override
		public void paint() {
			System.out.println("This is Windows check box");
		}
	}
	
	public static class MacCheckBox implements CheckBox { 
		@Override
		public void paint() {
			System.out.println("This is MacOS check box");
		}
	}
	
	public static class LinuxCheckBox implements CheckBox {
		@Override
		public void paint() {
			System.out.println("This is Linux check box");
		}
	}
	
	
	public static interface GUIFactory {
		Button createButton();
		CheckBox createCheckBox();
	}
	
	public static class WinFactory implements GUIFactory {
		@Override
		public Button createButton() {
			return new WinButton();
		}
		
		@Override
		public CheckBox createCheckBox() {
			return new WinCheckBox();
		}
	}
	
	public static class MacFactory implements GUIFactory {
		@Override
		public Button createButton() {
			return new MacButton();
		}
		
		@Override
		public CheckBox createCheckBox() {
			return new MacCheckBox();
		}
	}
	
	public static class LinuxFactory implements GUIFactory {
		
		@Override
		public Button createButton() {
			return new LinuxButton();
		}
		
		@Override
		public CheckBox createCheckBox() {
			return new LinuxCheckBox();
		}
	}
	
	public static class Application {
		private GUIFactory factory;
		private Button button;
		private CheckBox checkBox;
		
		public Application(GUIFactory factory) {
			this.factory = factory;
		}
		
		public void createButton() { 
			this.button = this.factory.createButton();
		}
		
		public void createCheckBox() {
			this.checkBox = this.factory.createCheckBox();
		}
		
		public void paintButton() { 
			this.button.paint();
		}
		
		public void paintCheckBox() {
			this.checkBox.paint();
		}
		
	}
	
	public static void main(String[] args) {
		Application app = new Application(new MacFactory());
		app.createCheckBox();
		app.paintCheckBox();
	}

}
