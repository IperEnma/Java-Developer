package mayeca.ui;
import javax.swing.JComponent;
import javax.swing.JLabel;
import models.client.*;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author fsociety
 */
public class UImayeca {
    
    public static void interfaceUser()
    {
        iRegister clientes = new implementsRegister();
        models cliente;
        
        close:
        while(true) 
        {
            String opt = JOptionPane.showInputDialog(
                    null,
                    "1. Registrar cliente\n"
                            + "2. Mostrar clientes\n"
                            + "3. Buscar cliente\n"
                            + "4. salir",
                    "Selecione una opcion",
                    3
            );
            switch(opt)
            {
                case "1":
                {
                    JTextField nameI = new JTextField();
                    JTextField DNI = new JTextField();
                    JTextField position = new JTextField();
                    final JComponent[] inputs = new JComponent[] {
                        new JLabel("Ingrese nombre"),
                        nameI,
                        new JLabel("Ingrese DNI"),
                        DNI,
                        new JLabel("Ingrese cargo"),
                        position
                    };
                    JOptionPane.showConfirmDialog(
                            null,
                            inputs,
                            "Registro de cliente",
                            JOptionPane.OK_CANCEL_OPTION
                    );
                    cliente = new models(nameI.getText(), Integer.parseInt(DNI.getText()), position.getText());
                    clientes.register(cliente);
                    break;
                }
                case "2":
                    clientes.show();
                    break;
                case "3":
                    String nameS = JOptionPane.showInputDialog(
                    null,
                            "Ingrese nombre del cliente",
                            "Search",
                            3
                    );
                    clientes.search(nameS);
                    break;
                case "4":
                    break close;
                default:
                    JOptionPane.showMessageDialog(
                            null,
                            "OPCION INCORRECTA!",
                            "Error",
                            JOptionPane.ERROR_MESSAGE
                    );
            }
        }
    }
}
