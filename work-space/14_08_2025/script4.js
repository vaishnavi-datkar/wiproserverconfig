// BankAccount class - with custom style & extra checks
class BankAccount {
    constructor(accNum, startingBalance = 0) {
        this.accNum = accNum;
        this.balance = startingBalance;
    }

    addFunds(amount) {
        if (amount <= 0) {
            console.log("Deposit amount must be greater than zero.");
            return;
        }
        this.balance += amount;
        console.log(`Successfully added ₹${amount}. New balance: ₹${this.balance}`);
    }

    removeFunds(amount) {
        if (amount <= 0) {
            console.log("Withdrawal amount must be greater than zero.");
            return;
        }
        if (amount > this.balance) {
            console.log(`Insufficient balance! Current balance: ₹${this.balance}`);
            return;
        }
        this.balance -= amount;
        console.log(`Successfully withdrawn ₹${amount}. Remaining balance: ₹${this.balance}`);
    }

    showBalance() {
        console.log(`Account ${this.accNum} Balance: ₹${this.balance}`);
    }
}

let myAcc = new BankAccount(202501, 500);
myAcc.addFunds(1500);
myAcc.removeFunds(300);
myAcc.showBalance();
