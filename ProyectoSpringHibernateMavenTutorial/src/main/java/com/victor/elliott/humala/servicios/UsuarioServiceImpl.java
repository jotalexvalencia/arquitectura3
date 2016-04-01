package com.victor.elliott.humala.servicios;
 
import com.victor.elliott.humala.dao.UsuarioDAO;
import com.victor.elliott.humala.dao.UsuarioDAOImpl;
import com.victor.elliott.humala.formulario.UsuarioForm;
 
public class UsuarioServiceImpl implements UsuarioService{
 
    private UsuarioDAO usuarioDAO=new UsuarioDAOImpl();
 
    public boolean buscarUsuario(UsuarioForm usuario) {
        // TODO Auto-generated method stub
        return usuarioDAO.buscarUsuario(usuario);
    }
}