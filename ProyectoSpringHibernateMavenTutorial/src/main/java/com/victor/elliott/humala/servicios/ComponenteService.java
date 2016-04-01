package com.victor.elliott.humala.servicios;
 
import java.util.List;
import com.victor.elliott.humala.formulario.ComponenteForm;
 
public interface ComponenteService {
     public void agregarComponente(ComponenteForm componente);
     public List<ComponenteForm> mostrarComponentes();
     public void eliminarComponente(Integer id);
     public void actualizarComponente(ComponenteForm componente);
     public ComponenteForm mostrarComponente(int id);
}