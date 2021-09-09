package aquarium.repositories;

import java.util.ArrayList;
import java.util.Collection;

import aquarium.entities.decorations.Decoration;

public class DecorationRepository implements Repository{

	private Collection<Decoration> decorations;
	
	public DecorationRepository() {
		this.decorations = new ArrayList<Decoration>();
	}

	@Override
	public void add(Decoration decoration) {
		this.decorations.add(decoration);
		
	}

	@Override
	public boolean remove(Decoration decoration) {
		return this.decorations.remove(decoration);
	}

	@Override
	public Decoration findByType(String type) {
		for (Decoration decoration : decorations) {
			if (decoration.getClass().getSimpleName().equals(type)) {
				return decoration;
			}
		}
		return null;
	}
	
}
