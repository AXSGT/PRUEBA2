
package umg.edu.gt.DTO;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.faces.bean.ManagedBean;

public class DatosDTO implements Serializable{
  //PARA CLIENTES
    private Long id;
    private String nombre;
    private String correo;
    private String direccion;
    private String telefono;

    //para ORDENES
    private BigDecimal total;
    private String fecha;
    private Long cliente_id;
    
    //PARA DETALLES_ORDENES
    private Long orden_id;
    private Long producto_id;
    private Long cantidad;
   // private Long precio;
    private BigDecimal precio;  //para extraerle los decimales

    private String descripcion;
    
     /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    /**
     * @return the orden_id
     */
    public Long getOrden_id() {
        return orden_id;
    }

    /**
     * @param orden_id the orden_id to set
     */
    public void setOrden_id(Long orden_id) {
        this.orden_id = orden_id;
    }

    /**
     * @return the producto_id
     */
    public Long getProducto_id() {
        return producto_id;
    }

    /**
     * @param producto_id the producto_id to set
     */
    public void setProducto_id(Long producto_id) {
        this.producto_id = producto_id;
    }

    /**
     * @return the cantidad
     */
    public Long getCantidad() {
        return cantidad;
    }

    /**
     * @param cantidad the cantidad to set
     */
    public void setCantidad(Long cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * @return the precio
     */
  
  //  en caso de error regresar esto o quitarle los //
  //  public Long getPrecio() {
   //     return precio;
   // }

    /**
     * @param precio the precio to set
     */
    //public void setPrecio(Long precio) {
    //    this.precio = precio;
    //}

    
    
    /**
     * @return the cliente_id
     */
    public Long getCliente_id(){
        return cliente_id;
    }

    /**
     * @param cliente_id the cliente_id to set
     */
    public void setCliente_id(Long cliente_id) {
        this.cliente_id = cliente_id;
    }
    
    /**
     * @return the fecha
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    /**
     * @return the total
     */
    public BigDecimal getTotal() {
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the correo
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * @param correo the correo to set
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * @return the direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * @param direccion the direccion to set
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * @return the telefono
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * @param telefono the telefono to set
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * @return the precio
     */
    public BigDecimal getPrecio() {
        return precio;
    }

    /**
     * @param precio the precio to set
     */
    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }
}
