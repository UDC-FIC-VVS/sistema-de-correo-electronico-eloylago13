package generadorPBT;

import com.pholser.junit.quickcheck.generator.GenerationStatus;
import com.pholser.junit.quickcheck.generator.Generator;
import com.pholser.junit.quickcheck.random.SourceOfRandomness;
import gal.udc.fic.vvs.email.archivo.Texto;
import gal.udc.fic.vvs.email.correo.Carpeta;
import gal.udc.fic.vvs.email.correo.Mensaje;

public class GeneradorCarpetaPBT extends Generator<Carpeta> {

    public GeneradorCarpetaPBT() {
        super(Carpeta.class);
    }

    @Override
    public Carpeta generate(SourceOfRandomness aleatorio, GenerationStatus status) {
        return new Carpeta(aleatorio.toString());
    }
}