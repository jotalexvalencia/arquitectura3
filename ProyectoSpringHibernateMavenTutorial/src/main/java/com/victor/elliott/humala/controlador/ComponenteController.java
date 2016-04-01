package com.victor.elliott.humala.controlador;
 
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
 
import com.victor.elliott.humala.formulario.ComponenteForm;
import com.victor.elliott.humala.servicios.ComponenteService;
import com.victor.elliott.humala.servicios.ComponenteServiceImpl;
 
@Controller
public class ComponenteController {
 
    private ComponenteService componenteService= new ComponenteServiceImpl();
 
    @RequestMapping(value="/agregarComponentes.html", method = RequestMethod.POST)
    public ModelAndView guardarComponente(@ModelAttribute("componenteForm") ComponenteForm componente) {
        System.out.println("Ingreso a componente guardado");
        componenteService.agregarComponente(componente);
        System.out.println("Componente guardado");
        return new ModelAndView("mostrarComponentes" , "listaComponentes", componenteService.mostrarComponentes());
    }
 
    @RequestMapping(value="/actualizarComponentes.html", method = RequestMethod.POST)
    public ModelAndView actualizarComponente(@ModelAttribute("componenteForm") ComponenteForm componente) {
        System.out.println("Ingreso a componente actualizado");
        componenteService.actualizarComponente(componente);
        System.out.println("Componente actualizado");
        return new ModelAndView("mostrarComponentes" , "listaComponentes", componenteService.mostrarComponentes());
    }
 
    @RequestMapping(value="/eliminarComponentes.html/{componenteId}", method = RequestMethod.GET)
    public ModelAndView eliminarComponente(@PathVariable("componenteId") Integer componenteId) {
        System.out.println("Ingreso a componente eliminado");
        componenteService.eliminarComponente(componenteId);
        System.out.println("Componente actualizado");
        return new ModelAndView("mostrarComponentes" , "listaComponentes", componenteService.mostrarComponentes());
    }
 
    @RequestMapping(value="/modificarComponentes.html/{componenteId}", method = RequestMethod.GET)
    public ModelAndView modificarComponente(@PathVariable("componenteId") Integer componenteId) {
        System.out.println("Vamos a modificar componente");
        ComponenteForm componente=componenteService.mostrarComponente(componenteId);
        ModelAndView modelo= new ModelAndView("agregarComponentes" , "mensaje", "Usuario Correcto");
        modelo.addObject("mensajeComponente","Modificar Componente");
        modelo.addObject("usuarioForm", UsuarioController.usuarioForm);
        modelo.addObject("componenteForm", componente);
        return modelo;
    }
 
    @RequestMapping(value="/volverComponente.html", method = RequestMethod.GET)
    public ModelAndView volverComponente() {
        System.out.println("Volvemos a agregar componente");
        System.out.println("Se coloco al usuario y clave correctamente y va a la pagina de agregarComponentes");
        ModelAndView modelo= new ModelAndView("agregarComponentes" , "mensaje", "Usuario Correcto");
        modelo.addObject("mensajeComponente","Agregar Componente");
        modelo.addObject("usuarioForm", UsuarioController.usuarioForm);
        modelo.addObject("componenteForm", new ComponenteForm());
        return modelo;
    }
 
    @RequestMapping(value="/mostrarComponentes.html", method = RequestMethod.GET)
    public ModelAndView mostrarComponentes() {
        System.out.println("Se muestran todos los componentes");
        return new ModelAndView("mostrarComponentes" , "listaComponentes", componenteService.mostrarComponentes());
    }
}