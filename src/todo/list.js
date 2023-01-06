import { useState } from "react";
import data from './todo.js'

function List() {

  return (
    <div className="App">
    <div className='list'> 
      {data.map((item) => (
        <div key={item.id}>
          <input type="checkbox" />
          <p>{item.title}</p>
        </div>
      ))}
    </div>

    </div>
  );
}

export default List;