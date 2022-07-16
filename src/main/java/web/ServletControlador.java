package web;

import data.DiscografiaDAO;
import entity.Discos;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/servletControlador")
public class ServletControlador extends HttpServlet{
    
       @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String accion = req.getParameter("accion");

        if (accion != null){
            switch (accion){
                case "editar":
                    editarDiscos(req, res);
                    break;
                case "eliminar":
                    eliminarDiscos(req,res);
                    break;
                default:
                    accionDefault(req, res);
                    break;
            }
        } else {
            accionDefault(req, res);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String accion = req.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "insertar":
                    guardarDiscos(req, res);
                    break;
                case "modificar":
                    modificarDiscos(req, res);
                    break;
                default:
                    accionDefault(req, res);
                    break;

            }
        }
    }

    private void accionDefault(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        List<Discos> discos = new DiscografiaDAO().findAll();
        HttpSession sesion = req.getSession();
        sesion.setAttribute("pepe", discos);
        sesion.setAttribute("cantidadDiscos", calcularCant(discos));
        sesion.setAttribute("precioTotal", calcularPrecio(discos));
        //req.getRequestDispatcher("discos.jsp").forward(req, res);
        res.sendRedirect("discos.jsp");
    }

    private void guardarDiscos(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String nombre = req.getParameter("nombre");
        String autor = req.getParameter("autor");
        int canciones = Integer.parseInt(req.getParameter("canciones"));
        double precio = Double.parseDouble(req.getParameter("precio"));
        int stock = Integer.parseInt(req.getParameter("stock"));

        Discos disco = new Discos(nombre, autor, canciones, precio, stock);
        int regMod = new DiscografiaDAO().create(disco);
        System.out.println("Insertados: " + regMod);
        accionDefault(req, res);
    }

    private void editarDiscos(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        int idDiscos = Integer.parseInt(req.getParameter("idDiscos"));
        Discos lib = new DiscografiaDAO().findDiscoById(idDiscos);
        req.setAttribute("disco", lib);
        req.getRequestDispatcher("/WEB-INF/paginas/operaciones/editarDisco.jsp").forward(req, res);
    }

    private void modificarDiscos(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String nombre = req.getParameter("nombre");
        String autor = req.getParameter("autor");
        int canciones = Integer.parseInt(req.getParameter("canciones"));
        double precio = Double.parseDouble(req.getParameter("precio"));
        int stock = Integer.parseInt(req.getParameter("stock"));

        int idDiscos = Integer.parseInt(req.getParameter("idDiscos"));

        Discos lib = new Discos(idDiscos, nombre, autor, canciones, precio, stock);

        int regMod = new DiscografiaDAO().update(lib);

        System.out.println("SE ACTUALIZARON: " + regMod + " REGISTROS");

        accionDefault(req, res);
    }
    
    private void eliminarDiscos(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        int idDiscos = Integer.parseInt(req.getParameter("idDiscos"));
        
        int regDel = new DiscografiaDAO().delete(idDiscos);
        
        System.out.println("REGISTROS ELIMINADOS: "+ regDel);
        
        accionDefault(req, res);
    }

    private int calcularCant(List<Discos> lista) {
        int cantidad = 0;
        for (int i = 0; i < lista.size(); i++) {
            cantidad += lista.get(i).getStock();
        }
        return cantidad;
    }

    private double calcularPrecio(List<Discos> lista) {
        double precio = 0;
        for (int i = 0; i < lista.size(); i++) {
            precio += (lista.get(i).getStock() * lista.get(i).getPrecio());
        }
        return precio;
    }
    
    
    
}
