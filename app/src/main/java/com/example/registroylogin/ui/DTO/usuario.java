package com.example.registroylogin.ui.DTO;

public class usuario {

    private int ID;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String correo;
    private String contrasenia;
    private String contrasenia2;
    private String fechaNacimiento;
    private String status;
    private String codigoConfirmacion;
    private String tokenRecovery;
    private String create_at;
    private String update_at;
    private String estatus;
    private String mensaje;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getContrasenia2() {
        return contrasenia2;
    }

    public void setContrasenia2(String contrasenia2) {
        this.contrasenia2 = contrasenia2;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCodigoConfirmacion() {
        return codigoConfirmacion;
    }

    public void setCodigoConfirmacion(String codigoConfirmacion) {
        this.codigoConfirmacion = codigoConfirmacion;
    }

    public String getTokenRecovery() {
        return tokenRecovery;
    }

    public void setTokenRecovery(String tokenRecovery) {
        this.tokenRecovery = tokenRecovery;
    }

    public String getCreate_at() {
        return create_at;
    }

    public void setCreate_at(String create_at) {
        this.create_at = create_at;
    }

    public String getUpdate_at() {
        return update_at;
    }

    public void setUpdate_at(String update_at) {
        this.update_at = update_at;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public usuario() {
    }

    public usuario(int ID, String nombre, String apellidoPaterno, String apellidoMaterno, String correo, String contrasenia, String contrasenia2, String fechaNacimiento, String status, String codigoConfirmacion, String tokenRecovery, String create_at, String update_at, String estatus, String mensaje) {
        this.ID = ID;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.correo = correo;
        this.contrasenia = contrasenia;
        this.contrasenia2 = contrasenia2;
        this.fechaNacimiento = fechaNacimiento;
        this.status = status;
        this.codigoConfirmacion = codigoConfirmacion;
        this.tokenRecovery = tokenRecovery;
        this.create_at = create_at;
        this.update_at = update_at;
        this.estatus = estatus;
        this.mensaje = mensaje;
    }

}
