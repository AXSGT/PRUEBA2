package umg.edu.gt.DTO;

import java.io.Serializable;
import java.math.BigDecimal;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author axel
 */
@Entity
@Table (name = "ordenes")
public class Orden implements Serializable {   
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id")
    private Long id;
    
    @Column (name = "cliente_id")
    private Long cliente_id;
    
    @Column (name = "fecha")
    private Date fecha;
    
    @Column(name = "total")
    private BigDecimal total;

    public Orden( Long cliente_id, Date fecha, BigDecimal total) {
  
        this.cliente_id = cliente_id;
        
        this.fecha = fecha;
        
        this.total = total;
    }

    public Orden() {
        
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
     * @return the cliente_id
     */
    public Long getCliente_id() {
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
    public Date getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(Date fecha) {
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
}
