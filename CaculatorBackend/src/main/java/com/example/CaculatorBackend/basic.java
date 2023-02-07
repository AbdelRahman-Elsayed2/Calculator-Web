package com.example.CaculatorBackend;

import java.math.BigDecimal;

public class basic {
    private  String operand_1;
    private  String operand_2;
    private  String operator;
    private  String Res;
    public basic (String op_1,String op_2,String operator){
        this.operand_1=op_1;
        this.operand_2=op_2;
        this.operator=operator;
    }
    public String getOperand_1() {
        return operand_1;
    }

    public void setOperand_1(String operand_1) {
        this.operand_1 = operand_1;
    }
    public String getOperand_2() {
        return operand_2;
    }

    public void setOperand_2(String operand_2) {
        this.operand_2 = operand_2;
    }

    public String getOperator() {
        return operator;
    }
    public void setOperator(String operator) {
        this.operator = operator;
    }
    public String getResult (){
        return Res;
    }
    public void setRes(String res){
        this.Res = res;
    }
}
