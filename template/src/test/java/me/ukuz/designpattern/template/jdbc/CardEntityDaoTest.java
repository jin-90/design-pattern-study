package me.ukuz.designpattern.template.jdbc;

import com.mysql.cj.jdbc.MysqlDataSource;
import me.ukuz.designpattern.template.jdbc.domain.CardEntity;

import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

public class CardEntityDaoTest {

    public static void main(String[] args) throws SQLException {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("mysql");

        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setURL(resourceBundle.getString("url"));
        dataSource.setUser(resourceBundle.getString("username"));
        dataSource.setPassword(resourceBundle.getString("password"));

        CardEntityDao cardEntityDao = new CardEntityDao(dataSource);
        List<CardEntity> list = cardEntityDao.queryList("select * from card_innodb");
        System.out.println(list);
    }

}