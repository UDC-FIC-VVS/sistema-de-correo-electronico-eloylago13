package gal.udc.fic.vvs.archunit;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.lang.ArchRule;
import gal.udc.fic.vvs.email.correo.Correo;
import org.junit.Test;

import java.util.Collection;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.methods;

public class TestCorreoArchUnit {

    @Test
    public void archUnitCorreoAccesibilidad(){
        JavaClasses clase = new ClassFileImporter().importPackages("gal.udc.fic.vvs.email.correo");

        ArchRule rule = classes().should().notBePrivate();
    }

    @Test
    public void archUnitestablecerLeidoCorreoDevuelvevoid(){
        JavaClasses clase = new ClassFileImporter().importPackages("gal.udc.fic.vvs.email.archivo");

        ArchRule rule = methods().that().haveFullName("establecerLeido").should().haveRawReturnType(Void.class);
    }

    @Test
    public void archUnitCorreoobtenerNoLeidosDevuelveint(){
        JavaClasses clase = new ClassFileImporter().importPackages("gal.udc.fic.vvs.email.archivo");

        ArchRule rule = methods().that().haveFullName("obtenerNoLeidos").should().haveRawReturnType(Integer.class);
    }
    @Test
    public void archUnitCorreoobtenerIconoDevuelveInteger(){
        JavaClasses clase = new ClassFileImporter().importPackages("gal.udc.fic.vvs.email.archivo");

        ArchRule rule = methods().that().haveFullName("obtenerIcono").should().haveRawReturnType(Integer.class);
    }
    @Test
    public void archUnitCorreoobtenerTamañoDevuelveint(){
        JavaClasses clase = new ClassFileImporter().importPackages("gal.udc.fic.vvs.email.archivo");

        ArchRule rule = methods().that().haveFullName("obtenerTamaño").should().haveRawReturnType(Integer.class);
    }
    @Test
    public void archUnitCorreoobtenerPreVisualizacionDevuelveString(){
        JavaClasses clase = new ClassFileImporter().importPackages("gal.udc.fic.vvs.email.archivo");

        ArchRule rule = methods().that().haveFullName("obtenerPreVisualizacion").should().haveRawReturnType(String.class);
    }
    @Test
    public void archUnitCorreoobtenerVisualizacionDevuelveString(){
        JavaClasses clase = new ClassFileImporter().importPackages("gal.udc.fic.vvs.email.archivo");

        ArchRule rule = methods().that().haveFullName("obtenerVisualizacion").should().haveRawReturnType(String.class);
    }
    @Test
    public void archUnitCorreoobtenerRutaDevuelve(){
        JavaClasses clase = new ClassFileImporter().importPackages("gal.udc.fic.vvs.email.archivo");

        ArchRule rule = methods().that().haveFullName("obtenerNombre").should().haveRawReturnType(String.class);
    }

    @Test
    public void archUnitCorreoexplorarDevuelveCollection(){
        JavaClasses clase = new ClassFileImporter().importPackages("gal.udc.fic.vvs.email.archivo");

        ArchRule rule = methods().that().haveFullName("explorar").should().haveRawReturnType(Collection.class);
    }
    @Test
    public void archUnitCorreobuscarDevuelveCollection(){
        JavaClasses clase = new ClassFileImporter().importPackages("gal.udc.fic.vvs.email.archivo");

        ArchRule rule = methods().that().haveFullName("buscar").should().haveRawReturnType(Collection.class);
    }
    @Test
    public void archUnitCorreoañadirDevuelvevoid(){
        JavaClasses clase = new ClassFileImporter().importPackages("gal.udc.fic.vvs.email.archivo");

        ArchRule rule = methods().that().haveFullName("añadir").should().haveRawReturnType(void.class);
    }
    @Test
    public void archUnitCorreoeliminarDevuelvevoid(){
        JavaClasses clase = new ClassFileImporter().importPackages("gal.udc.fic.vvs.email.archivo");

        ArchRule rule = methods().that().haveFullName("eliminar").should().haveRawReturnType(void.class);
    }
    @Test
    public void archUnitCorreoobtenerHijoDevuelveCorreo(){
        JavaClasses clase = new ClassFileImporter().importPackages("gal.udc.fic.vvs.email.archivo");

        ArchRule rule = methods().that().haveFullName("obtenerHijo").should().haveRawReturnType(Correo.class);
    }
    @Test
    public void archUnitCorreoobtenerPadreDevuelveCorreo(){
        JavaClasses clase = new ClassFileImporter().importPackages("gal.udc.fic.vvs.email.archivo");

        ArchRule rule = methods().that().haveFullName("obtenerPadre").should().haveRawReturnType(Correo.class);
    }

}
