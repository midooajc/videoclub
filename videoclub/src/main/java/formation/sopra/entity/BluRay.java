package formation.sopra.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("BluRay")
public class BluRay extends Article {
	private Boolean troisD;

	public Boolean getTroisD() {
		return troisD;
	}

	public void setTroisD(Boolean troisD) {
		this.troisD = troisD;
	}

	public BluRay() {
	}

	public BluRay(Integer nbDisques, Adherent emprunteur, Film film, Boolean troisD) {
		super(nbDisques, emprunteur, film);
		this.troisD = troisD;
	}

}
