package gal.udc.fic.vvs.email.archivo;

import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import org.junit.Assert;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitQuickcheck.class)
public class ImagenTestPBT {

    @Property
    public void obtenerMimeTypeImagen(String aleatorio1, String aleatorio2) {
        Imagen img = new Imagen(aleatorio1, aleatorio2);
        assertEquals("image/png", img.obtenerMimeType());
    }

    @Property
    public void obtenerNombreImagen(String aleatorio) {
        Imagen img = new Imagen(aleatorio, "contenido");
        Assert.assertEquals(aleatorio , img.obtenerNombre());
    }

    @Property
    public void obtenerContenidoAudio(String aleatorio) {
        Imagen img = new Imagen("nombre", aleatorio);
        Assert.assertEquals(aleatorio , img.obtenerContenido());
    }

    @Property
    public void obtnerTamañoAudio(String aleatorio1, String aleatorio2) {
        Imagen img = new Imagen(aleatorio1, aleatorio2);
        Assert.assertEquals(aleatorio2.length() , img.obtenerTamaño());
    }

    @Property
    public void obtenerPreVisualizacion(String aleatorio1, String aleatorio2) {
        Imagen img = new Imagen(aleatorio1, aleatorio2);
        String previ = aleatorio1 + "(" + aleatorio2.length() + " bytes, " + "image/png" + ")";
        Assert.assertEquals(previ, img.obtenerPreVisualizacion());
    }
}
