let cities = ["Pune", "Mumbai", "Delhi", "Bangalore", "Chennai"];

function addCities(){
    cities.sort();

    let dropdown = document.getElementById("cityDropdown");
    dropdown.innerHTML = "";

    for(let i=0;i<cities.length;i++){
        let option = document.createElement("option");
        option.text = cities[i];
        dropdown.add(option);
    }
}