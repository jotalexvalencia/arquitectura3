package com.victor.elliott.humala.servicios;
 
import java.util.List;
 
import com.victor.elliott.humala.dao.ComponenteDAO;
import com.victor.elliott.humala.dao.ComponenteDAOImpl;
import com.victor.elliott.humala.formulario.ComponenteForm;
 
public class ComponenteServiceImpl implements ComponenteService{
 
    private ComponenteDAO componenteDAO = new ComponenteDAOImpl();
 
    public void agregarComponente(ComponenteForm componente) {
        // TODO Auto-generated method stub
        componenteDAO.agregarComponente(componente);
    }
 
    public List<ComponenteForm> mostrarComponentes() {
        // TODO Auto-generated method stub
        return componenteDAO.mostrarComponentes();
    }
 
    public void eliminarComponente(Integer id) {
        // TODO Auto-generated method stub
        componenteDAO.eliminarComponente(id);
    }
 
    public void actualizarComponente(ComponenteForm componente) {
        // TODO Auto-generated method stub
        componenteDAO.actualizarComponente(componente);
    }
 
    public ComponenteForm mostrarComponente(int id) {
        // TODO Auto-generated method stub
        return componenteDAO.mostrarComponente(id);
    }
 
}