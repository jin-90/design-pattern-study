package me.ukuz.designpattern.template.jdbc.domain;

/**
 * @description:
 * @author: ukuz90
 * @create: 2019-05-04
 */
public class CardEntity {

    private long id;
    private String code;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }


    @Override
    public String toString() {
        return "CardEntity{" +
                "id=" + id +
                ", code='" + code + '\'' +
                '}';
    }
}
