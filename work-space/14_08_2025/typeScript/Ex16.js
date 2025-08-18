function printEmployees(employees) {
    for (var i = 0; i < employees.length; i++) {
        console.log(employees[i].empId, employees[i].empName, employees[i].salary);
    }
    return employees.length;
}
var employees = [
    { empId: 1, empName: "Alice", salary: 50000 },
    { empId: 2, empName: "Bob", salary: 60000 },
    { empId: 3, empName: "Charlie", salary: 55000 }
];
console.log("Total Employees:", printEmployees(employees));
