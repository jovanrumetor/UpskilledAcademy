import { useState } from "react";
import data from './todo.js'

function Form() {
  const [todo, setTodo] = useState()
  console.log(todo, "todo")
  const handleChange = (e) => {
    setTodo((prev)=>({...prev,[e.target.id]:e.target.value}))
  }
  
  const handleClick = async e => {
    e.preventDefault();
    try {
      data.push(todo)
      console.log(data)
    } catch (err) {
    }
  }
  return (
    <div className="App">
    <h1>Todos</h1>
    
    <form>
      <div className='formInput'>
      <input onChange={handleChange} type="text" placeholder="Add Todo..." id="todo" />
      </div>
      <button onClick={handleClick}>Send</button>
    </form>
    </div>
  );
}

export default Form;