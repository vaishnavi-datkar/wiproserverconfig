import { multiply, divide } from "./operations.js";

console.log("Multiply 5 * 3 =", multiply(5, 3)); // 15
console.log("Divide 10 / 2 =", divide(10, 2));   // 5
console.log("Divide 10 / 0 =", divide(10, 0));   // Error: Division by zero is not allowed.