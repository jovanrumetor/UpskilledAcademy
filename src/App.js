import logo from './logo.svg';
import './App.css';
import Todo from './todo/index.js'
import Form from './todo/form.js'
import List from './todo/list.js'

function App() {
  return (
    <div className="App">
      {/* <Form />
      <List /> */}
      <Todo />
    </div>
  );
}

export default App;
