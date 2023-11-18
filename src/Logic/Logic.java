package Logic;

import JDBC.JDBC;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Logic {
    public ResultSet ViewContact (String who) throws SQLException {
        JDBC jdbc = new JDBC();

        ResultSet rs = null;
        ResultSet rs1 = jdbc.select_name(who);
        ResultSet rs2 = jdbc.select_phone(who);

        //这里将结果集设置为可向前滚动才行
        if (rs1.next()) {
            rs1.previous();
            rs = rs1;
        }
        else rs = rs2;

        return rs;
    }

    public boolean AddContact(String name, String phone,String email,String address) {

        JDBC jdbc = new JDBC();

        if (jdbc.insert(name, phone,email,address)) {
            return true;
        }
        else {
            return false;
        }
    }

    public void ModifyContact(int id, int how, String update) throws SQLException {

        JDBC jdbc = new JDBC();

        if (how == 1) jdbc.update_name(id,update);
        if (how == 2) jdbc.update_phone(id, update);
        if (how == 3) jdbc.update_email(id,update);
        if (how == 4) jdbc.update_address(id,update);
    }

    public boolean DeleteContact (int id) {
        JDBC jdbc = new JDBC();

        if (jdbc.delete(id)) {
            return true;
        }
        else {
            return false;
        }
    }
}
