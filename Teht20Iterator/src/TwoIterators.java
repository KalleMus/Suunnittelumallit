import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TwoIterators {

	private List<Data> dataList;

	public TwoIterators(int amount) throws InterruptedException {
		dataList = new ArrayList<>();
		for (int i = 0; i < amount; i++) {
			dataList.add(new Data(i + 1));
		}
		IteratorThread it1 = new IteratorThread();
		IteratorThread it2 = new IteratorThread();
		it1.start();
		it2.start();
		it1.join();
		it2.join();
	}

	private class IteratorThread extends Thread {

		private Iterator it;

		private IteratorThread() {
			it = dataList.iterator();
		}

		@Override
		public void run() {
			while (it.hasNext()) {
				try {
					System.out.println(this.getName() + ", Data: "+ it.next());
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
