package business.entities;

public class User
{
    public User(int id, String email, String password, String role, float balance)
    {
        this.id = id;
        this.email = email;
        this.password = password;
        this.role = role;
        this.balance = balance;
    }

    public User(String email, String password, String role)
    {
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public User(int id, String email)
    {
        this.id = id;
        this.email = email;
    }

    private int id;
    private String email;
    private String password; // Should be hashed and secured
    private String role;
    private float balance;

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getRole()
    {
        return role;
    }

    public void setRole(String role)
    {
        this.role = role;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }
}
