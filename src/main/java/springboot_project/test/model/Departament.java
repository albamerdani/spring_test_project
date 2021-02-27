package springboot_project.test.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "departament")
public class Departament {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_departament")
    private Integer idDepartament;

    private String nameDepartament;

    private String description;

    //@OneToMany(mappedBy = "departament")
    //private List<Punonjes> punonjesList;


    public Departament(Integer idDepartament, String nameDepartament, String description) {
        this.idDepartament = idDepartament;
        this.nameDepartament = nameDepartament;
        this.description = description;
    }

    public Integer getIdDepartament() {
        return idDepartament;
    }

    public void setIdDepartament(Integer idDepartament) {
        this.idDepartament = idDepartament;
    }

    public String getNameDepartament() {
        return nameDepartament;
    }

    public void setNameDepartament(String nameDepartament) {
        this.nameDepartament = nameDepartament;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
