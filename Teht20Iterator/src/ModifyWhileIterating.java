import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ModifyWhileIterating {

	private List<Data> sharedDataList;
	private Iterator sharedIterator;

	public ModifyWhileIterating(int amount) throws InterruptedException {
		this.sharedDataList = new ArrayList<>();
		for (int i = 0; i < amount; i++) {
			sharedDataList.add(new Data(i + 1));
		}
		this.sharedIterator = sharedDataList.iterator();
		Sit sit1 = new Sit();
		Sit sit2 = new Sit();
		sit1.start();
		sit2.start();
		sit1.join();
		sit2.join();
	}

	public synchronized void iterateList(Sit sit) {
		try {
			System.out.println(sit.getName() + " iterating.");
			if (sharedIterator.hasNext()) {
				System.out.println(sharedIterator.next());
				sharedDataList.remove(sharedIterator.next());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private class Sit extends Thread {
		@Override
		public void run() {
			while (sharedIterator.hasNext()) {
				try {
					iterateList(this);
					Thread.sleep(500);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}
