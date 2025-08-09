
import { CiHeart } from "react-icons/ci";
import { FaEdit } from "react-icons/fa";
import { MdDelete } from "react-icons/md";
import { MdAddTask } from "react-icons/md";

function Cards({home,setInputDiv}) {
  // Sample data with 10 items
  const data = [
    { title: "Complete React Project", desc: "Finish building the task manager app with React and Tailwind CSS.",status:"In Complete" },
    { title: "Review Code for PR", desc: "Go through the pull request submitted by the team and provide feedback." ,status:"Complete"},
    { title: "Update Documentation", desc: "Update the project documentation to include recent changes and new features.",status:"In Complete" },
    { title: "Fix Bug in Authentication", desc: "Resolve the issue with user login and authentication flow.",status:"In Complete" },
    { title: "Design Homepage Layout", desc: "Work on the homepage UI design and get feedback from the design team.",status:"Complete" },
    { title: "Write Unit Tests", desc: "Write unit tests for the new API endpoints to ensure reliability." ,status:"In Complete"},
    { title: "Submit Expense Report", desc: "Complete and submit the monthly expense report for the finance team.",status:"Complete" },
   
  ];
  


  return (
    <div className="grid grid-cols-4 gap-4 p-4">
      {/* Map through data and display cards */}
      {data.map((item, i) =>(
       
        <div className="flex flex-col justify-between border rounded-lg p-4 bg-gray-800">
            <div key={i} className=" bg-gray-800 text-white flex flex-col gap-4" >
                <h3 className="text-lg font-semibold">{item.title}</h3>
                <hr/>
                <p className="text-sm">{item.desc}</p>
             </div>

            <div className="flex mt-4 w-full  items-center">
               
                <button className={`${item.status==="In Complete" ? "bg-red-400":"bg-green-700"} p-2 rounded mt-4 w-3/6`}>
                    {item.status}
                </button>
                <div className="text-white  p-2 w-3/6 text-2xl font-semibold flex justify-around mt-4" >
                    <button><CiHeart /></button>
                    <button><FaEdit/></button>
                    <button><MdDelete/></button>
                </div>
            
             </div>

        </div>

      ))} 
      {home==="true" && (
      <button onClick={()=>setInputDiv("fixed")} className="flex flex-col justify-center items-center border rounded-lg p-4 bg-gray-800 hover:scale-105 hover:cursor-pointer transition-all duration-300">
        <MdAddTask className="text-5xl"/>
        <h2 className="text-2xl mt-4 p-2">Add Task</h2>
        </button>
      )}
        
    </div>
  );
}

export default Cards;
