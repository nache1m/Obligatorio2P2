package Dominio.ArchivosLectura;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class ResaltadorColores extends DefaultTableCellRenderer {
    private String palabraBuscada;

    public void setPalabraBuscada(String palabraBuscada) {
        this.palabraBuscada = palabraBuscada;
    }
    public String getPalabraBuscada(){
        return this.palabraBuscada;
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        JLabel label = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        if (palabraBuscada != null && !palabraBuscada.isEmpty()) {
            String texto = value.toString();
            String textoResaltado = resaltarPalabraEnCelda(texto);
            label.setText(textoResaltado);
        }

        return label;
    }

    private String resaltarPalabraEnCelda(String texto) {
        if (texto != null && !texto.isEmpty()) {
            String palabraLower = palabraBuscada.toLowerCase();
            String textoLower = texto.toLowerCase();

            int indice = textoLower.indexOf(palabraLower);
            if (indice >= 0) {
                int longitudPalabra = palabraBuscada.length();
                StringBuilder resultado = new StringBuilder();

                for (int i = 0; i < texto.length(); i++) {
                    char caracter = texto.charAt(i);
                    Color color = (i >= indice && i < indice + longitudPalabra) ? Color.RED : Color.BLACK;
                    resultado.append("<font color='").append(getColorHex(color)).append("'>").append(caracter).append("</font>");
                }

                return "<html>" + resultado.toString() + "</html>";
            }
        }

        return texto;
    }

    private String getColorHex(Color color) {
        return String.format("#%02x%02x%02x", color.getRed(), color.getGreen(), color.getBlue());
    }
}
