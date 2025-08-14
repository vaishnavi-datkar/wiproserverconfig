var HttpStatusCode;
(function (HttpStatusCode) {
    HttpStatusCode[HttpStatusCode["OK"] = 200] = "OK";
    HttpStatusCode[HttpStatusCode["NOTFOUND"] = 404] = "NOTFOUND";
    HttpStatusCode[HttpStatusCode["ACCESSDENIED"] = 403] = "ACCESSDENIED";
    HttpStatusCode[HttpStatusCode["INTERNALERRO"] = 500] = "INTERNALERRO";
})(HttpStatusCode || (HttpStatusCode = {}));
var code = HttpStatusCode.OK;
console.log("Status Code:", code);
console.log("Not Found:", HttpStatusCode.NOTFOUND);
