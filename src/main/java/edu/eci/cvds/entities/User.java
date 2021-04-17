package edu.eci.cvds.entities;

import java.io.Serializable;

public class User implements Serializable{
    private int id;
    private String fullName;
    private String username;
    private String passwd;
    private int rol;
    private boolean isactive;
    private String correo;

    /**
     * Constructos de users el cual hace super a la interfaz Serializable
     */
    public User() {
        super();
    }

    /**
     * Constructor de users el cual genera un nuevo user
     * @param fullname nombre completo del usuario que se va a registrar
     * @param username username del usuario que se va a registrar
     * @param passwd contraseña del usuario que se va a registrar
     * @param rol rol que posee el usuario que se va a registrar
     * @param isactive estado del usuario
     * @param correo correo del usuario que se va a registrar
     */
    public User( String fullname, String username, String passwd, int rol, boolean isactive, String correo) {
        this.fullName = fullname;
        this.username = username;
        this.passwd = passwd;
        this.rol = rol;
        this.isactive = isactive;
        this.correo = correo;
    }

    /**
     * Obtiene el Id del user
     * @return int
     */
    public int getId() {
        return id;
    }

    /**
     * Cambia el id del user
     * @param id nuevo id del user
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtiene el fullName del user
     * @return String
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * Cambia el fullName del user
     * @param fullName nuevo fullName del user
     */
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    /**
     * Obtiene el username del user
     * @return String
     */
    public String getUsername() {
        return username;
    }

    /**
     * Cambia el username del user
     * @param username nuevo username del user
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Obtiene el passwd del user
     * @return String
     */
    public String getPasswd() {
        return passwd;
    }

    /**
     * Cambia el passwd del user
     * @param passwd nuevo passwd del user
     */
    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    /**
     * Obtiene el rol del user
     * @return Rol
     */
    public int getRol() {
        return rol;
    }

    /**
     * Cambia el rol del user
     * @param rol nuevo rol del user
     */
    public void setRol(int rol) {
        this.rol = rol;
    }

    /**
     * Obtiene el isIsactive del user
     * @return boolean
     */
    public boolean isIsactive() {
        return isactive;
    }

    /**
     * Cambia el isactive del user
     * @param isactive nuevo rol del user
     */
    public void setIsactive(boolean isactive) {
        this.isactive = isactive;
    }

    /**
     * Obtiene el correo del user
     * @return String
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * Convierte a cadena todos los datos de un user y la retorna
     * @return String
     */
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", username='" + username + '\'' +
                ", passwd='" + passwd + '\'' +
                ", rol=" + rol +
                ", isactive=" + isactive +
                ", correo='" + correo + '\'' +
                '}';
    }

    /**
     * Cambia el correo del user
     * @param correo nuevo correo del user
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }
}
