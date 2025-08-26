import React from 'react';

class LifeCycle extends React.Component {
/**
 * 
 * @param {Explanation of React Class Component Lifecycle
React class components have a defined lifecycle, 
allowing you to run code at specific points during the component’s 
existence. Here's a breakdown of the lifecycle stages and methods 
used in the provided code:

Constructor:

The constructor(props) method is called when the component 
is first created. It initializes the component's state and binds
 methods to this. It is a good place to set initial state values.
In the example, it initializes the count state to 0.
componentDidMount:

This method is invoked immediately after the component is added 
to the DOM. It’s a great place for data fetching, subscriptions, 
or starting timers.
Here, an interval is set up to increment the count state every 
second using setInterval(), which also demonstrates how to interact
 with the component's state after rendering.
componentDidUpdate:

This method is called after updates to the component’s props or state.
 It can be used to perform actions in response to prop or state changes.
In the example, it checks if the count state has changed and logs the 
new count value. This helps in debugging and understanding how updates
 change component behavior.
componentWillUnmount:

Before a component is removed from the DOM, this method is called. 
It is used to clean up resources, such as invalidating timers or 
canceling network requests.
In the provided example, the interval set in componentDidMount 
is cleared to prevent memory leaks when the component unmounts.
Render Method:

The render() method is where the JSX markup is returned. 
It defines what should be displayed on the screen.
In this example, it simply displays the current count.
Best Practices:
Always clean up side effects in componentWillUnmount to prevent memory leaks.
Use componentDidUpdate carefully to avoid unnecessary
 re-renders or infinite loops. Check previous state/props before making updates.
For newer applications, consider using function components
 with hooks (like useEffect) as they often provide a more 
 straightforward approach to managing lifecycle events.} props 
 */
  // Mounting phase
  constructor(props) {
    super(props);
    this.state = { count: 0 }; // Initial state
    console.log('Constructor: Initializing state');
  }

  componentDidMount() {
    // Called after the component is mounted
    console.log('ComponentDidMount: Component is mounted');
   
  }

  componentDidUpdate(prevProps, prevState) {
    // Called after updates are flushed to the DOM
    console.log('ComponentDidUpdate: Component updated');
    if (prevState.count !== this.state.count) {
      console.log('Count changed to:', this.state.count);
    }
  }

  componentWillUnmount() {
    // Cleanup before the component is unmounted
    console.log('ComponentWillUnmount: Cleaning up');
    
  }

  render() {
        console.log('Render: Rendering the component');
        return <div>Count: {this.state.count}
        <button onClick={()=>this.setState({count:this.state.count+1})}>increment</button>
        </div>;
  }
}

export default LifeCycle;




