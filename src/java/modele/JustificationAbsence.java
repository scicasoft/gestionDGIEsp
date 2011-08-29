/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package modele;

import java.io.Serializable;
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
import javax.persistence.Table;

/**
 *
 * @author flore
 */
@Entity
@Table(name = "justification_absence", catalog = "gestion_dgi", schema = "public")
@NamedQueries({
    @NamedQuery(name = "JustificationAbsence.findAll", query = "SELECT j FROM JustificationAbsence j"),
    @NamedQuery(name = "JustificationAbsence.findById", query = "SELECT j FROM JustificationAbsence j WHERE j.id = :id"),
    @NamedQuery(name = "JustificationAbsence.findByDescription", query = "SELECT j FROM JustificationAbsence j WHERE j.description = :description"),
    @NamedQuery(name = "JustificationAbsence.findByValide", query = "SELECT j FROM JustificationAbsence j WHERE j.valide = :valide"),
    @NamedQuery(name = "JustificationAbsence.findByConsulte", query = "SELECT j FROM JustificationAbsence j WHERE j.consulte = :consulte")})
public class JustificationAbsence implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "description", length = 255)
    private String description;
    @Column(name = "valide")
    private Boolean valide;
    @Column(name = "consulte")
    private Boolean consulte;
    @JoinColumn(name = "absence_id", referencedColumnName = "id")
    @ManyToOne
    private Absence absence;

    public JustificationAbsence() {
    }

    public JustificationAbsence(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getValide() {
        return valide;
    }

    public void setValide(Boolean valide) {
        this.valide = valide;
    }

    public Boolean getConsulte() {
        return consulte;
    }

    public void setConsulte(Boolean consulte) {
        this.consulte = consulte;
    }

    public Absence getAbsence() {
        return absence;
    }

    public void setAbsence(Absence absence) {
        this.absence = absence;
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
        if (!(object instanceof JustificationAbsence)) {
            return false;
        }
        JustificationAbsence other = (JustificationAbsence) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modele.JustificationAbsence[id=" + id + "]";
    }

}
