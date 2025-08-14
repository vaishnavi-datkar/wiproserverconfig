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

 let updated = persons.map(i => {
        if (i.age >= 18) {
            i.status = "Adult";
        } else {
            i.status = "Minor";
        }
        return i; 
    });

    console.log(updated);//value cheking == loose checking, check value and type both in === strick checking