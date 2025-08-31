
import { Provider } from 'react-redux'
import { store } from './redux-container/BookStore'
import BookComponent from './components/BookComponent'


function App() {
  return (
   
    <Provider store={store}>
    <div className="App">
            <BookComponent/>
        </div>
    </Provider>
   
  )
}

export default App
