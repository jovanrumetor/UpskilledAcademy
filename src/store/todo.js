import { createSlice } from "@reduxjs/toolkit";

const initialState = {
  list: [],
}

export const todoSlice =  createSlice ({
  name: "todo",
  initialState,
  reducers: {
    addTodo: (state, payload) => { 
      let data = payload.payload
      if (payload.payload.length === undefined) {
        state.list = [...state.list, payload.payload];
      } else {
        state.list = [...state.list, ...payload.payload];
      }
      console.log("payload", data)
    
      // return {list: [...state.list, ...payload.payload]};
    },
    removeTodo: (state, payload) => {
      let { list } = state;
      //  console.log("RT", payload.payload)
      // console.log("RT LIST", list)
      state.list = list.filter((item) => item.id !== payload.payload);
      // console.log("RT", payload.payload)
      // let newList = state.list.filter((todo) => todo.id !== payload.payload);
      // console.log("NL", newList)
      // return state.list.filter((item) => item.id !== payload.payload);
    },
    checkTodo: (state, payload) => {
      console.log(state)
      let { list } = state;
      console.log(payload)
      // console.log(...state.list)
      list[payload.payload].completed = !list[payload.payload].completed;
      state.list = list

      // state.list = list.map((item) => item.id === payload.payload ? item.completed = !item.completed : item);
      
      // console.log("pl todo",payload)
      // const newTodos = [...state.list];
      // console.log("new todos",state.list)
      // newTodos[payload].completed = !newTodos[payload].completed;
      // return  {list: [newTodos]}
    }
  }
});
// export const selectCount = state => state.list;

export const { addTodo, removeTodo, checkTodo } = todoSlice.actions;
export default todoSlice.reducer