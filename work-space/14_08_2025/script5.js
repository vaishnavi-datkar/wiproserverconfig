
class Vehicle {
    constructor(brand, modelName, mfgYear) {
        this.brand = brand;
        this.modelName = modelName;
        this.mfgYear = mfgYear;
    }

    getDetails() {
        return `${this.brand} ${this.modelName} (${this.mfgYear})`;
    }
}


class Car extends Vehicle {
    constructor(brand, modelName, mfgYear, doors) {
        super(brand, modelName, mfgYear);
        this.doors = doors;
    }

    getDetails() {
        return `${super.getDetails()} - ${this.doors} Door${this.doors > 1 ? 's' : ''}`;
    }
}

let car1 = new Car("Hyundai", "Verna", 2023, 4);
console.log(car1.getDetails());
