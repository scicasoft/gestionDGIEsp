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
@Table(name = "professeur", catalog = "gestion_dgi", schema = "public", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"login"}),
    @UniqueConstraint(columnNames = {"matricule"})})
@NamedQueries({
    @NamedQuery(name = "Professeur.findAll", query = "SELECT p FROM Professeur p"),
    @NamedQuery(name = "Professeur.findById", query = "SELECT p FROM Professeur p WHERE p.id = :id"),
    @NamedQuery(name = "Professeur.findByMatricule", query = "SELECT p FROM Professeur p WHERE p.matricule = :matricule"),
    @NamedQuery(name = "Professeur.findByPrenom", query = "SELECT p FROM Professeur p WHERE p.prenom = :prenom"),
    @NamedQuery(name = "Professeur.findByNom", query = "SELECT p FROM Professeur p WHERE p.nom = :nom"),
    @NamedQuery(name = "Professeur.findByDatenaissance", query = "SELECT p FROM Professeur p WHERE p.datenaissance = :datenaissance"),
    @NamedQuery(name = "Professeur.findByLogin", query = "SELECT p FROM Professeur p WHERE p.login = :login"),
    @NamedQuery(name = "Professeur.findByPassword", query = "SELECT p FROM Professeur p WHERE p.password = :password")})
public class Professeur implements Serializable {

    private static final long serialVersionUID = 1L;
    private static EntityManager em = Persistence.createEntityManagerFactory("gestionPedagogiqueDGIPU2").createEntityManager();
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "matricule", length = 255)
    private String matricule;
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
    @OneToMany(mappedBy = "professeur")
    private Set<Cycle> cycleSet;
    @OneToMany(mappedBy = "professeur")
    private Set<Cours> coursSet;

    public Professeur() {
    }

    public Professeur(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
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

    public Set<Cycle> getCycleSet() {
        return cycleSet;
    }

    public void setCycleSet(Set<Cycle> cycleSet) {
        this.cycleSet = cycleSet;
    }

    public Set<Cours> getCoursSet() {
        return coursSet;
    }

    public void setCoursSet(Set<Cours> coursSet) {
        this.coursSet = coursSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Professeur)) {
            return false;
        }
        Professeur other = (Professeur) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modele.Professeur[id=" + id + "]";
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
        Professeur prof = em.find(Professeur.class, id);
        em.remove(prof);
        et.commit();
    }

    public static void delete(String id) {
        delete(Integer.parseInt(id));
    }

    public static Professeur get(int id) {
        return em.find(Professeur.class, id);
    }

    public static Professeur get(String id) {
        return em.find(Professeur.class, Integer.parseInt(id));
    }

    public static Professeur[] getAll() {
        javax.persistence.Query q = em.createNamedQuery("Professeur.findAll");
        return (Professeur[]) q.getResultList().toArray(new Professeur[0]);
    }
}
