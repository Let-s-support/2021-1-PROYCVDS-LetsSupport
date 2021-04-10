package edu.eci.cvds.entities;

public class User {
    private int id;
    private String fullName;
    private String username;
    private String passwd;
    private Rol rol;
    private boolean isActive;

    public User() {
    }

    public User(int id, String fullName, String username, String passwd, Rol rol, boolean isActive) {
        this.id = id;
        this.fullName = fullName;
        this.username = username;
        this.passwd = passwd;
        this.rol = rol;
        this.isActive = isActive;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return this.fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswd() {
        return this.passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public Rol getRol() {
        return this.rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public boolean isIsActive() {
        return this.isActive;
    }

    public boolean getIsActive() {
        return this.isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", fullName='" + getFullName() + "'" +
            ", username='" + getUsername() + "'" +
            ", passwd='" + getPasswd() + "'" +
            ", rol='" + getRol() + "'" +
            ", isActive='" + isIsActive() + "'" +
            "}";
    }

}