
package Principal;

import Data.ComentariosData;
import Data.EquipoData;
import Data.EquipoMiembrosData;
import Data.MiembroData;
import Data.ProyectoData;
import Data.TareaData;
import Entidad.Comentarios;
import Entidad.Equipo;
import Entidad.EquipoMiembros;
import Entidad.Miembro;
import Entidad.Proyecto;
import Entidad.Tarea;
import java.time.LocalDate;
import java.time.Month;

/**
 *
 * @author Gabriel
 */
public class Principal {

    
    public static void main(String[] args) {
     //   Miembro ale=new Miembro(29833093,"Uriel","Serrano",true);
        MiembroData mD = new MiembroData();
        
        
        Proyecto p1 = new Proyecto("Trabajo 1","Organizar material ",LocalDate.of(1988, 7, 1),1);
//        Equipo e1 = new Equipo(p1,"Boca",LocalDate.of(1982, 3, 4),true);
//        EquipoMiembros eq1 = new EquipoMiembros(e1,ale,LocalDate.of(1991, 4, 4));
//        Tarea t1 = new Tarea(eq1,"Ordenar clavos",LocalDate.of(1995,5,6),LocalDate.of(1995, 11, 1),1);
//        Comentarios c1 = new Comentarios(t1,"Hay 70 clavos",LocalDate.of(1995, 6, 1));
        
        TareaData td = new TareaData();
        EquipoData ed = new EquipoData();
        EquipoMiembrosData emd = new EquipoMiembrosData();
        ProyectoData pd = new ProyectoData();
        ComentariosData cd = new ComentariosData();
        
      //  mD.guardarMiembro(ale);
        mD.borrarMiembro(15);
//        pd.guardarProyecto(p1);
//        ed.guardarEquipo(e1);
//        emd.guardarEquipoMiembro(eq1);
//        td.guardarTarea(t1);
//        cd.guardarComentarios(c1);
        
        
    }
    
}
