package springboot_project.test.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "departament")
public class Departament {

    @Id
    @GeneratedValue
    @Column(name = "idDepartament")
    private String idDepartament;

    private String nameDepartament;

    private String description;

    //@OneToMany(mappedBy = "departament")
    //private List<Punonjes> punonjesList;

    public String getIdDepartament() {
        return idDepartament;
    }

    public void setIdDepartament(String idDepartament) {
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
