package com.acl;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PojoComaparator {

    public List<Result> compare(Object object1, Object object2, String ... listOfExcludedFields) {
        List<Result> resultList = new ArrayList<>();

        if (object1.getClass().getName().equals(object2.getClass().getName())) {

            Field[] listOfField = object1.getClass().getDeclaredFields();

            //Remove Unused Field
            List<String> listOfFilteredField = Arrays.asList(listOfExcludedFields);


            for (Field field : listOfField) {

                if (listOfFilteredField.contains(field.getName())) {
                   break;
                }

                System.out.println(field.getName());
                try {
                    Field fieldTempo = object1.getClass().getDeclaredField(field.getName());
                    fieldTempo.setAccessible(true);

                    String value1 = fieldTempo.get(object1).toString();
                    String value2 = fieldTempo.get(object2).toString();

                    if (!value1.equals(value2)) {
                        resultList.add(new Result(field.getName(), value1,value2));
                    }
                } catch (NoSuchFieldException | IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(listOfField);

            return resultList;
        }
        return null;
    }



}
