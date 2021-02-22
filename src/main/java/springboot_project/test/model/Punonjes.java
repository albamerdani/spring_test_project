package springboot_project.test.model;

import org.springframework.beans.factory.annotation.Autowired;

public class Punonjes {

    private String idPunonjes;
    private String name;
    private String gender;
    private String email;
    private String address;

    @Autowired
    private Departament departament;

    public String getIdPunonjes() {
        return idPunonjes;
    }

    public void setIdPunonjes(String idPunonjes) {
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
/*
    public Departament getDepartament() {
        return departament;
    }

    public void setDepartament(Departament departament) {
        this.departament = departament;
    }*/
}
