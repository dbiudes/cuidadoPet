package br.com.dorival.petcare.persistence;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import br.com.dorival.petcare.persistence.Mensagem;
import br.com.dorival.petcare.persistence.Usuario;
public class Utilidades {
	
    private static List<Mensagem> mensagens = new ArrayList<Mensagem>();
    private static List<Usuario> usuarios = new ArrayList<Usuario>();

	public Utilidades() {
		super();
	}
    public static Mensagem getMessage(int index)
    {
    	return Utilidades.mensagens.get(index);
    }
    public static List<Mensagem> getMensagens()
    {
    	return Utilidades.mensagens;
    }
    public static void add(Mensagem msg)
    {
    	Utilidades.mensagens.add(msg);
    }
    public static Usuario getUsuario(Usuario user)
    {
    	for(Usuario u : Utilidades.usuarios)
    	{
    		if(u.getNome().equalsIgnoreCase(user.getNome()))
    			return u;
    	}
    	return null;
    }
    public static void adicionaUsuario(Usuario user)
    {
    	Utilidades.usuarios.add(user);
    	return;
    }
    public static List<Usuario> getUsuarios()
    {
    	return Utilidades.usuarios;
    }
    public static void removeUsuario(String user)
    {
    	 Iterator<Usuario> itr = Utilidades.usuarios.iterator();
         while(itr.hasNext()) {
        	 Usuario usuario = itr.next();
        	 System.out.println("removendo: " + user + "- na fila:"+ usuario.getNome());
            if(user.equalsIgnoreCase(usuario.getNome()))
            {
            	Utilidades.usuarios.remove(usuario);
            	break;
            }
         }
    	return;
    }
    public static void removeAll()
    {
    	Utilidades.usuarios.clear();
    	Utilidades.mensagens.clear();
    	return;
    }   
}
