

export const chat = (prompt) => {
    fetch(`http://localhost:8080/ai?q=${prompt}`)
        .then(res => res.text()) // first read as text
        .then(text => {
            const data = JSON.parse(text); // try parsing JSON
            console.log("JSON response:", data);
            return data.result;
        }).catch(e=>{
            console.log("something went wrong");
        })

}