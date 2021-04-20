package business.persistence;

import business.entities.User;
import business.exceptions.UserException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerMapper
{
    private Database database;

    public CustomerMapper(Database database)
    {
        this.database = database;
    }

    public List<User> getAllCustomers() throws UserException
    {
        List<User> userList = new ArrayList<>();

        try (Connection connection = database.connect())
        {
            String sql = "SELECT `user`.`user_id`, `user`.`email` " +
                    "FROM `user` " +
                    "WHERE `user`.`role` = 'customer'";

            try (PreparedStatement ps = connection.prepareStatement(sql))
            {
                ResultSet rs = ps.executeQuery();
                while (rs.next())
                {
                    int id = rs.getInt("user_id");
                    String email = rs.getString("email");
                    userList.add(new User(id, email));
                }
                return userList;
            }
            catch (SQLException ex)
            {
                throw new UserException(ex.getMessage());
            }
        }
        catch (SQLException ex)
        {
            throw new UserException("Connection to database could not be established");
        }
    }

}
