package com.example.CaculatorBackend;
import org.springframework.web.bind.annotation.*;
@CrossOrigin()
@RestController
@RequestMapping("/calculator1")
public class controller_calculator {

    @PostMapping("/Add")
    public String add (@RequestBody basic cal){
        cal.setOperator("+");
        serviceCalculator Service = new serviceCalculator();
        Service.Add(cal);
        return cal.getResult();
    }
    @PostMapping("/Sub")
    public String subtract (@RequestBody basic b    ){
        b.setOperator("-");
        serviceCalculator Service = new serviceCalculator();
        Service.subtract(b);
        return b.getResult();
    }
    @PostMapping("/multi")
    public String multiply (@RequestBody basic b   ){
        b.setOperator("*");
        serviceCalculator Service = new serviceCalculator();
        Service.multiply(b);
        return b.getResult();
    }
    @PostMapping("/Div")
    public String divide (@RequestBody basic b    ){
        b.setOperator("/");
        serviceCalculator Service = new serviceCalculator();
        Service.divide(b);
        if(b.getResult()!="e")
        return b.getResult();
        else return "e";
    }
    @PostMapping("/Invert")
    public String invert (@RequestBody basic b  ){
        b.setOperator("");
        OneOperand Service = new OneOperand();
        Service.invert(b);
        return b.getResult();
    }
    @PostMapping("/Square")
    public String square (@RequestBody basic b  ){
        b.setOperator("");
        OneOperand Service = new OneOperand();
        Service.square(b);
        return b.getResult();
    }
    @PostMapping("/Sqrt")
    public String sqrt (@RequestBody basic b ){
        b.setOperator("");
        OneOperand Service = new OneOperand();
        Service.sqrt(b);
        return b.getResult();
    }
    @PostMapping("/Change_Sign")
    public String chSign (@RequestBody basic b ){
        b.setOperator("");
        OneOperand Service = new OneOperand();
        Service.changeSign(b);
        return b.getResult();
    }
    @PostMapping("/Percentage")
    public String percentage (@RequestBody basic b ){
        b.setOperator("");
        serviceCalculator Service = new serviceCalculator();
        Service.percentage(b);
        return b.getResult();
    }
}

