 let employees = [
            { name: "Sai", role: "Manager", empId: "E101", salary: 80000 },
            { name: "Neha", role: "Developer", empId: "E102", salary: 60000 },
            { name: "Sheha", role: "Manager", empId: "E103", salary: 90000 },
            { name: "Priti", role: "QA", empId: "E104", salary: 50000 },
            { name: "Omkar", role: "Manager", empId: "E105", salary: 85000 }
        ];

    
        let managers = employees.filter(function(emp) {
            return emp.role === "Manager";
        });

        let totalManagerSalary = managers.reduce(function(total, emp) {
            return total + emp.salary;
        }, 0);

        console.log("Total Salary of Managers: " + totalManagerSalary);
