/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package modele;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Persistence;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author flore
 */
@Entity
@Table(name = "cycle", catalog = "gestion_dgi", schema = "public", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"cygle"})})
@NamedQueries({
    @NamedQuery(name = "Cycle.findAll", query = "SELECT c FROM Cycle c"),
    @NamedQuery(name = "Cycle.findById", query = "SELECT c FROM Cycle c WHERE c.id = :id"),
    @NamedQuery(name = "Cycle.findByCygle", query = "SELECT c FROM Cycle c WHERE c.cygle = :cygle"),
    @NamedQuery(name = "Cycle.findByLibelle", query = "SELECT c FROM Cycle c WHERE c.libelle = :libelle")})

public class Cycle implements Serializable {
    private static final long serialVersionUID = 1L;
    private static EntityManager em = Persistence.createEntityManagerFactory("gestionPedagogiqueDGIPU2").createEntityManager();
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "cygle", length = 10)
    private String cygle;
    @Column(name = "libelle", length = 255)
    private String libelle;
    @JoinColumn(name = "responsablepedagogique_id", referencedColumnName = "id")
    @ManyToOne
    private Professeur professeur;
    @OneToMany(mappedBy = "cycle")
    private Set<Classe> classeSet;

    public Cycle() {
    }

    public Cycle(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCygle() {
        return cygle;
    }

    public void setCygle(String cygle) {
        this.cygle = cygle;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public Professeur getProfesseur() {
        return professeur;
    }

    public void setProfesseur(Professeur professeur) {
        this.professeur = professeur;
    }

    public Set<Classe> getClasseSet() {
        return classeSet;
    }

    public void setClasseSet(Set<Classe> classeSet) {
        this.classeSet = classeSet;
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
        if (!(object instanceof Cycle)) {
            return false;
        }
        Cycle other = (Cycle) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modele.Cycle[id=" + id + "]";
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
        Cycle prof = em.find(Cycle.class, id);
        em.remove(prof);
        et.commit();
    }

    public static void delete(String id) {
        delete(Integer.parseInt(id));
    }

    public static Cycle get(int id) {
        return em.find(Cycle.class, id);
    }

    public static Cycle get(String id) {
        return em.find(Cycle.class, Integer.parseInt(id));
    }

    public static Cycle[] getAll() {
        javax.persistence.Query q = em.createNamedQuery("Cycle.findAll");
        return (Cycle[]) q.getResultList().toArray(new Cycle[0]);
    }
}
