import React from 'react'
import { CgNotes } from "react-icons/cg"
import { MdLabelImportant } from "react-icons/md"
import { FaCheckDouble } from "react-icons/fa"
import { TbNotebookOff } from "react-icons/tb"
import {Link} from 'react-router-dom'
const  Sidebar=()=> {
  const data=[
    {title:" All task",
      icon:<CgNotes/>,
      link:"/"
    }
    ,
    {title:" Important task",
      icon:<MdLabelImportant/>,
      link:"/importantTasks"
    }
    ,
    {title:" Completed task",
      icon:<FaCheckDouble />,
      link:"/completedTasks"
    },
    {title:" incompleted task",
      icon:<TbNotebookOff />,
      link:"/incompletedTasks"
    }
  ];
    return (
    <>
    <div>
    <h2 className="text-xl font-semibold">Mr.Brijesh Nishad</h2>
    <h4 className="mb text-gray-400">bnlv1212@gmail.com</h4>
    <hr />
      </div>  
      <div>
         {
          data.map((items,i)=>(
            <Link 
            to={items.link}
            key={i}
            className="my-2 flex items-center p-2 hover:bg-gray-600 rounded transition-all">
              {items.icon} {items.title}
            </Link>
          ))
        }
      </div>
        <div>
          <button className="bg-gray-600 w-full p-2 rounded">Log Out</button>
        </div>
       </>
  )
}

export default Sidebar