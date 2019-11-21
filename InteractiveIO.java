import javax.swing.*;
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
			System.exit(0);
		}




}