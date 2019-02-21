package formation.sopra.entity;

import javax.persistence.Embeddable;

@Embeddable
public abstract class Adresse {

	private Long numero;
	private String rue;
	private String ville;
	private String codePostal;

	public Long getNumero() {
		return numero;
	}

	public void setNumero(Long numero) {
		this.numero = numero;
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public Adresse() {
		// TODO Auto-generated constructor stub
	}

	public Adresse(Long numero, String rue, String ville, String codePostal) {
		this.numero = numero;
		this.rue = rue;
		this.ville = ville;
		this.codePostal = codePostal;
	}

}
