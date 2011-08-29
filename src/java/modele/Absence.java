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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author flore
 */
@Entity
@Table(name = "absence", catalog = "gestion_dgi", schema = "public")
@NamedQueries({
    @NamedQuery(name = "Absence.findAll", query = "SELECT a FROM Absence a"),
    @NamedQuery(name = "Absence.findById", query = "SELECT a FROM Absence a WHERE a.id = :id"),
    @NamedQuery(name = "Absence.findByDate", query = "SELECT a FROM Absence a WHERE a.date = :date"),
    @NamedQuery(name = "Absence.findByHeureDebut", query = "SELECT a FROM Absence a WHERE a.heureDebut = :heureDebut"),
    @NamedQuery(name = "Absence.findByHeureFin", query = "SELECT a FROM Absence a WHERE a.heureFin = :heureFin"),
    @NamedQuery(name = "Absence.findByJustifie", query = "SELECT a FROM Absence a WHERE a.justifie = :justifie")})
public class Absence implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Column(name = "heureDebut")
    @Temporal(TemporalType.TIME)
    private Date heureDebut;
    @Column(name = "heureFin")
    @Temporal(TemporalType.TIME)
    private Date heureFin;
    @Column(name = "justifie")
    private Boolean justifie;
    @JoinColumn(name = "eleve_id", referencedColumnName = "id")
    @ManyToOne
    private Eleve eleve;
    @OneToMany(mappedBy = "absence")
    private Set<JustificationAbsence> justificationAbsenceSet;

    public Absence() {
    }

    public Absence(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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

    public Boolean getJustifie() {
        return justifie;
    }

    public void setJustifie(Boolean justifie) {
        this.justifie = justifie;
    }

    public Eleve getEleve() {
        return eleve;
    }

    public void setEleve(Eleve eleve) {
        this.eleve = eleve;
    }

    public Set<JustificationAbsence> getJustificationAbsenceSet() {
        return justificationAbsenceSet;
    }

    public void setJustificationAbsenceSet(Set<JustificationAbsence> justificationAbsenceSet) {
        this.justificationAbsenceSet = justificationAbsenceSet;
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
        if (!(object instanceof Absence)) {
            return false;
        }
        Absence other = (Absence) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modele.Absence[id=" + id + "]";
    }

}
