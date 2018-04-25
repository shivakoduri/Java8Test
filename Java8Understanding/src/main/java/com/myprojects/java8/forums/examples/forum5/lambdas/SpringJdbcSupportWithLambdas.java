package com.myprojects.java8.forums.examples.forum5.lambdas;

import com.myprojects.java8.forums.examples.forum5.model.Personfrm5;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SpringJdbcSupportWithLambdas extends JdbcDaoSupport {

    public Personfrm5 findPersonById(String id) {
        return getJdbcTemplate().queryForObject(
                // not secured against SQL injections, don't do this in production code!
                "SELECT * FROM persons WHERE id = " + id,
                new RowMapper<Personfrm5>() {
                    @Override
                    public Personfrm5 mapRow(ResultSet rs, int i) throws SQLException {
                        return new Personfrm5(rs.getString("FIRST_NAME"), rs.getString("LAST_NAME"), rs.getDate(3).toLocalDate(), Personfrm5.Gender.MALE);
                    }
                });
    }

    public Personfrm5 findPersonByIdWithLambdas(String id) {
        return getJdbcTemplate().queryForObject(
                "SELECT * FROM persons WHERE id = " + id,
                (rs, i) -> new Personfrm5(rs.getString("FIRST_NAME"), rs.getString("LAST_NAME"), rs.getDate(3).toLocalDate(), Personfrm5.Gender.MALE));
    }

    // if things get messy, use a method reference
    // overall this is more verbose but maybe better for readability?
    public Personfrm5 findPersonByIfWithMethodReference(String id) {
        return getJdbcTemplate().queryForObject("SELECT * FROM persons WHERE id = " + id, this::mapPerson);
    }

    private Personfrm5 mapPerson(ResultSet rs, int i) throws SQLException {
        return new Personfrm5(
                rs.getString("FIRST_NAME"),
                rs.getString("LAST_NAME"),
                rs.getDate(3).toLocalDate(),
                Personfrm5.Gender.MALE);
    }
}
