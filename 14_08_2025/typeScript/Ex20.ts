function pair<T, U>(first: T, second: U): [T, U] {
    return [first, second];
}

let result1 = pair<number, string>(22, "Vaishnavi");
console.log(result1); 

let result2 = pair<boolean, number>(true, 210);
console.log(result2); 
