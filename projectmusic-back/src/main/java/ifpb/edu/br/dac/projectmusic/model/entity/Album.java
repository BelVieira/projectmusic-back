package ifpb.edu.br.dac.projectmusic.model.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

@Table
@Entity
public class Album implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String title;
	private int productionYear;
	// Atributo para produtora.
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  	@JoinTable(name="album_music",
             joinColumns={@JoinColumn(name = "album_id")},
             inverseJoinColumns={@JoinColumn(name = "music_id")})
	private List<Music> musics;


	public List<Music> getMusics() {
		return musics;
	}

	public void setMusics(List<Music> musics) {
		this.musics = musics;
	}

	public Album() {

	}
	
	public Album(String title, int productionYear) {
		this.title = title;
		this.productionYear = productionYear;

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
		return Objects.hash(id, productionYear, title);
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
		return id == other.id && productionYear == other.productionYear && Objects.equals(title, other.title);
	}

	@Override
	public String toString() {
		return "Album [id=" + id + ", title=" + title + ", productionYear=" + productionYear
				+ "]";
	}

}
