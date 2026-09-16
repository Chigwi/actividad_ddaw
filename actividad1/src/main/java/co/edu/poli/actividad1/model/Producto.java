package co.edu.poli.actividad1.model;

public class Producto {
	
	private Long idProducto;
	private String nombre;
	private String descripcion;
	private Boolean disponible;
	private Double precio;
	private String categoria;

	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Long getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(Long idProducto) {
		this.idProducto = idProducto;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Boolean getDisponible() {
		return disponible;
	}
	public void setDisponible(Boolean disponible) {
		this.disponible = disponible;
	}
	public Double getPrecio() {
		return precio;
	}
	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public Producto(Long idProducto, String nombre, String descripcion, Boolean disponible, Double precio, String categoria) {
		super();
		this.idProducto = idProducto;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.disponible = disponible;
		this.precio = precio;
		this.categoria = categoria;
	}
	@Override
	public String toString() {
		return "Producto [idProducto=" + idProducto + "nombre=" + nombre + ", descripcion=" + descripcion + ", disponible=" + disponible
				+ ", precio=" + precio + ", categoria=" + categoria + "]";
	}
	
	

}
