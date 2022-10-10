package common;

import org.apache.commons.lang3.RandomUtils;

import java.util.ArrayList;

public class ValueChoosers {

        public static String getRandomSex() {
            ArrayList<String> listOfSex = new ArrayList<>();
            listOfSex.add("F");
            listOfSex.add("M");

            return listOfSex.get(RandomUtils.nextInt(0, listOfSex.size()));
        }

        public static String getRandomDate(){
            ArrayList<String>listOfDates = new ArrayList<>();
            listOfDates.add("2020-12-12");
            listOfDates.add("2022-10-10");
            listOfDates.add("2021-11-11");

            return  listOfDates.get(RandomUtils.nextInt(0, listOfDates.size()));
        }

    }
