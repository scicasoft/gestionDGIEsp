/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package modele;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author flore
 */
@Entity
@Table(name = "eleve", catalog = "gestion_dgi", schema = "public", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"nce"}),
    @UniqueConstraint(columnNames = {"login"})})
@NamedQueries({
    @NamedQuery(name = "Eleve.findAll", query = "SELECT e FROM Eleve e"),
    @NamedQuery(name = "Eleve.findById", query = "SELECT e FROM Eleve e WHERE e.id = :id"),
    @NamedQuery(name = "Eleve.findByNce", query = "SELECT e FROM Eleve e WHERE e.nce = :nce"),
    @NamedQuery(name = "Eleve.findByPrenom", query = "SELECT e FROM Eleve e WHERE e.prenom = :prenom"),
    @NamedQuery(name = "Eleve.findByNom", query = "SELECT e FROM Eleve e WHERE e.nom = :nom"),
    @NamedQuery(name = "Eleve.findByDatenaissance", query = "SELECT e FROM Eleve e WHERE e.datenaissance = :datenaissance"),
    @NamedQuery(name = "Eleve.findByLogin", query = "SELECT e FROM Eleve e WHERE e.login = :login"),
    @NamedQuery(name = "Eleve.findByPassword", query = "SELECT e FROM Eleve e WHERE e.password = :password")})
public class Eleve implements Serializable {
    private static final long serialVersionUID = 1L;
      private static EntityManager em = Persistence.createEntityManagerFactory("gestionPedagogiqueDGIPU2").createEntityManager();
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "nce", length = 255)
    private String nce;
    @Column(name = "prenom", length = 255)
    private String prenom;
    @Column(name = "nom", length = 255)
    private String nom;
    @Column(name = "datenaissance")
    @Temporal(TemporalType.DATE)
    private Date datenaissance;
    @Column(name = "login", length = 255)
    private String login;
    @Column(name = "password", length = 255)
    private String password;
    @OneToMany(mappedBy = "eleve")
    private Set<Absence> absenceSet;
    @OneToMany(mappedBy = "eleve")
    private Set<ClasseEleve> classeEleveSet;
    @OneToMany(mappedBy = "eleve")
    private Set<Note> noteSet;

    public Eleve() {
    }

    public Eleve(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNce() {
        return nce;
    }

    public void setNce(String nce) {
        this.nce = nce;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Date getDatenaissance() {
        return datenaissance;
    }

    public void setDatenaissance(Date datenaissance) {
        this.datenaissance = datenaissance;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Absence> getAbsenceSet() {
        return absenceSet;
    }

    public void setAbsenceSet(Set<Absence> absenceSet) {
        this.absenceSet = absenceSet;
    }

    public Set<ClasseEleve> getClasseEleveSet() {
        return classeEleveSet;
    }

    public void setClasseEleveSet(Set<ClasseEleve> classeEleveSet) {
        this.classeEleveSet = classeEleveSet;
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
        if (!(object instanceof Eleve)) {
            return false;
        }
        Eleve other = (Eleve) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modele.Eleve[id=" + id + "]";
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
        Eleve elev = em.find(Eleve.class, id);
        em.remove(elev);
        et.commit();
    }

    public static void delete(String id) {
        delete(Integer.parseInt(id));
    }

    public static Eleve get(int id) {
        return em.find(Eleve.class, id);
    }

    public static Eleve get(String id) {
        return em.find(Eleve.class, Integer.parseInt(id));
    }

    public static Classe[] getAll() {
        javax.persistence.Query q = em.createNamedQuery("Classe.findAll");
        return (Classe[]) q.getResultList().toArray(new Classe[0]);
    }


}
