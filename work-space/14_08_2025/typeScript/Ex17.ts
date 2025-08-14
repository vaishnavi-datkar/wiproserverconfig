class Calculator{
    add(a: number,b:number):number{
        return a + b;
    }
    sub(a: number,b:number):number{
      return a - b;  
    }
}
let calc = new Calculator();
console.log("Addition:", calc.add(10, 5));       
console.log("Subtraction:", calc.sub(10, 5))