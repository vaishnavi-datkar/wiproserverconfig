class Stack<T> {
    private items: T[] = []; 


    push(item: T): void {
        this.items.push(item);
    }

    
    pop(): T | undefined {
        return this.items.pop();
    }

    peek(): T | undefined {
        return this.items[this.items.length - 1];
    }
    isEmpty(): boolean {
        return this.items.length === 0;
    }

    size(): number {
        return this.items.length;
    }
}
let numberStack = new Stack<number>();
numberStack.push(10);
numberStack.push(20);
console.log(numberStack.peek()); 
console.log(numberStack.pop());  
console.log(numberStack.pop());  
console.log(numberStack.pop());  

let stringStack = new Stack<string>();
stringStack.push("Hello");
stringStack.push("World");
console.log(stringStack.peek()); 
