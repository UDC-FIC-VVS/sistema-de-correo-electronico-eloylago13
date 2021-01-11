package gal.udc.fic.vvs.email.generadorpbt;

import com.pholser.junit.quickcheck.generator.GenerationStatus;
import com.pholser.junit.quickcheck.generator.Generator;
import com.pholser.junit.quickcheck.generator.java.lang.StringGenerator;
import com.pholser.junit.quickcheck.random.SourceOfRandomness;
import com.sun.org.apache.xpath.internal.operations.String;
import gal.udc.fic.vvs.email.archivo.Texto;
import gal.udc.fic.vvs.email.correo.Mensaje;
import org.w3c.dom.Text;

public class GeneradorPBT {


    public class GeneradorMensajePBT extends Generator<Mensaje> {
        protected GeneradorMensajePBT() {
            super(Mensaje.class);
        }

        @Override
        public Mensaje generate(SourceOfRandomness aleatorio, GenerationStatus status) {
            return new Mensaje(new Texto(aleatorio.toString(), aleatorio.toString()));
        }
    }
    public class GeneradorTextoPBT extends Generator<Texto>{
        protected GeneradorTextoPBT() {
            super(Texto.class);
        }

        @Override
        public Texto generate(SourceOfRandomness aleatorio, GenerationStatus status) {
            return  new Texto(aleatorio.toString(), aleatorio.toString());
        }

    }



}
