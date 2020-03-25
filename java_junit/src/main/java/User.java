public class User {

    private String name;
    private final String company;
    private String password;

    public User(String name, String company, String password) {
        this.name = name;
        this.company = company;
        this.password = password;
    }

    public boolean isValid() {
        return password.length() >= 8;
    }

    public String getSign() {
        return companyName() + name + validLabel();
    }

    private String companyName() {
        String company = "";
        if (this.company != null) {
            company += (this.company + ": ");
        }
        return company;
    }

    private String validLabel() {
        return isValid() ? " OK" : " NG";
    }
}
