package org.ieschabas.clases;

import java.util.Objects;

import javax.persistence.*;

@Entity
public class Pago {

	private int id;
	private int idCliente;
	private int idAlquiler;
	private double cantidad;
	private String fechaPago;
	private boolean completado;
	
	public Pago() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Pago(int idCliente, int idAlquiler, double cantidad, String fechaPago, boolean completado) {
		super();
		this.idCliente = idCliente;
		this.idAlquiler = idAlquiler;
		this.cantidad = cantidad;
		this.fechaPago = fechaPago;
		this.completado = completado;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public int getIdAlquiler() {
		return idAlquiler;
	}

	public void setIdAlquiler(int idAlquiler) {
		this.idAlquiler = idAlquiler;
	}

	public double getCantidad() {
		return cantidad;
	}

	public void setCantidad(double cantidad) {
		this.cantidad = cantidad;
	}

	public String getFechaPago() {
		return fechaPago;
	}

	public void setFechaPago(String fechaPago) {
		this.fechaPago = fechaPago;
	}

	public boolean isCompletado() {
		return completado;
	}

	public void setCompletado(boolean completado) {
		this.completado = completado;
	}

	@Override
	public String toString() {
		return "Pago [id=" + id + ", idCliente=" + idCliente + ", idAlquiler=" + idAlquiler + ", cantidad=" + cantidad
				+ ", fechaPago=" + fechaPago + ", completado=" + completado + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(cantidad, completado, fechaPago, id, idAlquiler, idCliente);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pago other = (Pago) obj;
		return Double.doubleToLongBits(cantidad) == Double.doubleToLongBits(other.cantidad)
				&& completado == other.completado && Objects.equals(fechaPago, other.fechaPago) && id == other.id
				&& idAlquiler == other.idAlquiler && idCliente == other.idCliente;
	}
	
	
	
}
