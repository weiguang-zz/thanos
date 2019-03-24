package com.thanos.spm.domain.supplier.command;


import lombok.Getter;

public enum SupplierStateEnum {


    CREAT(10,"创建"),
    DEL(99,"删除"),
    ;


    @Getter
    private int code;

    @Getter
    private String desc;

    SupplierStateEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

}
