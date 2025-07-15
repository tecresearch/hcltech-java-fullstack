
const postData=async ()=>{
       const response= await fetch('http://localhost:150/rest-api/get');
        console.log(response.json());
}

postData();