package com.common;

import com.sun.org.apache.xalan.internal.xsltc.compiler.util.StringType;

import java.util.Objects;

/**
 * @author shkstart
 * @create 2022-06-05 20:45
 */
public enum TypeEnum {

     TYPE_NATURE("nature","自然"),
     TYPE_TECH("tech","科学"),
     TYPE_HISTORY("history","历史");

     private String typeCode;
     private String typeDesc;

    private TypeEnum(String typeCode, String typeDesc) {
        this.typeCode = typeCode;
        this.typeDesc = typeDesc;
    }

    public static String getDescByCode(String typeCode) {
        for(TypeEnum typeEnum: TypeEnum.values()){
            if(Objects.equals(typeEnum.typeCode, typeCode)){
                return typeEnum.typeDesc;
            }
        }
        return null;
    }

    public String getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }

    public String getTypeDesc() {
        return typeDesc;
    }

    public void setTypeDesc(String typeDesc) {
        this.typeDesc = typeDesc;
    }
}
