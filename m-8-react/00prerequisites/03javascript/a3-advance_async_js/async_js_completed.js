//synchronous-> code will be execute in sequential manner


// alert("synchronous Programming ");

// const sms= function showMessage(){
//     let str="This is a synchronous java script";
//     return str;
// }
     

// const error=function showMessage(){
//     let str1="an error occured";
//     return str1;
// }

//asynchronous-> code will be execute in non-sequential manner
// callback:passing function as a parameter
//There are several ways to write asynchronous coding 

    /*
    1.setTimeOut(callback,time)
    2.setInterval(callback,time)
    3.promise((resolve,rejected)=>{}).then((success)=>{print(success)}).catch((err)=>{print(failed)}).     ***resolve->then,reject->catch
    4.aync await
    5.fetch().
    *6.axios();
    *7.Ajax-Asynchronous javascript xml
    
    */


    // 1.setTimeOut(callback,time)
    // const assignment1=()=>{
    //     document.write("Asssignments is completed in 1 day");
    // }
    // const assignment2=()=>{
    //     document.write("Asssignments is completed in 5 day");
    // }
    // const assignment3=()=>{
    //     document.write("Asssignments is completed in 3 day");
    // }
    
    // const assignment4=()=>{
    //     document.write("Asssignments is completed in 10 day");
    // }
    // setTimeout(assignment1,1000);
    // setTimeout(assignment2,5000);
    // setTimeout(assignment3,3000);
    // setTimeout(assignment4,10000);
    
    const fBottle=()=>{
        document.write("Task1: Bottle filled with water please take it <br>");
    }

    const fBucket=()=>{
        document.write("Task2: Bucket filled with water please take it <br>");
    }


    const ironOnClothe=()=>{
        document.write("Task3: IronOnClothe completed <br>");
    }

    const cookingFood=()=>{
        document.write("Task4: Cooking food to lunch <br>");
    }

    const goToMarket=()=>{
        document.write("Task5: Go to Market buy vegitables<br>");
    }

//     document.write("-----------------------------------------------");
//     fBottle();
//     fBucket();
//    document.write("-----------------------------------------------");

//     setTimeout(goToMarket,1000);//----------after [Side Stack] calling the api(function) goto --->[Min Stack]

//     setTimeout(fBottle,1500);//----------after [Side Stack] calling the api(function) goto --->[Min Stack]

//     setTimeout(cookingFood,2000);//----------after [Side Stack] calling the api(function) goto --->[Min Stack]
    
//     setTimeout(ironOnClothe,2500);//----------after [Side Stack] calling the api(function) goto --->[Min Stack]
    
//     setTimeout(fBucket,3000);//----------after [Side Stack] calling the api(function) goto --->[Min Stack]

//     document.write("-----------------------------------------------")
//     ironOnClothe();
//     cookingFood();
//     goToMarket();
//     document.write("-----------------------------------------------");


    //2.setInterval(callback,time)


    
   
//    document.write("-----------------------------------------------");

//     setInterval(goToMarket,10000);//----------after [Side Stack] calling the api(function) goto --->[Min Stack]

//     setInterval(fBottle,15000);//----------after [Side Stack] calling the api(function) goto --->[Min Stack]

//     setInterval(cookingFood,20000);//----------after [Side Stack] calling the api(function) goto --->[Min Stack]
    
//     setInterval(ironOnClothe,25000);//----------after [Side Stack] calling the api(function) goto --->[Min Stack]
    
//     setInterval(fBucket,30000);//----------after [Side Stack] calling the api(function) goto --->[Min Stack]

const age = ()=>{
    let age=12;
   
    if(age>=18){
        document.write("Drive your Bike")
    }
    else{
        document.write("Not eligible")
    }

}
//setTimeout(age,1500)
//setInterval(age,15000)
   //3.promise()

//  const p1=new Promise((resolve,reject)=>{
//     let i=18;
//         if(i===5){
//              resolve("resolve");
//         }else{
//             reject("failed");
//         }
//    });
//   const response= p1
//    .then((success)=>{
//          document.write("asynchronus: promise resolved successfully ");
//    })
//    .catch((failed)=>{
//          document.write( "asynchronus: promise failed please reload or check your internet ");
//    });
//   document.write("synchronous<br>")
   


//concept of promise chaining

//promise chaining a draw back to resolved  by  async and await note** one await replace by one then()

// const A = (age) => {
//     return new Promise((valid, invalid) => {
//         if (age >= 18) {
//             valid("Valid Age for " + age);
//         } else {
//             invalid("Invalid Age for " + age);
//         }
//     });
// };


