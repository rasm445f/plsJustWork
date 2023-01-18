package facades;


import dtos.BoatDto;
import dtos.HarborDto;
import entities.*;
import entities.Harbor;

import javax.persistence.*;

import errorhandling.API_Exception;
import javassist.NotFoundException;
import security.errorhandling.AuthenticationException;

import java.util.List;

/**
 * @author lam@cphbusiness.dk
 */
public class HarborFacade {
    private static EntityManagerFactory emf;
    private static HarborFacade instance;

    private HarborFacade() {
    }

    public static HarborFacade getHarborFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new HarborFacade();
        }
        return instance;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public Harbor createHarbor(Harbor harbor) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(harbor);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return harbor;
    }

//    public Harbor createOwner(Owner owner, Harbor harbor) {
//        EntityManager em = getEntityManager();
//
//        if(harbor==null){
//            Harbor defaultHarbor = new Harbor();
//            owner.addRole(defaultRole);
//        }
//        else{
//            owner.addRole(role);
//        }
//        try {
//            em.getTransaction().begin();
//            em.persist(owner);
//            em.getTransaction().commit();
//        } finally {
//            em.close();
//        }
//        return owner;
//    }


    public List<HarborDto> getAllHarbors() throws NotFoundException {
        EntityManager em = getEntityManager();
        try {
            TypedQuery<Harbor> query = em.createQuery("SELECT u FROM Harbor u", Harbor.class);
            if (query == null) {
                throw new NotFoundException("Can't find any harbors");
            }
            List<Harbor> harbors = query.getResultList();
            return HarborDto.getHarborDtos(harbors);
        } finally {
            em.close();
        }
    }

    public HarborDto getHarborById(int id) throws API_Exception {
        EntityManager em = getEntityManager();

        Harbor harbor = em.find(Harbor.class, id);
        if (harbor == null)
            throw new API_Exception("There's no harbor with that id", 404);
        em.close();
        return new HarborDto(harbor);


    }


    //todo: make done later
    public Boat getBoatsByHarbour(int id) throws AuthenticationException {
        EntityManager em = emf.createEntityManager();
        Boat boat;
        try {
            TypedQuery<Boat> query = em.createQuery("select u from Boat u where u.harborID= :id", Boat.class);
            query.setParameter("id", id);
            boat = query.getSingleResult();
        } catch (NoResultException e) {
            throw new AuthenticationException("Invalid harbour id");
        } finally {
            em.close();
        }
        return boat;
    }


    public HarborDto deleteHarbor(int id) throws API_Exception {
        EntityManager em = getEntityManager();
        Harbor harbor;
        try {
            harbor = em.find(Harbor.class, id);
            if (harbor == null) {
                throw new API_Exception("Can't find a harbor with the harborname: " + id);
            }
            em.getTransaction().begin();
            em.remove(harbor);
            em.getTransaction().commit();
            return new HarborDto(harbor);
        } finally {
            em.close();
        }
    }


    public HarborDto updateHarbor(int id, Harbor harborUpdate) {
        EntityManager em = getEntityManager();
        Harbor harbor;
        try {
            harbor = em.find(Harbor.class, id);
            em.getTransaction().begin();
            harbor.setName(harborUpdate.getName());
            harbor.setAdress(harborUpdate.getAdress());
            harbor.setCapasity(harborUpdate.getCapasity());
            em.getTransaction().commit();
            return new HarborDto(harbor);
        } finally {
            em.close();
        }

    }

//    public OwnerDto addOwner(Boat boat) throws API_Exception {
//        EntityManager em = getEntityManager();
//        try {
//            em.getTransaction().begin();
//            em.persist(boat);
//            em.getTransaction().commit();
//        } finally {
//            em.close();
//        }
//        BoatDto theFan = new BoatDto(boat);
//        return theFan;
//    }
//    public List<BoatDto> getAllBoatsFromID(int id){
//        EntityManager em = getEntityManager();
//        try {
//            TypedQuery<Boat> query = em.createQuery("SELECT f FROM Boat f WHERE f.userid = ?1", Boat.class)
//                    .setParameter(1,id);
//            List<Boat> favoritesList = query.getResultList();
//            return BoatDto.getFavoriteDTOs(favoritesList);
//        } finally {
//            em.close();
//        }
//    }


}


