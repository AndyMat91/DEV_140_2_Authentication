package com.example.dev_140_2_authentication;

import java.io.IOException;
import java.sql.*;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;


public class Repository {
    public Set<Users> findAllUsers() throws SQLException, IOException {
        List<Users> users = new LinkedList<>();
        Connection connection = null;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            Statement s = connection.createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM users");
            while (rs.next()) {
                users.add(getAllUsersWithResultSet(rs));
            }
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) ConnectionPool.getInstance().resiveConnection(connection);
        }
        return new HashSet<>(users);
    }


    private Users getAllUsersWithResultSet(ResultSet resultSet) throws SQLException {
        Users users = null;
        int id = resultSet.getInt(1);
        String name = resultSet.getString(2);
        String password = resultSet.getString(3);
        users = new Users(id, name, password);
        return users;
    }

    public Set<Person> findAllPersons() throws SQLException, IOException {
        List<Person> persons = new LinkedList<>();
        Connection connection = null;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            Statement s = connection.createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM person");
            while (rs.next()) {
                persons.add(getAllPersonsWithResultSet(rs));
            }
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) ConnectionPool.getInstance().resiveConnection(connection);
        }
        return new HashSet<>(persons);
    }


    private Person getAllPersonsWithResultSet(ResultSet resultSet) throws SQLException {
        Person person = null;
        int id = resultSet.getInt(1);
        String jobtitle = resultSet.getString(2);
        String firstnamelastname = resultSet.getString(3);
        String phone = resultSet.getString(4);
        String email = resultSet.getString(5);
        person = new Person(id, jobtitle, firstnamelastname, phone, email);
        return person;
    }

    public Set<PersonDto> findAllPersonsDto() throws SQLException, IOException {
        List<PersonDto> personsDto = new LinkedList<>();
        Connection connection = null;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            Statement s = connection.createStatement();
            ResultSet rs = s.executeQuery("select id, jobtitle, firstnamelastname, phone, email, (SELECT COUNT(*) FROM dev_j140_db.domains WHERE personid = dev_j140_db.person.id) from dev_j140_db.person");
            while (rs.next()) {
                personsDto.add(getAllPersonsDtoWithResultSet(rs));
            }
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) ConnectionPool.getInstance().resiveConnection(connection);
        }
        return new HashSet<>(personsDto);
    }


    private PersonDto getAllPersonsDtoWithResultSet(ResultSet resultSet) throws SQLException {
        PersonDto personDto = null;
        int id = resultSet.getInt(1);
        String jobtitle = resultSet.getString(2);
        String firstnamelastname = resultSet.getString(3);
        String phone = resultSet.getString(4);
        String email = resultSet.getString(5);
        int count = resultSet.getInt(6);
        personDto = new PersonDto(id, jobtitle, firstnamelastname, phone, email, count);
        return personDto;
    }

    public Set<Domain> findAllClientsDomains(int personid) throws SQLException, IOException {
        List<Domain> clientsDomain = new LinkedList<>();
        Connection connection = null;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            Statement s = connection.createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM dev_j140_db.domains where personid = " + personid);
            while (rs.next()) {
                clientsDomain.add(getAllClientsDomainsWithResultSet(rs));
            }
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) ConnectionPool.getInstance().resiveConnection(connection);
        }
        return new HashSet<>(clientsDomain);
    }


    private Domain getAllClientsDomainsWithResultSet(ResultSet resultSet) throws SQLException {
        Domain domain = null;
        int id = resultSet.getInt(1);
        String webname = resultSet.getString(2);
        String domainname = resultSet.getString(3);
        String ip = resultSet.getString(4);
        Date datereg = resultSet.getDate(5);
        String countryreg = resultSet.getString(6);
        int personid = resultSet.getInt(7);
        domain = new Domain(id, webname, domainname, ip, datereg, countryreg, personid);
        return domain;
    }
}
