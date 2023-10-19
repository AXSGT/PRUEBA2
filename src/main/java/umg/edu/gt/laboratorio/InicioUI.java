package umg.edu.gt.laboratorio;

import com.google.gson.JsonArray;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.io.Serializable;
import java.math.BigDecimal;
import java.net.URI;
import java.sql.SQLException;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import java.net.http.HttpClient;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;
import umg.edu.gt.DAO.ConexionDAO;
import umg.edu.gt.DAO.ConsultasDAO;
import umg.edu.gt.DAO.ConsultasHb;
import umg.edu.gt.DTO.DatosDTO;
import umg.edu.gt.DTO.Cliente;
import umg.edu.gt.DTO.Detalle_orden;
import umg.edu.gt.DTO.Orden;
import umg.edu.gt.DTO.Producto;



@ManagedBean(name = "bkn_Inicio")
@ViewScoped
public class InicioUI implements Serializable {

    private String mensaje;

    private String dato1;
    private String dato2;
    private String dato3;
    private String dato4;
    private String dato5;

    private String dato6;
    private String dato7;
    private String dato8;

    private String dato9;
    private String dato10;
    private String dato11;
    private String dato12;

    private String dato13;
    private String dato14;
    private String dato15;

    private Cliente cliente;
    private Orden orden;
    private Detalle_orden detalle;
    private Producto producto;

    private boolean band;
    private List<Cliente> clientes = new ArrayList<Cliente>();
    private List<Orden> ordenes = new ArrayList<Orden>();
    private List<Detalle_orden> detalleOrdenes = new ArrayList<Detalle_orden>();
    private List<Producto> productos = new ArrayList<Producto>();

    @PostConstruct
    public void init() {

        ConsultasHb consultaHB = new ConsultasHb();

        try {
            setClientes(consultaHB.consultarCliente());
            setOrdenes(consultaHB.consultarOrden());
            setDetalleOrdenes(consultaHB.consultarDetalle());
            setProductos(consultaHB.consultarProducto());
        } catch (Exception e) {
            System.out.println("Error al Iniciar");
        }
    }

//***************************************CLIENTES*******************************************************************
    public void accionesCliente(int opt) throws Exception {
        ConsultasHb consultaHB = new ConsultasHb();

        DatosDTO cliente = new DatosDTO();

        try {

            cliente.setNombre(dato2);
            cliente.setCorreo(dato3);
            cliente.setDireccion(dato4);
            cliente.setTelefono(dato5);

            switch (opt) {
                case 1:
                    System.out.println("Respuesta insertar cliente: " + consultaHB.crearCliente(cliente));
                    break;
                case 2:
                    cliente.setId(Long.parseLong(dato1));
                    System.out.println("Respuesta actualizacio cliente: " + consultaHB.modificarCliente(cliente));
                    break;
                case 3:
                    cliente.setId(Long.parseLong(dato1));
                    System.out.println("Respuesta actualizacio cliente: " + consultaHB.eliminarCliente(cliente));
                    break;
            }

            setClientes(consultaHB.consultarCliente());
            
            dato1 = "";
            dato2 = "";
            dato3 = "";
            dato4 = "";
            dato5 = "";
            band = false;
            
        } catch (Exception ex) {
            System.out.println("Error de la accion de cliente" + ex);
        } 

    }

///***************************************ORDENES*******************************************************************
    public void accionesOrdenes(int opt) throws Exception {

        ConsultasHb consultaHB = new ConsultasHb();
        DatosDTO orden = new DatosDTO();

        try {

            orden.setCliente_id(Long.parseLong(dato6));
            orden.setFecha(dato8);
            orden.setTotal(new BigDecimal(dato7));

            switch (opt) {
                case 1:

                    consultaHB.crearOrden(orden);
                    break;
                case 2:
                    orden.setId(Long.parseLong(dato1));
                    consultaHB.modificarOrden(orden);
                    break;
                case 3:
                    orden.setId(Long.parseLong(dato1));
                    consultaHB.eliminarOrden(orden);
                    break;
            }
            
            setOrdenes(consultaHB.consultarOrden());

            dato1 = "";
            dato2 = "";
            dato3 = "";
            dato4 = "";
            dato5 = "";
            dato6 = "";
            dato7 = "";
            dato8 = "";

            band = false;
        } catch (Exception ex) {
            System.out.println("Error de la accion de cliente" + ex);
        } 

    }

//***************************************DETALLES_ORDENES*******************************************************************
    public void accionesDetalle_ordenes(int opt) throws Exception {

        ConsultasHb consultaHB = new ConsultasHb();
        DatosDTO detalle = new DatosDTO();

        try {

            detalle.setOrden_id(Long.parseLong(dato9));
            detalle.setProducto_id(Long.parseLong(dato10));
            detalle.setCantidad(Long.parseLong(dato11));
            detalle.setPrecio(new BigDecimal(dato12)); //este  para asignarle bigdeciaml al dato 12

            switch (opt) {
                case 1:
                    
                    consultaHB.crearDetalle(detalle);
                    break;
                case 2:
                    detalle.setId(Long.parseLong(dato1)); 
                    consultaHB.modificarDetalle(detalle);
                    break;
                case 3:
                    detalle.setId(Long.parseLong(dato1));
                    consultaHB.eliminarDetalle(detalle);
                    break;
            }

            setDetalleOrdenes(consultaHB.consultarDetalle());

            dato1 = "";
            dato2 = "";
            dato3 = "";
            dato4 = "";
            dato5 = "";
            dato6 = "";
            dato7 = "";
            dato8 = "";
            dato9 = "";
            dato10 = "";
            dato11 = "";
            dato12 = "";

            band = false;
        } catch (Exception ex) {
            System.out.println("Error de la accion de detalle_ordenes" + ex);
        } 
    }

