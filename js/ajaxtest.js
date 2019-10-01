function request(jsonToSend = null, method, url) {

    let xhr = new XMLHttpRequest();
    xhr.open(method, url);
    if (method == "POST") {
        xhr.setRequestHeader("Content-Type", "application/json");
    }
    xhr.onreadystatechange = function () {
        if (this.readyState === XMLHttpRequest.DONE && this.status === 200 && method != "GET") {
            document.getElementById('create-contact').reset();
            console.log("requete pas GET");
        } else if (this.readyState === XMLHttpRequest.DONE && this.status === 200 && method == "GET") {
            let ttest = JSON.parse(this.responseText);
            return ttest;
        } else if (this.readyState === XMLHttpRequest.DONE && this.status != 200) {
            console.log("erreur")
            console.log(this.status);
            console.log(this.readyState);
            console.log(jsonToSend);
        }
    }
    xhr.send(jsonToSend);
}