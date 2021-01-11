package gal.udc.fic.vvs.email.correo;

import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import gal.udc.fic.vvs.email.archivo.Texto;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Vector;

@RunWith(JUnitQuickcheck.class)
public class CarpetaTestPBT {



    /**
     *
     */
    @Property
    public void testObtenerHijoCarpeta(String nombre, String nombreTxt, String contenidoTxt) {
        Carpeta carpeta = new Carpeta(nombre);

        Texto txt = new Texto(nombreTxt, contenidoTxt);
         Mensaje mensaje = new Mensaje(txt);



        try {
        carpeta.añadir(mensaje);

         } catch (OperacionInvalida operacionInvalida) {

         }

        try {
        Assert.assertEquals(mensaje,carpeta.obtenerHijo(0));

         } catch (OperacionInvalida operacionInvalida) {
        operacionInvalida.printStackTrace();
          }
    }

    /**
     *
     */
    @Property
    public void testEstablecerYObtenerPadreCarpeta(String nombre, String nombre2) {
        Carpeta carpeta = new Carpeta(nombre);

        Carpeta carpeta2 = new Carpeta(nombre2);

        carpeta2.establecerPadre(carpeta);


        Assert.assertEquals(carpeta2, carpeta2.obtenerPadre());



    }
}
