/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package modele;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Persistence;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author flore
 */
@Entity
@Table(name = "cours", catalog = "gestion_dgi", schema = "public")
@NamedQueries({
    @NamedQuery(name = "Cours.findAll", query = "SELECT c FROM Cours c"),
    @NamedQuery(name = "Cours.findById", query = "SELECT c FROM Cours c WHERE c.id = :id"),
    @NamedQuery(name = "Cours.findByJour", query = "SELECT c FROM Cours c WHERE c.jour = :jour"),
    @NamedQuery(name = "Cours.findByHeureDebut", query = "SELECT c FROM Cours c WHERE c.heureDebut = :heureDebut"),
    @NamedQuery(name = "Cours.findByHeureFin", query = "SELECT c FROM Cours c WHERE c.heureFin = :heureFin"),
    @NamedQuery(name = "Cours.findByDateDebut", query = "SELECT c FROM Cours c WHERE c.dateDebut = :dateDebut"),
    @NamedQuery(name = "Cours.findByDateFin", query = "SELECT c FROM Cours c WHERE c.dateFin = :dateFin")})
public class Cours implements Serializable {
    private static final long serialVersionUID = 1L;
    private static EntityManager em = Persistence.createEntityManagerFactory("gestionPedagogiqueDGIPU2").createEntityManager();
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "jour", length = 15)
    private String jour;
    @Column(name = "heure_debut")
    @Temporal(TemporalType.TIME)
    private Date heureDebut;
    @Column(name = "heure_fin")
    @Temporal(TemporalType.TIME)
    private Date heureFin;
    @Column(name = "date_debut")
    @Temporal(TemporalType.DATE)
    private Date dateDebut;
    @Column(name = "date_fin")
    @Temporal(TemporalType.DATE)
    private Date dateFin;
    @JoinColumn(name = "professeur_id", referencedColumnName = "id")
    @ManyToOne
    private Professeur professeur;
    @JoinColumn(name = "matiere_id", referencedColumnName = "id")
    @ManyToOne
    private Matiere matiere;
    @JoinColumn(name = "classe_id", referencedColumnName = "id")
    @ManyToOne
    private Classe classe;

    public Cours() {
    }

    public Cours(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getJour() {
        return jour;
    }

    public void setJour(String jour) {
        this.jour = jour;
    }

    public Date getHeureDebut() {
        return heureDebut;
    }

    public void setHeureDebut(Date heureDebut) {
        this.heureDebut = heureDebut;
    }

    public Date getHeureFin() {
        return heureFin;
    }

    public void setHeureFin(Date heureFin) {
        this.heureFin = heureFin;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public Professeur getProfesseur() {
        return professeur;
    }

    public void setProfesseur(Professeur professeur) {
        this.professeur = professeur;
    }

    public Matiere getMatiere() {
        return matiere;
    }

    public void setMatiere(Matiere matiere) {
        this.matiere = matiere;
    }

    public Classe getClasse() {
        return classe;
    }

    public void setClasse(Classe classe) {
        this.classe = classe;
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
        if (!(object instanceof Cours)) {
            return false;
        }
        Cours other = (Cours) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modele.Cours[id=" + id + "]";
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
        Cours cour = em.find(Cours.class, id);
        em.remove(cour);
        et.commit();
    }

    public static void delete(String id) {
        delete(Integer.parseInt(id));
    }

    public static Cours get(int id) {
        return em.find(Cours.class, id);
    }

    public static Cours get(String id) {
        return em.find(Cours.class, Integer.parseInt(id));
    }

    public static Cours[] getAll() {
        javax.persistence.Query q = em.createNamedQuery("Cours.findAll");
        return (Cours[]) q.getResultList().toArray(new Cours[0]);
    }

}