package formation.sopra.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("DVD")
public class Dvd extends Article {
	private Boolean bonus;

	public Boolean getBonus() {
		return bonus;
	}

	public void setBonus(Boolean bonus) {
		this.bonus = bonus;
	}

	public Dvd() {
	}

	public Dvd(Integer nbDisques, Adherent emprunteur, Film film, Boolean bonus) {
		super(nbDisques, emprunteur, film);
		this.bonus = bonus;
	}

}
