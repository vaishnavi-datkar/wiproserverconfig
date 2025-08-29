var Box = /** @class */ (function () {
    function Box(value) {
        this.value = value;
    }
    Box.prototype.getValue = function () {
        return this.value;
    };
    return Box;
}());
var num = new Box(20);
console.log(num.getValue());
var str = new Box("vaishnavi");
console.log(str.getValue());
var bool = new Box(true);
console.log(bool.getValue());
