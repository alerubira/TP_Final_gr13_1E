
package Principal;

import Data.MiembroData;
import Entidad.Miembro;

/**
 *
 * @author Gabriel
 */
public class Principal {

    
    public static void main(String[] args) {
        Miembro ale=new Miembro(26833093,"Alejandro","Apellido",true);
        MiembroData mD = new MiembroData();
        mD.guardarMiembro(ale);
    }
    
}
