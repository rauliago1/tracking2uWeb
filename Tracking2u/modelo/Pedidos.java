package tracking2u.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="Pedidos", schema="public")
public class Pedidos {

	@Id
	@GeneratedValue
	private Long id;
	@Column(name="tarefa1")
	private String tarefa1;

	@Column(name="tarefa2")
	private String tarefa2;

	@Column(name="tarefa3")
	private String tarefa3;

	@Column(name="ListadeTarefas")
	private boolean Listadetarefas;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTarefa1() {
		return tarefa1;
	}

	public void setTarefa1(String tarefa1) {
		this.tarefa1 = tarefa1;
	}

	public String getTarefa2() {
		return tarefa2;
	}

	public void setTarefa2(String tarefa2) {
		this.tarefa2 = tarefa2;
	}

	public String getTarefa3() {
		return tarefa3;
	}

	public void setTarefa3(String tarefa3) {
		this.tarefa3 = tarefa3;
	}


	public boolean isListadetarefa() {
		return listadetarefa;
	}

	public void setListadetarefa(boolean listadetarefa) {
		this.listadetarefa = listadetarefa;
	}}


