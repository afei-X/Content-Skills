package com.afei.pojo.iso;

import com.jingdata.metadata.common.constant.CurrencyUnitConstant;

import java.util.Set;

/**
 * @author gongxiangfei
 * @describe 标准货币符号
 * @dataTime now();
 */
public class ISO {


    public static void main(String[] args){

        String str="CNtt 123";

        boolean flag=false;
        Set<String> currencyUnits = CurrencyUnitConstant.CURRENCY_UNITS;
        for (String unit : currencyUnits) {

            if(str.contains(unit)){
                flag=true;
                break;
            }
        }

        System.out.println(flag);
    }




}