    //***************************************PRODUCTOS*******************************************************************
    public void accionesProductos(int opt) throws Exception {

        ConexionDAO con = new ConexionDAO();
        ConsultasDAO consulta = new ConsultasDAO();
        ConsultasHb consultaHB = new ConsultasHb();
        
        DatosDTO producto = new DatosDTO();

        try {

            producto.setNombre(dato2);
            producto.setDescripcion(dato13);
            producto.setPrecio(new BigDecimal(dato12));     //dato12
            producto.setCantidad(Long.parseLong(dato11));

            switch (opt) {
                case 1:

                    consultaHB.crearProducto(producto);
                    break;
                case 2:
                    
                    producto.setId(Long.parseLong(dato1));
                    System.out.println("Id producto: " + producto.getId());
                    consultaHB.modificarProducto(producto);
                    break;
                case 3:
                    producto.setId(Long.parseLong(dato1));
                    //consulta.eliminarProducto(producto);
                    consultaHB.eliminarProducto(producto);
                    break;
            }

            setProductos(consultaHB.consultarProducto());

            dato1 = "";
            dato2 = "";
            dato3 = "";
            dato4 = "";
            dato5 = "";
            dato6 = "";
            dato7 = "";
            dato8 = "";
            dato9 = "";
            dato10 = "";
            dato11 = "";
            dato12 = "";
            dato13 = "";
            dato14 = "";
            dato15 = "";

            band = false;
        } catch (Exception ex) {
            System.out.println("UnicioUI Error de la accion de Productos" + ex);
        } 

    }
    
     public void clienteSeleccionado(SelectEvent event) {
        cliente = (Cliente) event.getObject();

        //datos cliente
        dato1 = Long.toString(getCliente().getId());
        dato2 = cliente.getNombre();
        dato3 = cliente.getCorreo();
        dato4 = cliente.getDireccion();
        dato5 = cliente.getTelefono();

        band = true;

    }

    public void ordenSeleccionada(SelectEvent event) {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        String fechaFormateada;

        orden = (Orden) event.getObject();

        dato1 = Long.toString(orden.getId());      
        dato6 = Long.toString(orden.getCliente_id());
        dato7 = orden.getTotal().toString();    //en caso de problema regresar al de abajo
        //dato7 = Long.toString(orden.getTotal());

        fechaFormateada = formato.format(orden.getFecha());
        dato8 = fechaFormateada;

        band = true;

    }

    public void detalleSeleccionado(SelectEvent event) {
        detalle = (Detalle_orden) event.getObject();

        dato1 = Long.toString(detalle.getId());
        dato9 = Long.toString(detalle.getOrden_id());
        dato10 = Long.toString(detalle.getProducto_id());
        dato11 = Long.toString(detalle.getCantidad());
        dato12 = detalle.getPrecio().toString(); //en caso de problema regresar al de abajo
       // dato12 = Long.toString(detalle.getPrecio());
      
        band = true;
    }
    
    public void productoSeleccionado(SelectEvent event) {
        producto = (Producto) event.getObject();

        dato1 = Long.toString(producto.getId());
        dato2 = producto.getNombre();
        dato13 = producto.getDescripcion();
         dato12 = producto.getPrecio().toString(); //en caso de problema regresar al de abajo
       // dato12 = Long.toString(producto.getPrecio());
        dato11 = Long.toString(producto.getCantidad());
      
        band = true;
    }

    public void onRowUnselect(UnselectEvent event) {
        dato1 = "";
        dato2 = "";
        dato3 = "";
        dato4 = "";
        dato5 = "";

    }

    /**
     * @return the cliente
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * @param cliente the cliente to set
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    /**
     * @return the orden
     */
    public Orden getOrden() {
        return orden;
    }

    /**
     * @param orden the orden to set
     */
    public void setOrden(Orden orden) {
        this.orden = orden;
    }

    /**
     * @return the productos
     */
    public List<Producto> getProductos() {
        return productos;
    }

