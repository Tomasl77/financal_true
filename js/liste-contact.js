import { request } from './functions/request.js';
import buildTable from './functions/build-table.js';

let currentPage = 0;
let elements = 5;
let filter = "id";

request("GET", `http://localhost:8080/contacts?p=${currentPage}&s=${elements}&by=${filter}`)
.then((contacts) => {
    buildTable(contacts);
});

document.getElementById("next").addEventListener("click", () => {
    currentPage++;

    request("GET", `http://localhost:8080/contacts?p=${currentPage}&s=${elements}&by=${filter}`)
    .then((contacts) => {
        buildTable(contacts);
    })
})

document.getElementById("prev").addEventListener("click", () => {
    currentPage--;

    request("GET", `http://localhost:8080/contacts?p=${currentPage}&s=${elements}&by=${filter}`)
    .then((contacts) => {
        buildTable(contacts);
    })
})