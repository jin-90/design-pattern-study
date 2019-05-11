package me.ukuz.designpattern.template.jdbc;

import me.ukuz.designpattern.template.jdbc.domain.CardEntity;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author ukuz90
 * @date 2019-05-11
 */
public class CardEntityDao extends JdbcTemplate {

    public CardEntityDao(DataSource dataSource) {
        super(dataSource);
    }

    @Override
    CardEntity wrapRow(ResultSet rst, int rowNum) throws SQLException {
        CardEntity cardEntity = new CardEntity();
        cardEntity.setId(rst.getLong("id"));
        cardEntity.setCode(rst.getString("code"));
        return cardEntity;
    }
}
