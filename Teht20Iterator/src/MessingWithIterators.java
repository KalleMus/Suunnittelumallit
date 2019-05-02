import java.util.*;

public class MessingWithIterators {

	private Set<Data> dataSet;
	private List<Data> dataList;
	private Iterator setIterator;
	private Iterator listIterator;

	public MessingWithIterators(int amount) {
		this.dataSet = new HashSet<>();
		this.dataList = new ArrayList<>();
		for (int i = 0; i <amount; i++) {
			dataSet.add(new Data(i));
			dataList.add(new Data(i));
		}
		this.setIterator = dataSet.iterator();
		this.listIterator = dataList.iterator();
		System.out.println(setIterator.hasNext());
		while (setIterator.hasNext() && listIterator.hasNext()) {
			System.out.println("Set: " + setIterator.next().toString() +", List: " + listIterator.next().toString());
		}
	}

}


