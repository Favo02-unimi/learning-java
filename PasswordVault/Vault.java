import java.util.ArrayList;

public class Vault {

    private ArrayList<Login> passwordSalvate;

    public Vault() {
        passwordSalvate = new ArrayList<>();
    }

    public void createLogin(Login login) {
        passwordSalvate.add(login);
    }

    public void removeLogin(int i) {
        passwordSalvate.remove(i);
    }

    public Login getLogin(int i) {
        return passwordSalvate.get(i);
    }

    public String toString() {
        return passwordSalvate.toString();
    }


}
