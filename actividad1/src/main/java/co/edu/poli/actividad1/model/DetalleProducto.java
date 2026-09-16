package co.edu.poli.actividad1.model;

public class DetalleProducto {
	
	private Long detalleProducto;
	private String notas;
	private Long detallePedido;
	private Long productoId;
	
	public DetalleProducto(Long detalleProducto, String notas, Long detallePedido, Long productoId) {
		super();
		this.detalleProducto = detalleProducto;
		this.notas = notas;
		this.detallePedido = detallePedido;
		this.productoId = productoId;
	}

	public Long getDetalleProducto() {
		return detalleProducto;
	}

	public void setDetalleProducto(Long detalleProducto) {
		this.detalleProducto = detalleProducto;
	}

	public String getNotas() {
		return notas;
	}

	public void setNotas(String notas) {
		this.notas = notas;
	}

	public Long getDetallePedido() {
		return detallePedido;
	}

	public void setDetallePedido(Long detallePedido) {
		this.detallePedido = detallePedido;
	}

	public Long getProductoId() {
		return productoId;
	}

	public void setProductoId(Long productoId) {
		this.productoId = productoId;
	}

	@Override
	public String toString() {
		return "DetalleProducto [detalleProducto=" + detalleProducto + ", notas=" + notas + ", detallePedido="
				+ detallePedido + ", productoId=" + productoId + "]";
	}
	
	
	
	
	

}
