import React, { Component } from 'react'

export default class StateClassComponent extends Component {
  constructor(){
    super();
    this.state={counter:0,
      data:[]
    };
  }
  increment(){
    this.setState({counter:this.state.counter+1})
    this.setState({data:[...this.state.data,this.state.counter+1]});
    console.log(this.state.data);

      this?.state?.data?.map((item)=>{
           console.log(item);
           
      })
    
  }

  render() {
    const {data,counter}=this.state;
    return (
      <div>
        <h1>Class Component</h1>
      
        <button onClick={()=>this.increment()}>++Counter<sub>
         <div>[
            {
            data.map((item)=>{
              return <>,{item}</>
            })
          }]<sup>{counter}</sup>
         </div>
        </sub></button>
      </div>
    )
  }
}
