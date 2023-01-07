import logo from './logo.svg';
import './App.css';
import Todo from './pages/todo/todo.js';
import About from './pages/about/about.js';
import Register from './pages/register/register';
import Page404 from './pages/page404/page404.js';
import { BrowserRouter, Routes, Route, Navigate } from "react-router-dom";

function App() {
  return (
    <div className="App">
      
    <BrowserRouter>
      <Routes>
        <Route path='/' element={<Todo/>} />
        <Route path='/about' element={<About/>} />
        <Route path='/register' element={<Register/>} />
        <Route path='*' element={<Page404/>} />
      </Routes>
    </BrowserRouter>
    </div>
  );
}

export default App;
