let names=["vaishnavi","Aditi","Sayali","Gayatri"];
let n=names
.filter(name=> name.length>5)
.map(name =>name.toUpperCase());
 document.write("Original Names: " + names.join(", ") + "<br>");
        document.write("Filtered & Uppercase: " + n.join(", "));