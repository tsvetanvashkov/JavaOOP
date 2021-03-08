package working_with_abstraction.exercises.GreedyTimes;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Bag {
	
	private long capacity;
	private long currentTotalQuantity;
	private long gold;
	private Map<String, Long> gams;
	private Map<String, Long> cash;
	
	public Bag(long capacity) {
		super();
		this.capacity = capacity;
		this.gams = new HashMap<String, Long>();
		this.cash = new HashMap<String, Long>();
	}
	
	public void addCash(String item, long quantity) {
		long totalGams = getTotalGems();
		long totalCash = getTotalCash();
		if (hasFreeCapacity(quantity) && totalGams >= totalCash + quantity) {
			if (!this.cash.containsKey(item)) {
				this.cash.put(item, quantity);
			} else {
				this.cash.put(item, this.cash.get(item) + quantity);
			}
			this.currentTotalQuantity += quantity;
		}
	}
	
	public void addGams(String item, long quantity) {
		long totalGams = getTotalGems();
		if (hasFreeCapacity(quantity) && totalGams + quantity <= this.gold) {
			if (!this.gams.containsKey(item)) {
				this.gams.put(item, quantity);
			} else {
				this.gams.put(item, this.gams.get(item) + quantity);
			}
			this.currentTotalQuantity += quantity;
		}
		
	}
	
	public void addGold(long quantity) {
		if (hasFreeCapacity(quantity)) {
			this.gold += quantity;
			this.currentTotalQuantity += quantity;
		}
	}
	
	private long getTotalCash() {
		return this.cash.values().stream().mapToLong(e -> e).sum();
	}
	
	private long getTotalGems() {
		return this.gams.values().stream().mapToLong(e -> e).sum();
	}
	
	private boolean hasFreeCapacity(long quantity) {
		return currentTotalQuantity + quantity < capacity;
	}
	
	public void printContent() {
		StringBuilder sb = new StringBuilder();
		if (this.gold >= 0) {
			sb.append(String.format("<Gold> $%d", this.gold));
			sb.append(System.lineSeparator());
			sb.append(String.format("##Gold - %d", this.gold));
			sb.append(System.lineSeparator());
		}
		if (!this.gams.isEmpty()) {
			sb.append(String.format("<Gem> $%d", getTotalGems()));
			sb.append(System.lineSeparator());
			this.gams.entrySet().stream()
						.sorted(getComparator())
						.forEach(entry ->
						sb.append(String.format("##%s - %d", entry.getKey(), entry.getValue()))
							.append(System.lineSeparator()));
		}
		if (!this.cash.isEmpty()) {
			sb.append(String.format("<Cash> $%d", getTotalCash()));
			sb.append(System.lineSeparator());
			this.cash.entrySet().stream()
						.sorted(getComparator())
						.forEach(entry ->
						sb.append(String.format("##%s - %d", entry.getKey(), entry.getValue()))
							.append(System.lineSeparator()));
		}
		System.out.println(sb.toString().trim());
		
	}
	
	private Comparator<Map.Entry<String, Long>> getComparator(){
		return new Comparator<Map.Entry<String,Long>>() {

			@Override
			public int compare(Entry<String, Long> g1, Entry<String, Long> g2) {
					int res = g2.getKey().compareTo(g1.getKey());
					if (res == 0) {
						res = g1.getValue().compareTo(g2.getValue());
					}
					return res;
			}
			
		};
	}

}
