package repository;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractRepository<TYPE> {
	private List<TYPE> data;

	public AbstractRepository() {
		data = new ArrayList<>();
	}

	public final void add(TYPE newData) {
		data.add(newData);
	}

	final List<TYPE> getData() {
		return data;
	}

}
