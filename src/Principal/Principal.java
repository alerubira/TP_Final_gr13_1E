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
import java.util.List;

/**
 *
 * @author Gabriel
 */
public class Principal {

    public static void main(String[] args) {
        /*
        Miembro ale=new Miembro(29833093,"Uriel","Serrano",true);
        MiembroData md = new MiembroData();
          Miembro a = new Miembro(44753252,"Paco", "Perez",true);
          Miembro a1 = new Miembro(2953745,"Dario", "Benedetto",true);
          Miembro a2 = new Miembro(40752652,"Esequiel", "Barco",true);
          md.guardarMiembro(a);
          md.guardarMiembro(a1);
          md.guardarMiembro(a2);
////        
////        
        Proyecto p1 = new Proyecto("Trabajo 1","Organizar material ",LocalDate.of(1988, 7, 1),1);
        Equipo e1 = new Equipo(p1,"Boca",LocalDate.of(1982, 3, 4),true);
          
    //    Comentarios c1 = new Comentarios(t1,"Hay 70 clavos",LocalDate.of(1995, 6, 1));
        
          TareaData td = new TareaData();

          EquipoMiembrosData emd = new EquipoMiembrosData();
        ProyectoData pd = new ProyectoData();

          EquipoData ed = new EquipoData();
//        EquipoMiembrosData emd = new EquipoMiembrosData();
//        ProyectoData pd = new ProyectoData();

        ComentariosData cd = new ComentariosData();
//        
        md.guardarMiembro(ale);
        md.borrarMiembro(15);
        pd.guardarProyecto(p1);
        ed.guardarEquipo(e1);
//        emd.guardarEquipoMiembro(eq1);
//        td.guardarTarea(t1);
      //  cd.guardarComentarios(c1);

        List<Comentarios> comentario = cd.obtenerComentarioPorTarea(12);

        for (Comentarios comentarios : comentario) {
                System.out.println(comentarios);
        }
        Miembro miembro = md.buscarMiembroPorId(3);
        Equipo equipo = ed.buscarEquipoPorId(1);

//       EquipoMiembros a = new EquipoMiembros(equipo, miembro, LocalDate.now());
//        emd.guardarEquipoMiembro(a);

          EquipoMiembros eq1 = emd.buscarEquipoMiembroPorId(1);
          EquipoMiembros eq2 = emd.buscarEquipoMiembroPorId(3);
          EquipoMiembros eq3 = emd.buscarEquipoMiembroPorId(4);
          Tarea t1 = new Tarea(eq1,"Ordenar Tuercas",LocalDate.of(1995,5,6),LocalDate.of(1995, 11, 1),1);
          Tarea t2 = new Tarea(eq2,"Ordenar tornillos",LocalDate.of(1995,5,6),LocalDate.of(1995, 11, 1),1);
          Tarea t3 = new Tarea(eq3,"Ordenar alamierda",LocalDate.of(1995,5,6),LocalDate.of(1995, 11, 1),1);
          
          td.guardarTarea(t1);
          td.guardarTarea(t2);
          td.guardarTarea(t3);

//            System.out.println(emd.buscarTareaPorMiembro(1));
//            System.out.println(emd.buscarTareaPorMiembro(2));
//            System.out.println(emd.buscarTareaPorMiembro(3));
//            System.out.println(emd.buscarTareaPorMiembro(4));

            List<Equipo>  m = ed.traerTodos();
            for (Equipo tarea : m) {
                System.out.println(tarea);
                
        }
         */
    }
}
