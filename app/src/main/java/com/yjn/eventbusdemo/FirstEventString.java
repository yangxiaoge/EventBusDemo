package com.yjn.eventbusdemo;

import java.util.List;

/**
 * Author:0027008122 [yang.jianan@zte.com.cn]
 * Date:2016-05-18
 * Time:15:06
 * Version:1.0
 * TaskId:
 */
public class FirstEventString {
    private List list;
    private String str;

    public FirstEventString(String str) {
        this.str = str;
    }

    public FirstEventString(List list) {
        this.list = list;
    }

    public String getStr() {
        return str;
    }

    public List getList() {
        return list;
    }

}
