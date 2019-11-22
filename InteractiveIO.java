import javax.swing.*;
class InteractiveIO {

        /*Metodos de delplegar mensajes Interfas Grafica */
        /*Se le pasa el mensaje y el titulo de la ventana*/
		//---------------------------------------------------------------------
		public void desplegarError(String cadena,String tituloVentana) {
			JOptionPane.showMessageDialog(null,cadena,tituloVentana, JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}
		public void desplegarINFORMA(String cadena,String tituloVentana) {
			JOptionPane.showMessageDialog(null,cadena,tituloVentana, JOptionPane.INFORMATION_MESSAGE);
			System.exit(0);
		}
		public void desplegarWARNING(String cadena,String tituloVentana) {
			JOptionPane.showMessageDialog(null,cadena,tituloVentana, JOptionPane.WARNING_MESSAGE);
			System.exit(0);
		}
		public void desplegarQUESTION(String cadena,String tituloVentana) {
			JOptionPane.showMessageDialog(null,cadena,tituloVentana, JOptionPane.QUESTION_MESSAGE);
			System.exit(0);
		}

/********************************************************************** */
		/*Este metodo se encarga de mostrar la lista de carreras de la CRUV-FIEC */
		/*El usuario seleciona la carrera y lo devolvemos como String*/
        public String getCarreta() {
           Object[] options = {"LIC. DE INGENIERIA EN INFORMATICA","TECNICO EN INFORMATICA EDUCATIVA","LIC. PARA LA GESTION EDUC Y EMPRESA"};

           return((String)JOptionPane.showInputDialog(null, "Seleccione...","UP-CRUV-FIEC", JOptionPane.QUESTION_MESSAGE, null, options, options[0]));
        }

}