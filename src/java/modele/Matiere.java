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
@Table(name = "matiere", catalog = "gestion_dgi", schema = "public")
@NamedQueries({
    @NamedQuery(name = "Matiere.findAll", query = "SELECT m FROM Matiere m"),
    @NamedQuery(name = "Matiere.findById", query = "SELECT m FROM Matiere m WHERE m.id = :id"),
    @NamedQuery(name = "Matiere.findByLibelle", query = "SELECT m FROM Matiere m WHERE m.libelle = :libelle"),
    @NamedQuery(name = "Matiere.findByCoef", query = "SELECT m FROM Matiere m WHERE m.coef = :coef")})
public class Matiere implements Serializable {

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
    @JoinColumn(name = "groupe_matiere_id", referencedColumnName = "id")
    @ManyToOne
    private GroupeMatiere groupeMatiere;
    @OneToMany(mappedBy = "matiere")
    private Set<Cours> coursSet;
    @OneToMany(mappedBy = "matiere")
    private Set<Note> noteSet;

    public Matiere() {
    }

    public Matiere(Integer id) {
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

    public GroupeMatiere getGroupeMatiere() {
        return groupeMatiere;
    }

    public void setGroupeMatiere(GroupeMatiere groupeMatiere) {
        this.groupeMatiere = groupeMatiere;
    }

    public Set<Cours> getCoursSet() {
        return coursSet;
    }

    public void setCoursSet(Set<Cours> coursSet) {
        this.coursSet = coursSet;
    }

    public Set<Note> getNoteSet() {
        return noteSet;
    }

    public void setNoteSet(Set<Note> noteSet) {
        this.noteSet = noteSet;
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
        if (!(object instanceof Matiere)) {
            return false;
        }
        Matiere other = (Matiere) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modele.Matiere[id=" + id + "]";
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
        Matiere matiere = em.find(Matiere.class, id);
        em.remove(matiere);
        et.commit();
    }

    public static void delete(String id) {
        delete(Integer.parseInt(id));
    }

    public static Matiere get(int id) {
        return em.find(Matiere.class, id);
    }

    public static Matiere get(String id) {
        return em.find(Matiere.class, Integer.parseInt(id));
    }

    public static Matiere[] getAll() {
        javax.persistence.Query q = em.createNamedQuery("Matiere.findAll");
        return (Matiere[]) q.getResultList().toArray(new Matiere[0]);
    }
}
