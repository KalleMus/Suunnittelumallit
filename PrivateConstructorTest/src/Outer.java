public class Outer {

	public Outer() {
		Inner inner = new Inner();
		inner.innerMethod();
	}

	private class Inner {

		private Inner() {
			System.out.println("Inner created");
		}

		private void innerMethod() {
			System.out.println("Inner method called!");
		}
	}
}
