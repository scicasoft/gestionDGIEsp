/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package modele;

import java.io.Serializable;
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

/**
 *
 * @author flore
 */
@Entity
@Table(name = "classe_eleve", catalog = "gestion_dgi", schema = "public")
@NamedQueries({
    @NamedQuery(name = "ClasseEleve.findAll", query = "SELECT c FROM ClasseEleve c"),
    @NamedQuery(name = "ClasseEleve.findById", query = "SELECT c FROM ClasseEleve c WHERE c.id = :id")})
public class ClasseEleve implements Serializable {
    private static final long serialVersionUID = 1L;
    private static EntityManager em = Persistence.createEntityManagerFactory("gestionPedagogiqueDGIPU2").createEntityManager();
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @JoinColumn(name = "eleve_id", referencedColumnName = "id")
    @ManyToOne
    private Eleve eleve;
    @JoinColumn(name = "classe_id", referencedColumnName = "id")
    @ManyToOne
    private Classe classe;

    public ClasseEleve() {
    }

    public ClasseEleve(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Eleve getEleve() {
        return eleve;
    }

    public void setEleve(Eleve eleve) {
        this.eleve = eleve;
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
        if (!(object instanceof ClasseEleve)) {
            return false;
        }
        ClasseEleve other = (ClasseEleve) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modele.ClasseEleve[id=" + id + "]";
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
        ClasseEleve classeeleve = em.find(ClasseEleve.class, id);
        em.remove(classeeleve);
        et.commit();
    }

    public static void delete(String id) {
        delete(Integer.parseInt(id));
    }

    public static ClasseEleve get(int id) {
        return em.find(ClasseEleve.class, id);
    }

    public static ClasseEleve get(String id) {
        return em.find(ClasseEleve.class, Integer.parseInt(id));
    }

    public static ClasseEleve[] getAll() {
        javax.persistence.Query q = em.createNamedQuery("ClasseEleve.findAll");
        return (ClasseEleve[]) q.getResultList().toArray(new Classe[0]);
    }
}
