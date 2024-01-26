package code.listados;

import Singleton.EmfSingleton;
import entities.EntityEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.util.ArrayList;

public class ListarEntity {

        static EntityManager em = EmfSingleton.getInstance().getEmf().createEntityManager();

        public static void listarEntity() {

            System.out.println("\n-*-*-[ LISTADO DE CENTROS ]-*-*-");

            // Consulta para obtener los centros.
            Query listadoCentros = em.createQuery("from EntityEntity");
            ArrayList<EntityEntity> listaCentros = (ArrayList<EntityEntity>) listadoCentros.getResultList();

            for (EntityEntity c : listaCentros) {

                // MOSTRAR LOS DATOS EN PANTALLA ----------
                System.out.println("\n*******[ CENTRO " + c.getEntityName() + " ]*******");
                System.out.println("- ID DEL CENTRO: " + c.getId());
                System.out.println("- CÓDIGO DEL CENTRO: " + c.getEntityCode());
                System.out.println("- WEB: " + c.getWeb());
                System.out.println("- EMAIL: " + c.getEmail());
                System.out.println("***********************************************************");

            }

            em.close();
        }
    }
