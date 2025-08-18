class Util{
    getDate(){
        let today=new Date();
        let dd=today.getDate();
        let mm=today.getMonth();
        let yyyy=today.getFullYear();
        if(dd<10) dd='0'+dd;
        if(mm<10) mm='0' + mm;
        return `${dd}-${mm}-${yyyy}`;
    }
        getPIValue(){
            return Math.PI;
        }

        convertC2F(Celsius){
            return (Celsius * 9/5) + 32;
        }

        getFibonacciSeries(n){
            let fibo=[];
            for(let i=0;i<n;i++){
                if(i===0){
                    fibo.push(0);
                }else if(i===1){
                    fibo.push(1);
                }else{
                    fibo.push(fibo[i-1] + fibo[i-2]);

                }
            }
            return fibo;
        }
    }
        let u=new Util();
        console.log("Date:",u.getDate());
        console.log("PI value" , u.getPIValue());
        console.log("C2F" , u.convertC2F(15));
        console.log("Fibo Series upto 5", u.getFibonacciSeries(5));