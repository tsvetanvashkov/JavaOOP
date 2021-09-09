package bakery.repositories.interfaces;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import bakery.entities.tables.interfaces.Table;

public class TableRepositoryImpl implements TableRepository<Table>{

	private Collection<Table> models;
	
	public TableRepositoryImpl() {
		this.models = new ArrayList<Table>();
	}

	@Override
	public Collection<Table> getAll() {
		return Collections.unmodifiableCollection(this.models);
	}

	@Override
	public void add(Table table) {
		this.models.add(table);
	}

	@Override
	public Table getByNumber(int number) {
		return this.models.stream()
							.filter(t -> t.getTableNumber() == number)
							.findFirst()
							.orElse(null);
	}

}
