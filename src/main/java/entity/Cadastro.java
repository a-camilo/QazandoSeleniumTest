package entity;

public class Cadastro {

    private String name;
    private String email;
    private String password;

    public Cadastro() {
    }

    public Cadastro(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public Cadastro(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public boolean isEmailValid(String email) {
        return email.matches("^[A-Za-z0-9+_.-]+@(.+)$");
    }

    public String getPassword() {
        return password;
    }

    public boolean isPasswordValid(String password) {
        return password.matches("[a-zA-Z0-9]");
    }

}
