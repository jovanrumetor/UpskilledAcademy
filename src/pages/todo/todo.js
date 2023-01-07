import { useState, useEffect } from "react";
import { Navbar } from "../../components/navbar/navbar";
import './todo.css'


function Todo() {
  
  // let data = [
  //   {
  //     id: 1,
  //     title: "Mengerjakan Exercise",
  //     completed: true
  //   },
  //   {
  //     id: 2,
  //     title: "Mengerjakan Assignment",
  //     completed: false
  //   }
  // ]
  const [todo, setTodo] = useState('')
  const [todos, setTodos] = useState([
      {
        id: 1,
        title: "Mengerjakan Exercise",
        completed: true
      },
      {
        id: 2,
        title: "Mengerjakan Assignment",
        completed: false
      }
    ])

  const handleChange = (e) => {
    setTodo((prev)=>({...prev,[e.target.id]:e.target.value}))
  }

  // useEffect(() => {
  //   setList(data)
  // },[data])
// console.log(todos)
  const handleClick = async e => {
    e.preventDefault();
   
    try {
      if (todo.length == 0) {
        alert("Input Todo Tidak Boleh Kosong")
        return false
      }
      const newTodos = [...todos, {id: todos.length +1, title: todo, completed: false} ]
      setTodos(newTodos)
      setTodo('')
    } catch (err) {
    }
  }

  const handleDelete = async (index) => {
    try {
      const newTodos = [...todos];
      newTodos.splice(index, 1);
      setTodos(newTodos);
    } catch (err) { }
  };

  const handleCheck = async (index) => {
    try {
      const newTodos = [...todos];
      newTodos[index].completed = !newTodos[index].completed;
      setTodos(newTodos);
    } catch (err) { }
  };

   

  return (
    <div>
      <Navbar/>
      <div className="container">
      <h1>Todos</h1>
      
      <form>
        <div className='formInput'>
        <input className="inputTodo" value={todo} onChange={e=>setTodo(e.target.value)} type="text" placeholder="Add Todo..." id="title" />
        <button className="btnAdd" onClick={handleClick}>Send</button>
        </div>
      </form>

      <div className='list'> 
        {todos.map((item, index) => (
          <div className="row" key={index}>
            <input type="checkbox" className="checkbox" defaultChecked={item.completed} onClick={() =>handleCheck(index)} />
            <p className="titleTodo" style={item.completed ? { textDecoration: "line-through", color: "gray" } : { textDecoration: "" } }>{item.title}</p>
            <button className="btnDelete" onClick={() =>handleDelete(index)}>Delete</button>
          </div>
        ))}
      </div>
      </div>
    </div>
  );
}

export default Todo;