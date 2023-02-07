package com.example.CaculatorBackend;

import com.sun.tools.jconsole.JConsoleContext;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Service;

@Service
public class serviceCalculator{

    public void  Add ( basic b){
        b.setOperator("+");
        double varLong = Double.parseDouble(b.getOperand_1())+Double.parseDouble(b.getOperand_2());
        String res = Double.toString(varLong);
        b.setRes(res);
    }
    public void  subtract ( basic b){
        b.setOperator("-");
        Double varLong = Double.parseDouble(b.getOperand_2())-Double.parseDouble(b.getOperand_1());
        String res = Double.toString(varLong);
        b.setRes(res);
    }
    public void  multiply ( basic b){
        b.setOperator("*");
        Double varLong = Double.parseDouble(b.getOperand_2()) * Double.parseDouble(b.getOperand_1());
        String res = Double.toString(varLong);
        b.setRes(res);

    }
    public void  divide ( basic b){
        if (Double.parseDouble(b.getOperand_1())==0.0){
            b.setRes("Error");
        }
        else {
            b.setOperator("/");
            Double varLong = Double.parseDouble(b.getOperand_2()) / Double.parseDouble(b.getOperand_1());
            String res = Double.toString(varLong);
            b.setRes(res);
        }
    }
    public void percentage ( basic b){
        Double x =100.0;
        Double varLong = Double.parseDouble(b.getOperand_2())-(Double.parseDouble(b.getOperand_1())/x)*Double.parseDouble(b.getOperand_2());
        String res = Double.toString(varLong);
        b.setRes(res);
    }
}
