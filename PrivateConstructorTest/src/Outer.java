public class Outer {

	public Outer() {
		Inner inner = new Inner();
	}

	private class Inner {

		private Inner() {
			System.out.println("Inner created");
		}
	}
}
