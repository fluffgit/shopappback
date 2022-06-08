package com.example.shopapp.entity;


    public enum TravelType {


        BB("(bed & breakfast) – samo śniadanie"),
        HB("(half board) – śniadanie i obiadokolacja"),
        FB("(full board) – pełne wyżywienie, które obejmuje śniadanie, obiad, kolację"),
        AI("(all inclusive) – pełne wyżywienie, napoje bezalkoholowe i alkohole"),
        OV("(overnight) – sam nocleg, bez wyżywienia"),
        SC("(self catering) – oznacza wyżywienie gościa we własnym zakresie"),
        PP("(program package) – posiłki wydawane zgodnie z programem"),
        ZPR(" posiłki wydawane zgodnie z programem hotelu lub opisem imprezy");

        TravelType(String description) {
        }
    }

