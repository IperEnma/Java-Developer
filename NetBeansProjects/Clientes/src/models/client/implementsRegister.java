package models.client;
import java.util.ArrayList;
import javax.swing.JOptionPane;
/**
 *
 * @author fsociety
 */
public class implementsRegister implements iRegister{
    
    private final ArrayList<models> listaClientes;
    
    public implementsRegister()
    {
        this.listaClientes = new ArrayList<>();
    }
    @Override
    public void register(models cliente) {
        listaClientes.add(cliente); 
    }

    @Override
    public void show() {
        String []choices = new String[listaClientes.size()];
        int i = 0;
        for (models client : this.listaClientes) {
            choices[i] = "Client: " + client.getName() + "\n" 
                    + "DNI: " + client.getDNI() + "\n"
                    + "Position: " + client.getPosition() + "\n\n\n";
            i++;
        }
        JOptionPane.showMessageDialog(
                null, 
                choices,
                "Clientes",
                JOptionPane.INFORMATION_MESSAGE);
    }

    @Override
    public void search(String name) {
        String found = null;
        for (var item : this.listaClientes)
        {
            if (name.equals(item.getName()))
            {
                found = item.getName();
            }
                
        }
        if (name.equals(found))
        {
            JOptionPane.showMessageDialog(
                    null,
                    "Cliente existe",
                    "Buscando cliente",
                    JOptionPane.QUESTION_MESSAGE
            );
        }
        else 
        {
            JOptionPane.showMessageDialog(
                    null,
                    "Cliente no existe",
                    "Buscando cliente",
                    JOptionPane.WARNING_MESSAGE
            );
        }
    }
    
}
