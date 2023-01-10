import { useState, useEffect } from "react";
import { useDispatch, useSelector } from "react-redux";
import { Navbar } from "../../components/navbar/navbar";
import { addTodo, checkTodo, removeTodo, selectCount} from "../../store/todo";
import './todo.css'


function Todo() {
 
  const dispatch = useDispatch();
  const todoX = useSelector((state) => state.list);
  // console.log("TODOX",todoX)
  // console.log("TODOX L",todoX.length)


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

  const handleClick = async e => {
    e.preventDefault();
   
    try {
      if (todo.length == 0) {
        alert("Input Todo Tidak Boleh Kosong")
        return false
      }
      dispatch(addTodo({id: Math.random(), title: todo, completed: false}))
      // const newTodos = [...todos, {id: todos.length +1, title: todo, completed: false} ]
      // setTodos(newTodos)
      // setTodo('')
    } catch (err) {
    }
  }

  const handleDelete = async (index) => {
    try {
      dispatch(removeTodo(index))
      // const newTodos = [...todos];
      // newTodos.splice(index, 1); 
      // setTodos(newTodos);
    } catch (err) { }
  };

  const handleCheck = async (index) => {
    try {
      dispatch(checkTodo(index))
      // const newTodos = [...todos];
      // newTodos[index].completed = !newTodos[index].completed;
      // setTodos(newTodos);
    } catch (err) { }
  };

   

  return (
    <div>
      <Navbar/>
      <div className="container">
      <h1>Todos</h1>
      
        <div className='formInput'>
        <input className="inputTodo" value={todo} onChange={e=>setTodo(e.target.value)} type="text" placeholder="Add Todo..." id="title" />
        <button className="btnAdd" onClick={handleClick}>Send</button>
        </div>


      <div className='list'> 
        {todoX && todoX.map((item, index) => (
          <div className="row" key={index}>
            <input type="checkbox" className="checkbox" defaultChecked={item.completed} onClick={() => dispatch(checkTodo(index))} />
            <p className="titleTodo" style={item.completed ? { textDecoration: "line-through", color: "gray" } : { textDecoration: "" } }>{item.title}</p>
            <button className="btnDelete" onClick={() => dispatch(removeTodo(item.id))}>Delete</button>
          </div>
        ))}
      </div>
      </div>
    </div>
  );
}

export default Todo;