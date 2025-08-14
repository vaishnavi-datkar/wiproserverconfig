function sumNumbersusing(...num){
let sum=0;
for(let i=0;i<num.length;i++){
  sum +=num[i];  
}
return sum;
}
console.log(sumNumbersusing(1,2,3,4,5));
console.log(sumNumbersusing(10,20,100));
