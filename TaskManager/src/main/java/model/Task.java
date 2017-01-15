package model;

import java.util.Date;

public class Task {

	private Integer id;
	private String titlu;
	private String descriere;
	private Date dataAdaugare;
	private Date dataTerminare;
	private Integer durata;
	private Double cost;
	private Integer tip;
	private boolean completata;
	private Integer prioritate;
	
	
	
	public Task(Integer id, String titlu, String descriere, Date dataAdaugare, Date dataTerminare, Integer durata,
			Double cost, Integer tip, boolean completata, Integer prioritate) {
		this.id = id;
		this.titlu = titlu;
		this.descriere = descriere;
		this.dataAdaugare = dataAdaugare;
		this.dataTerminare = dataTerminare;
		this.durata = durata;
		this.cost = cost;
		this.tip = tip;
		this.completata = completata;
		this.prioritate = prioritate;
	}

	
	
	public Task() {
	}



	public Task(String titlu) {
		this.titlu = titlu;
	}



	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitlu() {
		return titlu;
	}
	public void setTitlu(String titlu) {
		this.titlu = titlu;
	}
	public String getDescriere() {
		return descriere;
	}
	public void setDescriere(String descriere) {
		this.descriere = descriere;
	}
	public Date getDataAdaugare() {
		return dataAdaugare;
	}
	public void setDataAdaugare(Date dataAdaugare) {
		this.dataAdaugare = dataAdaugare;
	}
	public Date getDataTerminare() {
		return dataTerminare;
	}
	public void setDataTerminare(Date dataTerminare) {
		this.dataTerminare = dataTerminare;
	}
	public Integer getDurata() {
		return durata;
	}
	public void setDurata(Integer durata) {
		this.durata = durata;
	}
	public Double getCost() {
		return cost;
	}
	public void setCost(Double cost) {
		this.cost = cost;
	}
	public Integer getTip() {
		return tip;
	}
	public void setTip(Integer tip) {
		this.tip = tip;
	}
	public boolean isCompletata() {
		return completata;
	}
	public void setCompletata(boolean completata) {
		this.completata = completata;
	}
	public Integer getPrioritate() {
		return prioritate;
	}
	public void setPrioritate(Integer prioritate) {
		this.prioritate = prioritate;
	}



	@Override
	public String toString() {
		return "Task [id=" + id + ", titlu=" + titlu + "]";
	}
	
	
	
}
