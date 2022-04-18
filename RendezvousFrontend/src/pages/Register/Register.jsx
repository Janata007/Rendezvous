import { React, useContext, useEffect } from "react";
import { useNavigate } from "react-router-dom";
import AppContext from "../../context/app-context";
import logo from "../../assets/images/logo.png";
import "../Pages.css";
import "./Register.css";

const Register = () => {
  const appContext = useContext(AppContext);
  let navigate = useNavigate();

  useEffect(() => {}, [appContext]);

  return (
    <div className="register page">
      <img className="logo" src={logo} alt="rendezvous-logo" />

      <form action="" className="register-form">
        <input
          id="firstName"
          type="text"
          className="register-input"
          placeholder="First Name ..."
        />
        <input
          id="lastName"
          type="text"
          className="register-input"
          placeholder="Last Name ..."
        />
        <input
          id="email"
          type="text"
          className="register-input"
          placeholder="Email ..."
        />
        <input
          id="password"
          type="password"
          className="register-input"
          placeholder="Password ..."
        />
      </form>

      <button className="btn">Register</button>
      <button
        className="btn"
        onClick={() => {
          navigate("/");
        }}
      >
        Back to Homepage
      </button>
    </div>
  );
};

export default Register;
