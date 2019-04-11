package cn.logcode.traffic.bean.song;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.Date;

@DatabaseTable
public class CarBeans {
    @DatabaseField(generatedId = true)
    public int id;
    @DatabaseField
    public int num;
    @DatabaseField
    public int money;
    @DatabaseField
    public Date date;

    public CarBeans() {
    }
}
