/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package modele;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Persistence;
import javax.persistence.Table;

/**
 *
 * @author flore
 */
@Entity
@Table(name = "specialite", catalog = "gestion_dgi", schema = "public")
@NamedQueries({
    @NamedQuery(name = "Specialite.findAll", query = "SELECT s FROM Specialite s"),
    @NamedQuery(name = "Specialite.findById", query = "SELECT s FROM Specialite s WHERE s.id = :id"),
    @NamedQuery(name = "Specialite.findByLibelle", query = "SELECT s FROM Specialite s WHERE s.libelle = :libelle")})
public class Specialite implements Serializable {
    private static final long serialVersionUID = 1L;
    private static EntityManager em = Persistence.createEntityManagerFactory("gestionPedagogiqueDGIPU2").createEntityManager();
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "libelle", length = 255)
    private String libelle;

    public Specialite() {
    }

    public Specialite(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Specialite)) {
            return false;
        }
        Specialite other = (Specialite) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modele.Specialite[id=" + id + "]";
    }

    public void save() {
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(this);
        et.commit();
    }

    public static void delete(int id) {
        EntityTransaction et = em.getTransaction();
        et.begin();
        Specialite specialite = em.find(Specialite.class, id);
        em.remove(specialite);
        et.commit();
    }

    public static void delete(String id) {
        delete(Integer.parseInt(id));
    }

    public static Specialite get(int id) {
        return em.find(Specialite.class, id);
    }

    public static Specialite get(String id) {
        return em.find(Specialite.class, Integer.parseInt(id));
    }

    public static Specialite[] getAll() {
        javax.persistence.Query q = em.createNamedQuery("Specialite.findAll");
        return (Specialite[]) q.getResultList().toArray(new Specialite[0]);
    }
}
