export const request = (method, url, data = null) => {
    return new Promise((resolve, reject) => {
        const req = new XMLHttpRequest();

        req.onreadystatechange = function () {
            if (this.readyState === XMLHttpRequest.DONE && this.status === 200 && method === "GET") {
                const response = JSON.parse(req.responseText);
                resolve(response);
            } else if (this.readyState === XMLHttpRequest.DONE && this.status === 200 && method !== "GET") {
                resolve();
            } else if (this.readyState === XMLHttpRequest.DONE && this.status !== 200) {
                reject("Il y a eu une erreur");
            }
        }

        req.open(method, url);

        if (method === "POST") {
            req.setRequestHeader('Content-Type', 'application/json');
        }

        req.send(data);
    })
}