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
@Table(name = "groupe_matiere", catalog = "gestion_dgi", schema = "public", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"libelle"})})
@NamedQueries({
    @NamedQuery(name = "GroupeMatiere.findAll", query = "SELECT g FROM GroupeMatiere g"),
    @NamedQuery(name = "GroupeMatiere.findById", query = "SELECT g FROM GroupeMatiere g WHERE g.id = :id"),
    @NamedQuery(name = "GroupeMatiere.findByLibelle", query = "SELECT g FROM GroupeMatiere g WHERE g.libelle = :libelle"),
    @NamedQuery(name = "GroupeMatiere.findByCoef", query = "SELECT g FROM GroupeMatiere g WHERE g.coef = :coef")})
public class GroupeMatiere implements Serializable {
    private static final long serialVersionUID = 1L;
    private static EntityManager em = Persistence.createEntityManagerFactory("gestionPedagogiqueDGIPU2").createEntityManager();
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "libelle", length = 255)
    private String libelle;
    @Column(name = "coef", precision = 8, scale = 8)
    private Float coef;
    @OneToMany(mappedBy = "groupeMatiere")
    private Set<Matiere> matiereSet;

    public GroupeMatiere() {
    }

    public GroupeMatiere(Integer id) {
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

    public Float getCoef() {
        return coef;
    }

    public void setCoef(Float coef) {
        this.coef = coef;
    }

    public Set<Matiere> getMatiereSet() {
        return matiereSet;
    }

    public void setMatiereSet(Set<Matiere> matiereSet) {
        this.matiereSet = matiereSet;
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
        if (!(object instanceof GroupeMatiere)) {
            return false;
        }
        GroupeMatiere other = (GroupeMatiere) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modele.GroupeMatiere[id=" + id + "]";
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
        GroupeMatiere groupematiere = em.find(GroupeMatiere.class, id);
        em.remove(groupematiere);
        et.commit();
    }

    public static void delete(String id) {
        delete(Integer.parseInt(id));
    }

    public static GroupeMatiere get(int id) {
        return em.find(GroupeMatiere.class, id);
    }

    public static GroupeMatiere get(String id) {
        return em.find(GroupeMatiere.class, Integer.parseInt(id));
    }

    public static GroupeMatiere[] getAll() {
        javax.persistence.Query q = em.createNamedQuery("GroupeMatiere.findAll");
        return (GroupeMatiere[]) q.getResultList().toArray(new GroupeMatiere[0]);
    }

    public Matiere[] matieres() {
        javax.persistence.Query q = em.createNativeQuery("SELECT * FROM Matiere m WHERE m.groupe_matiere_id = "+this.getId(), Matiere.class);
        return (Matiere[]) q.getResultList().toArray(new Matiere[0]);
    }
}
