package gal.udc.fic.vvs.email.archivo;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class TextoTest extends TestCase {

    private String nombreTexto = "Texto";
    private String contenido = "Texto número uno";

    /**
     * Obtener mimeType de texto.
     */
    @Test
    public void testObtenerMimeImagenType() {
        Texto texto = new Texto(nombreTexto, contenido);
        String mimeType = texto.obtenerMimeType();

        Assert.assertEquals("text/plain", mimeType);
    }


    /**
     * Obtener nombre del archivo texto.
     */
    @Test
    public void obtenerNombreImagenTest(){
        Texto texto = new Texto(nombreTexto, contenido);


        Assert.assertEquals(nombreTexto,texto.obtenerNombre());
    }

    /**
     *Obtener contenido del archivo texto.
     */
    @Test
    public void obtenerContenidoImagenTest(){
        Texto texto = new Texto(nombreTexto, contenido);

        Assert.assertEquals(contenido, texto.obtenerContenido());
    }

    /**
     *Obtener tamaño del archivo texto.
     */
    @Test
    public void obtenerTamañoImagenTest(){
        Texto texto = new Texto(nombreTexto, contenido);


        Assert.assertEquals((nombreTexto+contenido).length(), texto.obtenerTamaño());

    }

    /**
     *Obtener previsualización del archivo texto.
     */
    @Test
    public void obtenerPrevisualizacionArchivoImagenTest(){
        Texto texto = new Texto(nombreTexto, contenido);


        String previ = nombreTexto + "(" + contenido.length() + " bytes, " + "text/plain" + ")";

        Assert.assertEquals(previ, texto.obtenerPreVisualizacion());

    }
}