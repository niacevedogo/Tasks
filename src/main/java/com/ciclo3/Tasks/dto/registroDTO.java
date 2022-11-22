package com.ciclo3.Tasks.dto;


public class registroDTO {

    private String nombres;
    private String apellidos;
    private String numeroDocumento;
    private String email;
//    private TipoDocumento tipoDocumento;
    private String password;
    private String validaPassword;

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

//    public TipoDocumento getTipoDocumento() {
//        return tipoDocumento;
//    }

//    public void setTipoDocumento(TipoDocumento tipoDocumento) {
//        this.tipoDocumento = tipoDocumento;
//    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getValidaPassword() {
        return validaPassword;
    }

    public void setValidaPassword(String validaPassword) {
        this.validaPassword = validaPassword;
    }
}