// First Promise (p1): Check age 20
// p1 = A(20)
//     .then((valid) => {
//         console.log("First check passed:", valid);  // Log the correct result
//         return A(12);  // Chain another promise
//     })
//     .catch((invalid) => {
//         console.log("First check failed:", invalid);
//         document.write("Error in p1: " + invalid + "<br>");
//         return invalid;
//     });

// // Second Promise (p2): Check age 12 (chained after p1)

// p2 = p1
//     .then((valid) => {
//         console.log("Second check passed:", valid);  // Log the correct result
//         return A(30);  // Chain another promise
//     })
//     .catch((invalid) => {
//         console.log("Second check failed:", invalid);  // Handle failure of p2
//         document.write("Error in p2: " + invalid + "<br>");
//         return invalid;
//     });


// // Third Promise (p3): Check age 30 (chained after p2)
// p3 = p2
//     .then((valid) => {
//         console.log("Third check passed:", valid);  // Log the correct result
//         document.write("Status: " + valid + "<br>");
//         return valid;
//     })
//     .catch((invalid) => {
//         console.log("Third check failed:", invalid);  // Handle failure of p3
//         document.write("Error in p3: " + invalid + "<br>");
//         return invalid;
//     });


// // Log resolved or rejected promises after the chain completes
// p1.finally(() => console.log("p1 resolved/rejected:", p1));
// p2.finally(() => console.log("p2 resolved/rejected:", p2));
// p3.finally(() => console.log("p3 resolved/rejected:", p3));

const A = (age) => {
    return new Promise((valid, invalid) => {
        if (age >= 18) {
            valid("Valid Age for " + age);
        } else {
            invalid("Invalid Age for " + age);
        }
    });
};
//5.async await

const checkAges = async () => {
    try {
        // First check (age 20)
        const result1 =  await A(20);
        console.log("First check passed:", result1);  // Log result of first check
        
        // Second check (age 12)
        const result2 = await A(12);
        console.log("Second check passed:", result2);  // Log result of second check

        
    } catch (error) {
        // Catch any errors from the promises
        console.log("An error occurred:", error);
        document.write("Error: " + error + "<br>");
    } finally {
        // Log the completion of the entire process
        console.log("All checks completed.");
    }
};

// Call the async function
// checkAges();


//6.fetch() API
// const fetchData = async () => {
//     try {
//         const response = await fetch('api.json'); // Fetch data from API(It may be any json data or end-point like https://example.com/api/data)
//         const data = await response.json();  // Convert response to JSON

//         const rootDiv = document.querySelector('.root');  // Select the root div
//         rootDiv.style.backgroundColor = 'white';  // Set the background color to black

//         data.map(user => {
//             // Create a user card container
//             const userCard = document.createElement('div');
//             userCard.classList.add('user-card');  // Add class for styling

//             // Add user data into the card
//             userCard.innerHTML = `
//                 <h3>${user.name}</h3>
//                 <p><strong>ID:</strong> ${user.id}</p>
//                 <p><strong>Email:</strong> ${user.email}</p>
//                 <p><strong>City:</strong> ${user.address.city}</p>
//                 <p><strong>Street:</strong> ${user.address.street}</p>

.//                 <p><strong>Coordinates:</strong> Latitude ${user.address.geo.lat}, Longitude ${user.address.geo.lng}</p>
//             `;

//             // Create and append the remove button
//             const removeButton = document.createElement('button');
//             removeButton.textContent = 'Remove Card';
//             removeButton.classList.add('remove-btn');  // Add class for styling

//             // Add click event to the button to remove the card
//             removeButton.addEventListener('click', () => {
//                 rootDiv.removeChild(userCard);
//             });

//             // Append the button to the user card
//             userCard.appendChild(removeButton);

//             // Append the card to the root div
//             rootDiv.appendChild(userCard);
//         });

//     } catch (error) {
//         document.write('Error: ' + error);  // Handle and display any fetch errors
//     }
// };

// fetchData();

//promise with fetch


const getData=()=>{
    return new Promise((resolved,rejected)=>{
            //calling your api
            const respons=fetch('https://jsonplaceholder.org/posts');
            document.write(respons);
            respons.then((respons)=>{
                if(respons.ok){
                    resolved(respons);
                }else{
                    rejected("data failed to fetch");
                }
            });
           
    });
}


getData()
    .then((resolved)=>{
        const res= resolved.json();
        return res;
    })
    
    .then((data)=>{
            //print your data on screen
            console.log(data);
            data.forEach(element => {
                document.write(element.id+": "+element.slug +": "+element.url+"<br>");
            });

    })
    .catch((rejected)=>{
        document.write(rejected);
    });
//end