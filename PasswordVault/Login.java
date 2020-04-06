public class Login {

    public Login(String urlSito, String username, String password) {
        this.urlSito = urlSito;
        this.password = password;
        this.username = username;
    }

    private String urlSito;
    private String username;
    private String password;

    public String getUrlSito() {
        return urlSito;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public String toString() {
        return "URL: " + urlSito +
                "\nUsername: " + username +
                "\nPassword: " + password;
    }

}
