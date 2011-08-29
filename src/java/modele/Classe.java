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

/**
 *
 * @author flore
 */
@Entity
@Table(name = "classe", catalog = "gestion_dgi", schema = "public")
@NamedQueries({
    @NamedQuery(name = "Classe.findAll", query = "SELECT c FROM Classe c"),
    @NamedQuery(name = "Classe.findById", query = "SELECT c FROM Classe c WHERE c.id = :id"),
    @NamedQuery(name = "Classe.findByNiveau", query = "SELECT c FROM Classe c WHERE c.niveau = :niveau"),
    @NamedQuery(name = "Classe.findByAnnee", query = "SELECT c FROM Classe c WHERE c.annee = :annee")})
public class Classe implements Serializable {
    private static final long serialVersionUID = 1L;
    private static EntityManager em = Persistence.createEntityManagerFactory("gestionPedagogiqueDGIPU2").createEntityManager();
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "niveau")
    private Integer niveau;
    @Column(name = "annee")
    private Integer annee;
    @JoinColumn(name = "cycle_id", referencedColumnName = "id")
    @ManyToOne
    private Cycle cycle;
    @OneToMany(mappedBy = "classe")
    private Set<Cours> coursSet;
    @OneToMany(mappedBy = "classe")
    private Set<EntreeCahierTexte> entreeCahierTexteSet;
    @OneToMany(mappedBy = "classe")
    private Set<ClasseEleve> classeEleveSet;

    public Classe() {
    }

    public Classe(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNiveau() {
        return niveau;
    }

    public void setNiveau(Integer niveau) {
        this.niveau = niveau;
    }

    public Integer getAnnee() {
        return annee;
    }

    public void setAnnee(Integer annee) {
        this.annee = annee;
    }

    public Cycle getCycle() {
        return cycle;
    }

    public void setCycle(Cycle cycle) {
        this.cycle = cycle;
    }

    public Set<Cours> getCoursSet() {
        return coursSet;
    }

    public void setCoursSet(Set<Cours> coursSet) {
        this.coursSet = coursSet;
    }

    public Set<EntreeCahierTexte> getEntreeCahierTexteSet() {
        return entreeCahierTexteSet;
    }

    public void setEntreeCahierTexteSet(Set<EntreeCahierTexte> entreeCahierTexteSet) {
        this.entreeCahierTexteSet = entreeCahierTexteSet;
    }

    public Set<ClasseEleve> getClasseEleveSet() {
        return classeEleveSet;
    }

    public void setClasseEleveSet(Set<ClasseEleve> classeEleveSet) {
        this.classeEleveSet = classeEleveSet;
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
        if (!(object instanceof Classe)) {
            return false;
        }
        Classe other = (Classe) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modele.Classe[id=" + id + "]";
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
        Classe prof = em.find(Classe.class, id);
        em.remove(prof);
        et.commit();
    }

    public static void delete(String id) {
        delete(Integer.parseInt(id));
    }

    public static Classe get(int id) {
        return em.find(Classe.class, id);
    }

    public static Classe get(String id) {
        return em.find(Classe.class, Integer.parseInt(id));
    }

    public static Classe[] getAll() {
        javax.persistence.Query q = em.createNamedQuery("Classe.findAll");
        return (Classe[]) q.getResultList().toArray(new Classe[0]);
    }

}
