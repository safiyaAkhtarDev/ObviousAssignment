package com.safiya.obviousassignment;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;

class StringDateComparator implements Comparator<GridImages>
{
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
    public int compare(String lhs, String rhs) {
        try {
            return dateFormat.parse(lhs).compareTo(dateFormat.parse(rhs));
        } catch (ParseException e) {
            e.printStackTrace();
            return 1;
        }

    }

    @Override
    public int compare(GridImages o1, GridImages o2) {
        try {
            return dateFormat.parse(o1.getDate()).compareTo(dateFormat.parse(o2.getDate()));
        } catch (ParseException e) {
            e.printStackTrace();
            return 1;
        }
    }
}