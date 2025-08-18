function separateFirstRest(...args) {
  const [first, ...rest] = args; 
  return { first, rest };
}
console.log(separateFirstRest(80, 20, 30, 40));
console.log(separateFirstRest("car","bus","bike"));

