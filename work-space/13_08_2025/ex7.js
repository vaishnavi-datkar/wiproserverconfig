let persons = [
  {
    name: "Vaishnavi",
    age: 23,
    city: "Pune",
  },
  {
    name: "sayali",
    age: 22,
    city: "Mumbai",
  },
  {
    name: "Sai",
    age: 26,
    city: "Delhi",
  },
];
 
let eligibleVoters = persons.filter(function(person) {
            return person.age >= 18;
        });
 console.log("Eligible Voters:");
        eligibleVoters.forEach(function(voter) {
            console.log(voter.name + " (" + voter.age + " years) - " + voter.city);
        });

 