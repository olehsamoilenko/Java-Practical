package com.company;

import java.awt.*;

public class Main {

    private static void help() {
        System.out.print(
                "1 - create boss\n" +
                "2 - create inspector\n" +
                "3 - create district\n" +
                "4 - create resident\n"
        );
    }

    public static void main(String[] args) {
        Container bosses = new Container("bosses");
        Container districts = new Container("districts");
        Container inspectors = new Container("inspectors");
        Container residents = new Container("residents");

        bosses.add(new Boss("Олег", "Самойленко"));

        districts.add(new District("Голосеевский"));
        districts.add(new District("Демеевский"));



//        ((Boss)bosses.get(0)).approveDistrict((District)districts.get(0));
        ((Boss)bosses.get(0)).distributeDistrict((District)districts.get(0), (Inspector)inspectors.get(0));

        inspectors.add(new Inspector("Андрей", "Андреев"));

        residents.add(new Resident("Екатерина", "Екатеринова"));
        residents.add(new Resident("Мария", "Шевченко"));


        districts.show();


        ((Inspector)inspectors.get(0)).createRegistration((Resident)residents.get(0), "Ломоносова, 47, 406");

        inspectors.show();



//        System.out.println(districts.get(0).toString());
//        b.approveDistrict(gol);
//        b.approveDistrict(dem);

//        Inspector ins2 = new Inspector("Иван", "Иванов");
//        b.distributeDistrict(gol, ins1);
//        b.distributeDistrict(dem, ins2);
//        System.out.println(ins1.toString());
//        System.out.println();


//        ins1.showResidents();
//        ins1.removeRegistration(res1);
//        System.out.println();
//        ins1.showResidents();
//        System.out.println();
//        res2.makeApplication("Я хочу продлить свою прописку!");
//        System.out.println();
//        ins1.makeQuery(res2, "Вам следует явиться в паспортный стол в течении 2 дней.");
    }
}
