package springboot_project.test.model;

import com.fasterxml.jackson.annotation.JsonTypeId;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;

@Entity
@Table(name = "punonjes")
public class Punonjes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_punonjes")
    private Integer idPunonjes;

    private String name;

    private String gender;

    private String email;

    private String address;

    @ManyToOne
    @JoinColumn(name="id_departament")
    private Departament departament;

    public Punonjes(Integer idPunonjes, String name, String gender, String email, String address, Departament departament) {
        this.idPunonjes = idPunonjes;
        this.name = name;
        this.gender = gender;
        this.email = email;
        this.address = address;
        this.departament = departament;
    }

    public Integer getIdPunonjes() {
        return idPunonjes;
    }

    public void setIdPunonjes(Integer idPunonjes) {
        this.idPunonjes = idPunonjes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Departament getDepartament() {
        return departament;
    }

    public void setDepartament(Departament departament) {
        this.departament = departament;
    }
}
