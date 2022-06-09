package com.thinking.machines.hr.dl;
import com.thinking.machines.hr.dl.*;
import java.sql.*;
import java.math.*;
import java.util.*;

public class EmployeeDAO {

    public List<EmployeeDTO> getAll() throws DAOException {
        List<EmployeeDTO> employees;
        employees = new LinkedList<>();
        try {
            Connection connection = DAOConnection.getConnection();
            Statement statement;
            statement = connection.createStatement();
            ResultSet resultSet;
            resultSet = statement.executeQuery("select * from designation order by title");
            EmployeeDTO employeeDTO;
            int id;
            String name;
            String title;
            int designationCode;
            java.util.Date dateOfBirth;
            String city;
            String panNumber;
            String aadharNumber;

            while (resultSet.next()) {


                id = resultSet.getInt("id");
                name = resultSet.getString("name");
                title = resultSet.getString("title");
                designationCode = resultSet.getInt("designation_code");
                dateOfBirth=resultSet.getDate("date_of_birth");
                city = resultSet.getString("city");
                panNumber = resultSet.getString("pan_number");
                aadharNumber = resultSet.getString("aadharNumber");
                employeeDTO = new EmployeeDTO();
                employeeDTO.setId("A" + id);
                employeeDTO.setName(name);
                employeeDTO.setTitle(title);
                employeeDTO.setDesignationCode(designationCode);
                employeeDTO.setDateOfBirth(dateOfBirth);
                employeeDTO.setCity(city);
                employeeDTO.setPanNumber(panNumber);
                employeeDTO.setAadharNumber(aadharNumber);
                employees.add(employeeDTO);

            }

            resultSet.close();
            statement.close();
            connection.close();

        } catch (Exception exception) {
            throw new DAOException(exception.getMessage());
        }
        return employees;
    }

}