    /**
     * @param productos the productos to set
     */
    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    /**
     * @return the dato12
     */
    public String getDato12() {
        return dato12;
    }

    /**
     * @param dato12 the dato12 to set
     */
    public void setDato12(String dato12) {
        this.dato12 = dato12;
    }

    /**
     * @return the dato9
     */
    public String getDato9() {
        return dato9;
    }

    /**
     * @param dato9 the dato9 to set
     */
    public void setDato9(String dato9) {
        this.dato9 = dato9;
    }

    /**
     * @return the dato10
     */
    public String getDato10() {
        return dato10;
    }

    /**
     * @param dato10 the dato10 to set
     */
    public void setDato10(String dato10) {
        this.dato10 = dato10;
    }

    /**
     * @return the dato11
     */
    public String getDato11() {
        return dato11;
    }

    /**
     * @param dato11 the dato11 to set
     */
    public void setDato11(String dato11) {
        this.dato11 = dato11;
    }

    /**
     * @return the dato8
     */
    public String getDato8() {
        return dato8;
    }

    /**
     * @param dato8 the dato8 to set
     */
    public void setDato8(String dato8) {
        this.dato8 = dato8;
    }

    /**
     * @return the ordenes
     */
    public List<Orden> getOrdenes() {
        return ordenes;
    }

    /**
     * @param ordenes the ordenes to set
     */
    public void setOrdenes(List<Orden> ordenes) {
        this.ordenes = ordenes;
    }

    /**
     * @return the detalle_ordenes
     */
    public List<Detalle_orden> getDetalleOrdenes() {
        return detalleOrdenes;
    }

    /**
     * @param detalle_ordenes the detalle_ordenes to set
     */
    public void setDetalleOrdenes(List<Detalle_orden> detalleOrdenes) {
        this.detalleOrdenes = detalleOrdenes;
    }

    /**
     * @return the producto
     */
    public Producto getProducto() {
        return producto;
    }

    /**
     * @param producto the producto to set
     */
    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    /**
     * @return the dato13
     */
    public String getDato13() {
        return dato13;
    }

    /**
     * @param dato13 the dato13 to set
     */
    public void setDato13(String dato13) {
        this.dato13 = dato13;
    }

    /**
     * @return the dato14
     */
    public String getDato14() {
        return dato14;
    }

    /**
     * @param dato14 the dato14 to set
     */
    public void setDato14(String dato14) {
        this.dato14 = dato14;
    }

    /**
     * @return the dato15
     */
    public String getDato15() {
        return dato15;
    }

    /**
     * @param dato15 the dato15 to set
     */
    public void setDato15(String dato15) {
        this.dato15 = dato15;
    }

    /**
     * @return the dato6
     */
    public String getDato6() {
        return dato6;
    }

    /**
     * @param dato6 the dato6 to set
     */
    public void setDato6(String dato6) {
        this.dato6 = dato6;
    }

    /**
     * @return the dato7
     */
    public String getDato7() {
        return dato7;
    }

    /**
     * @param dato7 the dato7 to set
     */
    public void setDato7(String dato7) {
        this.dato7 = dato7;
    }

    /**
     * @return the band
     */
    public boolean isBand() {
        return band;
    }

    /**
     * @param band the band to set
     */
    public void setBand(boolean band) {
        this.band = band;
    }

    /**
     * @param mensaje the mensaje to set
     */
    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    /**
     * @return the dato1
     */
    public String getDato1() {
        return dato1;
    }

    /**
     * @param dato1 the dato1 to set
     */
    public void setDato1(String dato1) {
        this.dato1 = dato1;
    }

    /**
     * @return the dato2
     */
    public String getDato2() {
        return dato2;
    }

    /**
     * @param dato2 the dato2 to set
     */
    public void setDato2(String dato2) {
        this.dato2 = dato2;
    }

    /**
     * @return the dato3
     */
    public String getDato3() {
        return dato3;
    }

    /**
     * @param dato3 the dato3 to set
     */
    public void setDato3(String dato3) {
        this.dato3 = dato3;
    }

    /**
     * @return the lista
     */
    public List<Cliente> getClientes() {
        return clientes;
    }

    /**
     * @param lista the lista to set
     */
    public void setClientes(List<Cliente> lista) {
        this.clientes = lista;
    }

    /**
     * @return the dato4
     */
    public String getDato4() {
        return dato4;
    }

    /**
     * @param dato4 the dato4 to set
     */
    public void setDato4(String dato4) {
        this.dato4 = dato4;
    }

    /**
     * @return the dato5
     */
    public String getDato5() {
        return dato5;
    }

    /**
     * @param dato5 the dato5 to set
     */
    public void setDato5(String dato5) {
        this.dato5 = dato5;
    }

    public void consumeWS() throws IOException, InterruptedException {
    

        String url = "http://localhost:8080/LabWS/webresources/DesarrolloWeb/primerWS";

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());

        request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println("respuesta: " + response.body());

    }

}
