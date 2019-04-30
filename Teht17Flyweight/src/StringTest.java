import javafx.scene.layout.HBox;

public class StringTest {
	public static void main(String[] args) {
		String fly = "fly", weight = "weight";
		String fly2 = "fly", weight2 = "weight";
		HBox hBox1 = new HBox();
		HBox hBox2 = new HBox();
		System.out.println(hBox1 == hBox2);
		/*
		System.out.println(fly == fly2);       // fly and fly2 refer to the same String instance
		System.out.println(weight == weight2); // weight and weight2 also refer to
		// the same String instance
		String distinctString = fly + weight;
		System.out.println(distinctString == "flyweight"); // flyweight and "flyweight" do not
		// refer to the same instance
		String flyweight = (fly + weight).intern() + " ";
		System.out.println(flyweight == "flyweight "); // The intern() method returns a flyweight
		String flyweight2 = fly.intern() + weight.intern() + " ";
		System.out.println(flyweight2 == "flyweight "); // The intern() method returns a flyweight

		String flyweight3 = "fly" + "weight";
		System.out.println(flyweight3 == "flyweight"); // The intern() method returns a flyweight
		String flyweight4 = (fly.intern() + weight.intern()).intern();
		System.out.println(flyweight4 == "flyweight"); // The intern() method returns a flyweight
		*/
	}
}


