import axios from "axios";
import { addTodo } from "../store/todo";

export async function fetchTodos(dispatch) {
  try {
    const res = await axios.get(process.env.REACT_APP_API + 'todos');
    dispatch(addTodo(res.data.slice(0, 10)));
  } catch (error) {
    console.error(error);
  }
}