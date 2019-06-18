package com.afei.formula;


public class customFormula {





    public static void main(String[] args) {
        String s="\\{\"id\":\"field_q0v3__u\",\"moduleInfoId\":\"object_cddl__u\",\"formula\":\"交叉报表海啸勿删-KPI\"\\}";
        String str="{\"id\":\"Field_q0v3__u\",\"moduleInfoId\":\"Object_cddl__u\"," +
                "\"formula\":\"交叉报表海啸勿删-KPI\"}+{\"id\":\"Field_ukci__u\",\"moduleInfoId\":\"Object_cddl__u\"," +
                "\"formula\":\"交叉报表海啸勿删-投资总额\"}";


        System.out.println(s.equals(str));



        String s1 ="3782.00";
        Double i = Double.valueOf(s1);

        System.out.println(i);


    }



}
