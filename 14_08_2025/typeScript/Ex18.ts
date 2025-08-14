enum HttpStatusCode{
    OK=200,
    NOTFOUND=404,
    ACCESSDENIED=403,
    INTERNALERRO=500
}
let code: HttpStatusCode = HttpStatusCode.OK;
console.log("Status Code:", code);              
console.log("Not Found:", HttpStatusCode.NOTFOUND)