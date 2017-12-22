package com.mir.mpchartdemo;

/**
 * @author by lx
 * @github https://github.com/a1498506790
 * @data 2017/12/21
 * @desc
 */
public class TestBean {

    private String value;
    private String time;

    public TestBean(String value, String time) {
        this.value = value;
        this.time = time;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
