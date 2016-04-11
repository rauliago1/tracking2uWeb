package tracking2u.modelo;

import javax.persistence.*;


@Entity
@Table(name="financas", schema="public")
public class financeiro {

	@Id
	@GeneratedValue
	private Long Id;
	@Column(name="lucro")
	String lucro;
	@Column(name="gastos")
	String gasto;
	@Column(name="tempo")
	String tempo;

	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public String getLucro() {
		return lucro;
	}
	public void setLucro(String lucro) {
		this.lucro = lucro;
	}
	public String getGasto() {
		return gasto;
	}
	public void setGasto(String gasto) {
		this.gasto = gasto;
	}
	public String getTempo() {
		return tempo;
	}
	public void setTempo(String tempo) {
		this.tempo = tempo;
	}



}
