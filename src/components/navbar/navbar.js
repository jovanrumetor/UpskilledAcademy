import { useState } from 'react'
import DashboardIcon from "@mui/icons-material/Dashboard";
import MenuIcon from '@mui/icons-material/Menu';
import CloseIcon from '@mui/icons-material/Close';
import InfoIcon from '@mui/icons-material/Info';
import HowToRegIcon from '@mui/icons-material/HowToReg';
import { Link, useNavigate,   } from "react-router-dom";
import './navbar.css'

export const Navbar = () => {

const [navbar, SetNavbar] = useState(false);

  return (
    <div className="navbar">
    {navbar ? <>
    <CloseIcon className="icon" onClick={e=>SetNavbar(false)}/>

      <div className="top">    
        <Link to="/" style={{ textDecoration: "none" }}>
          <span className="logo">Alterra</span>
        </Link>
      </div>
      <div className="center">
        <ul>
          <Link to="/" style={{ textDecoration: "none" }}>
          <li>
            <DashboardIcon className="icon" />
            <span>Home</span>
          </li>
          </Link>
          <Link to="/about" style={{ textDecoration: "none" }}>
          <li>
            <InfoIcon className="icon" />
            <span>About</span>
          </li>
          </Link>
          <Link to="/register" style={{ textDecoration: "none" }}>
          <li>
            <HowToRegIcon className="icon" />
            <span>Register</span>
          </li>
          </Link>
          </ul>
        </div></>
        : <MenuIcon className="icon" onClick={e=>SetNavbar(true)} />}
      </div>
  )
}
