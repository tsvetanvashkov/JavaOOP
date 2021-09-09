package heroRepository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class HeroRepositoryTests {
    
	private HeroRepository heroRespository;
	private Hero hero;
	private Hero hero2;
	
	@Before
	public void setUp() {
		this.heroRespository = new HeroRepository();
		this.hero = new Hero("Tor", 7);
		this.hero2 = new Hero("S", 6);
		
	}
	
	@Test(expected = UnsupportedOperationException.class)
	public void testGetHero() {
		this.heroRespository.create(hero);
		this.heroRespository.getHeroes().remove(hero);
	}
	
	@Test(expected = NullPointerException.class)
	public void testAddHeroItIsNullShouldFail() {
		this.heroRespository.create(null);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testAddHeroAlreadyExists() {
		this.heroRespository.create(hero);
		this.heroRespository.create(hero);
	}
	
	@Test
	public void testAdd() {
		this.heroRespository.create(hero);
		assertEquals(1, this.heroRespository.getCount());
	}
	
	@Test
	public void testAddHero() {
		String expected = "Successfully added hero Tor with level 7";
		String actual = this.heroRespository.create(hero);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testRemoveHeroShouldReturnFalse() {
		this.heroRespository.create(hero);
		assertFalse(this.heroRespository.remove("other"));
	}
	
	@Test
	public void testRemoveHeroShouldReturnTrue() {
		this.heroRespository.create(hero);
		assertTrue(this.heroRespository.remove("Tor"));
	}
	
	@Test
	public void testHeroLevel() {
		this.heroRespository.create(hero);
		this.heroRespository.create(hero2);
		Hero returned = this.heroRespository.getHeroWithHighestLevel();
		assertNotNull(returned);
		assertEquals(returned, hero);
	}
	
	@Test
	public void testGetReturnCorrect() {
		heroRespository.create(hero);
		Hero returned = this.heroRespository.getHero(hero.getName());
		assertNotNull(returned);
		assertEquals(returned, hero);
	}
}
