package com.example.bantugerak_mobile.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Campaign implements Serializable {
//    @PrimaryKey(autoGenerate = true)
//    @ColumnInfo(name = "idTb")
//    public int idTb;

    public int id;
    public String title;
    public String slug;
    public int category_id;
    public int target_donation;
    public String max_date;
    public String description;
    public String image;
    public User user = new User();
    public String created_at;
    public String updated_at;
    //    public SumDonation sum_donation = new SumDonation();

    public List<SumDonation> sum_donation = new ArrayList();

    public boolean selected = true;

}
