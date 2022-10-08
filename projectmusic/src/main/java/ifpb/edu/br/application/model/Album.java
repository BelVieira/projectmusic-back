package ifpb.edu.br.application.model;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Table
@Entity
public class Album implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String title;
	private String productionYear;
	// Atributo para produtora.
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "album")
	private Set<Music> musics;

	public String getTitle() {
		return title;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getProductionYear() {
		return productionYear;
	}

	public void setProductionYear(String productionYear) {
		this.productionYear = productionYear;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public String toString() {
		return "Album [id=" + id + ", titulo=" + title + ", anoProducao=" + productionYear + ", musics=" + musics + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Album other = (Album) obj;
		return id == other.id;
	}

}
