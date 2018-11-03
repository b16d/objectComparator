package com.acl;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PojoComaparator {

    public List<Result> compare(Object object1, Object object2, String ... listOfExcludedFields) {
        List<Result> resultList = new ArrayList<>();

        if (object1.getClass().getName().equals(object2.getClass().getName())) {
            List<String> listOfFilteredField = Arrays.asList(listOfExcludedFields);

            Field[] listOfField = object1.getClass().getDeclaredFields();

            for (Field field : listOfField) {

                //Do nothing if an excluded field if found
                if (listOfFilteredField.contains(field.getName())) {
                   break;
                }

                //Start to compare field
                try {
                    field.setAccessible(true);

                    //get value from both object - force
                    Object value1 = field.get(object1);
                    Object value2 = field.get(object2);

                    //Compare object
                    if (!value1.equals(value2)) {
                        //Force String fir the result
                        resultList.add(new Result(field.getName(), value1.toString(),value2.toString()));
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
            return resultList;
        }
        return null;
    }
}
