import javax.swing.*;
/**Esta clase se encarga de deplegar mensajes 
 * en forma grafia
 * 
 */
class InteractiveIO {

        /*Metodos de delplegar mensajes Interfas Grafica */
        /*Se le pasa el mensaje y el titulo de la ventana*/
		//---------------------------------------------------------------------
		public void desplegarError(String cadena,String tituloVentana) {
			JOptionPane.showMessageDialog(null,cadena,tituloVentana, JOptionPane.ERROR_MESSAGE);

		}
		public void desplegarINFORMA(String cadena,String tituloVentana) {
			JOptionPane.showMessageDialog(null,cadena,tituloVentana, JOptionPane.INFORMATION_MESSAGE);

		}
		public void desplegarWARNING(String cadena,String tituloVentana) {
			JOptionPane.showMessageDialog(null,cadena,tituloVentana, JOptionPane.WARNING_MESSAGE);

		}
		public void desplegarQUESTION(String cadena,String tituloVentana) {
			JOptionPane.showMessageDialog(null,cadena,tituloVentana, JOptionPane.QUESTION_MESSAGE);

		}

/********************************************************************** */
		/*Este metodo se encarga de mostrar la lista de carreras de la CRUV-FIEC */
		/*El usuario seleciona la carrera y lo devolvemos como String*/
        public String getCarreta() {
           Object[] options = {"LIC. DE INGENIERIA EN INFORMATICA","TECNICO EN INFORMATICA EDUCATIVA","LIC. PARA LA GESTION EDUC Y EMPRESA"};

           return((String)JOptionPane.showInputDialog(null, "Seleccione...","UP-CRUV-FIEC", JOptionPane.QUESTION_MESSAGE, null, options, options[0]));
        }

}