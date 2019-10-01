document.getElementById("test").addEventListener('click', function () {
    let form = document.getElementById('create-contact');
    let dataToSend = new FormData(form);
    let json = JSON.stringify(Object.fromEntries(dataToSend));
    request(json, "POST", "http://localhost:8080/contacts");
})

document.getElementById("button-list-contact").addEventListener('click', function () {
      var showList = document.getElementById('show-list');
      showList.innerHTML = "";
      let page = 0;
      request(null, "GET", "http://localhost:8080/contacts?p=" + page + "&s=5&by=firstName");
      showList.innerHTML = ttest;
})