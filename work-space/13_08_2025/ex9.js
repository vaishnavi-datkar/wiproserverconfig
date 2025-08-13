 let persons = [
            { 
                name: "Gitu",
                 age: 17, 
                 city: "Pune" 
                },
            { 
                name: "Vaishnavi", 
                age: 23,
                 city: "Mumbai" 
                },
            { 
                name: "Sahil",
                 age: 19,
                  city: "Delhi" 
                },
            { 
                name: "Gayatri", 
                age: 15,
                 city: "Chennai"
                 },
            { 
                name: "Sai", 
                age: 25,
                 city: "Bangalore"
                 }
        ];

        for (let i = 0; i < persons.length; i++) {
            if (persons[i].age >= 18) {
                persons[i].status = "Adult";
            } else {
                persons[i].status = "Minor";
            }
        }

        console.log(persons);