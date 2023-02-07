import { Component, OnInit } from '@angular/core';
import { HttpClient, HttpHeaders } from "@angular/common/http";

const httpOptions: Object = {
  headers: new HttpHeaders({
    'content-type': 'application/json',
  }), responseType: 'text'
};

@Component({
  selector: 'app-calculator',
  templateUrl: './calculator.component.html',
  styleUrls: ['./calculator.component.css']
})
//in summary the class send string (operand) to the backend to controller
export class CalculatorComponent implements OnInit {
  num2: string = '0';  //this is the second operand and result
  num: string = '0';
  output_num: string = ''; //the output which be written in the background
  operator: string = 'Add';  //initilaze to operator
  operator_symbol: string = '+';

  dots: number = 0;
  equal: boolean = false;
  start: boolean = false;

  constructor(private http: HttpClient) { }

  ngOnInit(): void {
  }
  //this method will connect the next digit to the the previous
  public connect(num1: string, num2: string) {
    return num1 + num2;
  }

  public changeInput(input: string) {
    if (this.num.length - this.dots >= 30) return //assume maximum size will 30 digit
    this.start = true;
    if (input == '.') {
      if (this.dots == 0) { //handle when input fraction
        this.num = this.connect(this.num, input);
        this.dots += 1;
      }
    }
    else {
      if (this.num == '0') this.num = input;//to delete the start zero
      else this.num = this.connect(this.num, input);
    }
  }
  public Equal() {
    this.http.post<string>(`http://localhost:8080/calculator1/${this.operator}`, JSON.stringify
      ({ "op_1": this.num, "op_2": this.num2 }), httpOptions).
      subscribe(response => {
        this.num = response;
        this.equal = true;
        this.num2 = '0';
        this.operator = 'Add';
        this.output_num = '';
        this.dots = 0;
      }
      )
  }//for operation with one operand
  public oneOperand(input: string, sign: boolean) {
    this.http.post<string>(`http://localhost:8080/calculator1/${input}`, JSON.stringify
      ({ "op_1": this.num, "op_2": null }), httpOptions).
      subscribe(response => {
        if (!response.localeCompare("Error")) {
          this.delete('all');
          this.num = 'Error';
          this.equal = true;
          return;
        }
        else{
        this.num = response;
        if (sign) return;}
       
      }
      )
  }
  //for operation with two operand
  public twoOperand(input: string, op: string) {
    if (!this.start) {//if the operation not from start it will take the last result and operate on it
      this.operator_symbol = op;
      this.operator = input;
      this.output_num = this.num2 + ' ' + op;
      return;
    }
    this.http.post<string>(`http://localhost:8080/calculator1/${this.operator}`, JSON.stringify
      ({ "op_1": this.num, "op_2": this.num2 }), httpOptions).
      subscribe(response => {
        if (!response.localeCompare("Error")) {
          this.delete('all');
          this.num = 'Error';
          this.equal = true;
        }
        else{
        this.num2 = response;
        this.num = '0';
        this.output_num = this.num2 + ' ' + op;
        this.operator = input;
        this.operator_symbol = op;
        this.dots = 0;
        this.start= false;}
      }
      )
  }
  //this method will delete by type determined if the last digit or all or last operand
  public delete(type: string) {
    if (this.equal) {
      this.equal = false;
      type = 'last';
    }
    if (type == 'digit') {
      if (this.num.length == 1) this.num = '0';
      else {
        if (this.num[this.num.length - 1] == '.') this.dots = 0;//reset the fraction to 0
        this.num = this.num.slice(0, -1);//rewrite the string without the last digit
      }
    }
    else if (type == 'last') {
      this.num = '0';
      this.dots = 0;
      this.start = false;
    }
    else if (type == 'all') {
      //set the variable to default variable
      this.num = '0';
      this.num2 = '0';
      this.operator = 'Add';
      this.output_num = '';
      this.dots = 0;
      this.equal = false;
      this.start = false;
    }
  }

}
