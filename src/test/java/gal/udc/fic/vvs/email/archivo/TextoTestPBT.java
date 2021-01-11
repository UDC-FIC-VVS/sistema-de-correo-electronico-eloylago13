package gal.udc.fic.vvs.email.archivo;

import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import org.junit.Assert;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitQuickcheck.class)
public class TextoTestPBT {

    @Property
    public void obtenerMimeTypeTexto(String aleatorio1, String aleatorio2) {
        Texto txt = new Texto(aleatorio1, aleatorio2);
        Assert.assertEquals("text/plain", txt.obtenerMimeType());
    }

    @Property
    public void obtenerNombreTexto(String aleatorio) {
        Texto txt = new Texto(aleatorio, "contenido");
        Assert.assertEquals(aleatorio , txt.obtenerNombre());
    }

    @Property
    public void obtenerContenidoTexto(String aleatorio) {
        Texto txt = new Texto("nombre", aleatorio);
        Assert.assertEquals(aleatorio , txt.obtenerContenido());
    }

    @Property
    public void obtnerTamañoTexto(String aleatorio1, String aleatorio2) {
        Texto txt = new Texto(aleatorio1, aleatorio2);
        Assert.assertEquals(aleatorio2.length() , txt.obtenerTamaño());
    }

    @Property
    public void obtenerPreVisualizacion(String aleatorio1, String aleatorio2) {
        Texto txt = new Texto(aleatorio1, aleatorio2);
        String previ = aleatorio1 + "(" + aleatorio2.length() + " bytes, " + "text/plain" + ")";
        Assert.assertEquals(previ, txt.obtenerPreVisualizacion());
    }
}
