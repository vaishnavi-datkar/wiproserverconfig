class Box<T> {
    private value:T;
    constructor(value: T) {
        this.value = value;
    }
     getValue(): T {
        return this.value;
    }
}

let num = new Box<number>(20);
console.log(num.getValue());

let str = new Box<string>("vaishnavi");
console.log(str.getValue()); 

let bool = new Box<boolean>(true);
console.log(bool.getValue());
