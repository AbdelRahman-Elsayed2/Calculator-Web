package com.example.CaculatorBackend;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.math.MathContext;

//@CrossOrigin()
//@RestController
//@RequestMapping("/One_Way_Operation")
import org.springframework.stereotype.Service;
@Service
public class OneOperand {
    public void changeSign ( basic b){
        Double varLong = Double.parseDouble(b.getOperand_1())*-1.0;
        String res = Double.toString(varLong);
        b.setRes(res);
    }
    public void square ( basic b){
        Double varLong = (Double) ( (Double.parseDouble(b.getOperand_1()))*  (Double.parseDouble(b.getOperand_1())));
        String res = Double.toString(varLong);
        b.setRes(res);
    }
    public void invert ( basic b){
        if (Double.parseDouble(b.getOperand_1())==0.0){
            b.setRes("Error");
        }
        else{
        Double varLong = 1/Double.parseDouble(b.getOperand_1());
        String res = Double.toString(varLong);
        b.setRes(res);}
    }
    public void sqrt ( basic b){
        if(Double.parseDouble(b.getOperand_1())<0){
            b.setRes("Error");
        }
        else {
            Double varLong = (Double) Math.sqrt( Double.parseDouble(b.getOperand_1()) );
            String res = Double.toString(varLong);
            b.setRes(res);
        }
    }

}
