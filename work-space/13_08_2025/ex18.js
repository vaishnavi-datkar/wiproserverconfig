function calculate(operation) {
            let n1 = parseFloat(document.getElementById("num1").value);
            let n2 = parseFloat(document.getElementById("num2").value);
            let result;

            if (isNaN(n1) || isNaN(n2)) {
                alert("Please enter both numbers!");
                return;
            }

            switch (operation) {
                case 'add':
                    result = n1 + n2;
                    break;
                case 'subtract':
                    result = n1 - n2;
                    break;
                case 'multiply':
                    result = n1 * n2;
                    break;
                case 'divide':
                    if (n2 === 0) {
                        alert("Cannot divide by zero!");
                        return;
                    }
                    result = n1 / n2;
                    break;
            }

            document.getElementById("result").innerText = result;
        }