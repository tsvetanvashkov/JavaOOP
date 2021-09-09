package aquarium.core;

import java.util.ArrayList;
import java.util.Collection;

import aquarium.entities.aquariums.Aquarium;
import aquarium.entities.aquariums.FreshwaterAquarium;
import aquarium.entities.aquariums.SaltwaterAquarium;
import aquarium.entities.decorations.Decoration;
import aquarium.entities.decorations.Ornament;
import aquarium.entities.decorations.Plant;
import aquarium.entities.fish.Fish;
import aquarium.entities.fish.FreshwaterFish;
import aquarium.entities.fish.SaltwaterFish;
import aquarium.repositories.DecorationRepository;

public class ControllerImpl implements Controller{
	
	private DecorationRepository decorations;
	private Collection<Aquarium> aquariums;
	
	public ControllerImpl() {
		this.decorations = new DecorationRepository();
		this.aquariums = new ArrayList<Aquarium>();
	}

	@Override
	public String addAquarium(String aquariumType, String aquariumName) {
		switch (aquariumType) {
		case "FreshwaterAquarium":
			this.aquariums.add(new FreshwaterAquarium(aquariumName));
			break;
		case "SaltwaterAquarium":
			this.aquariums.add(new SaltwaterAquarium(aquariumName));
			break;

		default:
			throw new NullPointerException("Invalid aquarium type.");
		}
		return String.format("Successfully added %s.", aquariumType);
	}

	@Override
	public String addDecoration(String type) {
		switch (type) {
		case "Ornament":
			this.decorations.add(new Ornament());
			break;
		case "Plant":
			this.decorations.add(new Plant());
			break;
				
		default:
			throw new IllegalArgumentException("Invalid aquarium type.");
		}
		return String.format("Successfully added %s.", type);
	}

	@Override
	public String insertDecoration(String aquariumName, String decorationType) {
		Decoration decoration = decorations.findByType(decorationType);
		if (decoration == null) {
			throw new IllegalArgumentException(String.format("There isn't a decoration of type %s.", decorationType));
		}
		for (Aquarium aquarium : aquariums) {
			if (aquarium.getName().equals(aquariumName)) {
				aquarium.addDecoration(decoration);
				this.decorations.remove(decoration);
			}
		}
		return String.format("Successfully added %s to %s.", decorationType, aquariumName);
	}

	@Override
	public String addFish(String aquariumName, String fishType, String fishName, String fishSpecies, double price) {
		for (Aquarium aquarium : aquariums) {
			if (aquarium.getName().equals(aquariumName)) {
				switch (fishType) {
					case "FreshwaterFish":
						FreshwaterFish freshwaterFish = new FreshwaterFish(fishName, fishSpecies, price);
						if (aquarium.getClass().getSimpleName().equals("FreshwaterAquarium")) {
							 try {
						            aquarium.addFish(freshwaterFish);
						     	} catch (Exception e) {
						            return "Not enough capacity";
						        }
							 break;
						}else {
							return "Water not suitable.";
						}

					case "SaltwaterFish":
						SaltwaterFish saltwaterFish = new SaltwaterFish(fishName, fishSpecies, price);
						if (aquarium.getClass().getSimpleName().equals("SaltwaterAquarium")) {
							try {
									aquarium.addFish(saltwaterFish);
								} catch (Exception e) {
									return "Not enough capacity";
								}
							break;
						}else {
							return "Water not suitable.";
						}

					default:
						throw new IllegalArgumentException("Invalid fish type.");
				}
			}
		}
		return String.format("Successfully added %s to %s.", fishType, aquariumName);
	}

	@Override
	public String feedFish(String aquariumName) {
		int fedCount = 0;
		for (Aquarium aquarium : aquariums) {
			if (aquarium.getName().equals(aquariumName)) {
				aquarium.feed();
				fedCount = aquarium.getFish().size();
			}
		}
		return String.format("Fish fed: %d", fedCount);
	}

	@Override
	public String calculateValue(String aquariumName) {
		Aquarium aquarium = this.aquariums.stream().filter(a -> a.getName().equals(aquariumName)).findFirst().get();
		double fishSum = aquarium.getFish().stream().mapToDouble(Fish::getPrice).sum();
        double decoSum = aquarium.getDecorations().stream().mapToDouble(Decoration::getPrice).sum();
        return String.format("The value of Aquarium %s is %.2f.", aquariumName, fishSum + decoSum);
	}

	@Override
	public String report() {
		StringBuilder sb = new StringBuilder();
		for (Aquarium aquarium : aquariums) {
			sb.append(aquarium.getInfo())
				.append(System.lineSeparator());	
		}
		return sb.toString().trim();
	}
	
}
