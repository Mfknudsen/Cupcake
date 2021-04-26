package business.persistence;

import business.exceptions.UserException;
import business.entities.User;

import java.sql.*;

public class UserMapper
{
    private Database database;

    public UserMapper(Database database)
    {
        this.database = database;
    }

    public void createUser(User user) throws UserException
    {
        try (Connection connection = database.connect())
        {
            String sql = "INSERT INTO `cupcake`.`user` " +
                    "(`user`.`email`, `user`.`password`, `user`.`role`) " +
                    "VALUES (?, ?, ?)";

            try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS))
            {
                ps.setString(1, user.getEmail());
                ps.setString(2, user.getPassword());
                ps.setString(3, user.getRole());
                ps.executeUpdate();
                ResultSet ids = ps.getGeneratedKeys();
                ids.next();
                int id = ids.getInt(1);
                user.setId(id);
            }
            catch (SQLException ex)
            {
                throw new UserException(ex.getMessage());
            }
        }
        catch (SQLException ex)
        {
            throw new UserException(ex.getMessage());
        }
    }

    public User login(String email, String password) throws UserException
    {
        try (Connection connection = database.connect())
        {
            String sql = "SELECT `user`.`user_id`, `user`.`role` " +
                    "FROM `cupcake`.`user` " +
                    "WHERE `user`.`email` = ? AND `user`.`password` = ?";

            try (PreparedStatement ps = connection.prepareStatement(sql))
            {
                ps.setString(1, email);
                ps.setString(2, password);
                ResultSet rs = ps.executeQuery();
                if (rs.next())
                {
                    String role = rs.getString("role");
                    int id = rs.getInt("user_id");
                    User user = new User(email, password, role);
                    user.setId(id);
                    return user;
                } else
                {
                    throw new UserException("Could not validate user");
                }
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

    public int addBalance(float amount, int userId) throws UserException
    {
        try (Connection connection = database.connect())
        {
            String sql = "UPDATE `user` AS `u` " +
                    "SET `u`.`balance` = `u`.`balance` + (?) " +
                    "WHERE `u`.`user_id` = ?";

            try (PreparedStatement ps = connection.prepareStatement(sql))
            {
                ps.setFloat(1, Math.abs(amount));
                ps.setInt(2, userId);
                int affectedRows = ps.executeUpdate();
                if (!(affectedRows > 0))
                {
                    throw new UserException("No user found");
                }
                return affectedRows;
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

    public float getBalance(int userId) throws UserException
    {
        try (Connection connection = database.connect())
        {
            String sql = "SELECT `u`.`balance` " +
                    "FROM `user` AS `u` " +
                    "WHERE `u`.`user_id` = ?";

            try (PreparedStatement ps = connection.prepareStatement(sql))
            {
                ps.setInt(1, userId);
                ResultSet rs = ps.executeQuery();
                if (rs.next())
                {
                    return rs.getFloat("balance");
                } else
                {
                    throw new UserException("Could not validate user");
                }
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
