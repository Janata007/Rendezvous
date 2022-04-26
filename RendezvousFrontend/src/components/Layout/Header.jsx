import React from "react";
import { useNavigate } from "react-router-dom";
import logo from "../../assets/images/logo.png";
import "./Header.css";

const Header = () => {
  let navigate = useNavigate();
  return (
    <header className="header">
      <ul className="header-items">
        <li className="header-item">
          <div
            className="profile-link"
            onClick={() => navigate("profile")}
          ></div>
        </li>
        <li className="header-item">
          <img className="logo header-logo" src={logo} alt="rendezvous-logo" />
        </li>
        <li className="header-item"></li>
      </ul>
    </header>
  );
};

export default Header;
