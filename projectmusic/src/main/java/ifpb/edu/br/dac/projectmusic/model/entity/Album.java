package ifpb.edu.br.dac.projectmusic.model.entity;

import java.io.Serializable;
import java.util.HashSet;
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
public class Album implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String title;
	private int productionYear;
	// Atributo para produtora.

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "album_id")
	private Set<Music> musics = new HashSet<Music>();

	public Album() {

	}
	
	public Album(String title, int productionYear, Set<Music> musics) {
		this.title = title;
		this.productionYear = productionYear;
		this.musics = musics;

	}

	public Set<Music> getMusics() {
		return musics;
	}

	public void setMusics(Set<Music> musics) {
		this.musics = musics;
	}

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

	public int getProductionYear() {
		return productionYear;
	}

	public void setProductionYear(int productionYear) {
		this.productionYear = productionYear;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, musics, productionYear, title);
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
		return id == other.id && Objects.equals(musics, other.musics) && productionYear == other.productionYear
				&& Objects.equals(title, other.title);
	}

	@Override
	public String toString() {
		return "Album [id=" + id + ", title=" + title + ", productionYear=" + productionYear + ", musics=" + musics
				+ "]";
	}

}
