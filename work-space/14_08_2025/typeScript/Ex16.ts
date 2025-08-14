interface Employee {
  empId: number;
  empName: string;
  salary: number;
}

function printEmployees(employees: Employee[]): number {
  for (let i = 0; i < employees.length; i++) {
    console.log(employees[i].empId, employees[i].empName, employees[i].salary);
  }
  return employees.length;
}

let employees: Employee[] = [
  { empId: 1, empName: "Alice", salary: 50000 },
  { empId: 2, empName: "Bob", salary: 60000 },
  { empId: 3, empName: "Charlie", salary: 55000 }
];

console.log("Total Employees:", printEmployees(employees));
