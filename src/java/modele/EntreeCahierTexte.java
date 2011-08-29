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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author flore
 */
@Entity
@Table(name = "entree_cahier_texte", catalog = "gestion_dgi", schema = "public")
@NamedQueries({
    @NamedQuery(name = "EntreeCahierTexte.findAll", query = "SELECT e FROM EntreeCahierTexte e"),
    @NamedQuery(name = "EntreeCahierTexte.findById", query = "SELECT e FROM EntreeCahierTexte e WHERE e.id = :id"),
    @NamedQuery(name = "EntreeCahierTexte.findByDate", query = "SELECT e FROM EntreeCahierTexte e WHERE e.date = :date"),
    @NamedQuery(name = "EntreeCahierTexte.findByHeureDebut", query = "SELECT e FROM EntreeCahierTexte e WHERE e.heureDebut = :heureDebut"),
    @NamedQuery(name = "EntreeCahierTexte.findByHeureFin", query = "SELECT e FROM EntreeCahierTexte e WHERE e.heureFin = :heureFin"),
    @NamedQuery(name = "EntreeCahierTexte.findByContenu", query = "SELECT e FROM EntreeCahierTexte e WHERE e.contenu = :contenu"),
    @NamedQuery(name = "EntreeCahierTexte.findByValide", query = "SELECT e FROM EntreeCahierTexte e WHERE e.valide = :valide")})
public class EntreeCahierTexte implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "date")
    private Integer date;
    @Column(name = "heureDebut")
    @Temporal(TemporalType.TIME)
    private Date heureDebut;
    @Column(name = "heureFin")
    @Temporal(TemporalType.TIME)
    private Date heureFin;
    @Column(name = "contenu", length = 2147483647)
    private String contenu;
    @Column(name = "valide")
    private Boolean valide;
    @JoinColumn(name = "classe_id", referencedColumnName = "id")
    @ManyToOne
    private Classe classe;

    public EntreeCahierTexte() {
    }

    public EntreeCahierTexte(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDate() {
        return date;
    }

    public void setDate(Integer date) {
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

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public Boolean getValide() {
        return valide;
    }

    public void setValide(Boolean valide) {
        this.valide = valide;
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
        if (!(object instanceof EntreeCahierTexte)) {
            return false;
        }
        EntreeCahierTexte other = (EntreeCahierTexte) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modele.EntreeCahierTexte[id=" + id + "]";
    }

}
